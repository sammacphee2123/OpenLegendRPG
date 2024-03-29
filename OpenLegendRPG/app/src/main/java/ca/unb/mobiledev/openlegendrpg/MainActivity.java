package ca.unb.mobiledev.openlegendrpg;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.journaldev.navigationdrawer.CreateAccountFragment;
import com.journaldev.navigationdrawer.LoginFragment;
import com.journaldev.navigationdrawer.banes.BanesFragment;
import com.journaldev.navigationdrawer.boons.BoonsFragment;
import com.journaldev.navigationdrawer.CoreRules.CoreRulesFragment;
import com.journaldev.navigationdrawer.DataModel;
import com.journaldev.navigationdrawer.DrawerItemCustomAdapter;
import com.journaldev.navigationdrawer.characters.CharacterFragment;
import com.journaldev.navigationdrawer.feats.FeatsFragment;
import com.journaldev.navigationdrawer.HomeFragment;

import java.util.Objects;

import ca.unb.mobiledev.openlegendrpg.Items.User;


public class MainActivity extends AppCompatActivity {

    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private static ListView mDrawerList;
    private static ActionBar actionBar;
    Toolbar toolbar;
    private CharSequence mTitle;
    ActionBarDrawerToggle mDrawerToggle;
    private static User user = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerList = findViewById(R.id.left_drawer);
        View header = getLayoutInflater().inflate(R.layout.header, null);

        setupToolbar();

        DataModel[] drawerItem = new DataModel[7];

        drawerItem[0] = new DataModel(R.drawable.corerules, "Core Rules");
        drawerItem[1] = new DataModel(R.drawable.banes, "Banes");
        drawerItem[2] = new DataModel(R.drawable.boons, "Boons");
        drawerItem[3] = new DataModel(R.drawable.feats, "Feats");
        drawerItem[4] = new DataModel(R.drawable.character, "Characters");
        drawerItem[5] = new DataModel(R.drawable.login, "Login");
        drawerItem[6] = new DataModel(R.drawable.create_account, "Create Account");

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerList.addHeaderView(header);
        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();

        selectItem(0);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new CoreRulesFragment();
                break;
            case 2:
                fragment = new BanesFragment();
                break;
            case 3:
                fragment = new BoonsFragment();
                break;
            case 4:
                fragment = new FeatsFragment();
                break;
            case 5:
                fragment = new CharacterFragment();
                break;
            case 6:
                fragment = new LoginFragment();
                break;
            case 7:
                fragment = new CreateAccountFragment();
            default:
                break;
        }

        if (fragment != null) {

            actionBar = getSupportActionBar();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            if(user == null) {
                setTitle(mNavigationDrawerItemTitles[position]);
            }
            else{
                setTitle(user.getName());
            }
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        Objects.requireNonNull(getSupportActionBar()).setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    void setupToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);

    }

    void setupDrawerToggle(){
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,R.string.app_name,R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }

    public static void setUser(User newuser) {
        user = newuser;
        setLoginHeader();
    }

    public static User getUser() {
        return user;
    }
    public static void setLoginHeader() {
        mDrawerList.setItemChecked(6, true);
        mDrawerList.setSelection(6);
        if(user == null) {
            Objects.requireNonNull(actionBar).setTitle("Login");
        }
        else {
            Objects.requireNonNull(actionBar).setTitle(user.getName());
        }
    }
}