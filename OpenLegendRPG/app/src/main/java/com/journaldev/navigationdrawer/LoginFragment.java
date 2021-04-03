package com.journaldev.navigationdrawer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;
import java.util.concurrent.ExecutionException;

import ca.unb.mobiledev.openlegendrpg.Items.User;
import ca.unb.mobiledev.openlegendrpg.R;
import ca.unb.mobiledev.openlegendrpg.UI.userViewModel;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class LoginFragment extends Fragment {
    private userViewModel mUserViewModel;
    private Button mLoginButton;
    private EditText mNameEditText;
    private EditText mPasswordEditText;
    private TextView subtitle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.login, container, false);
        subtitle = rootView.findViewById(R.id.tv_subtitle);
        mNameEditText = rootView.findViewById(R.id.et_name);
        mPasswordEditText = rootView.findViewById(R.id.et_password);
        mLoginButton = rootView.findViewById(R.id.btn_login);
        setupUI(rootView);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                String name = mNameEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();
                if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)){
                    try {
                        verify(name, password);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Context context = getActivity().getApplicationContext();
                    String text = "Incomplete Information";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                mNameEditText.setText("");
                mPasswordEditText.setText("");
            }
        });
        return rootView;
    }
    public void setupUI(View view) {
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(getActivity());
                    return false;
                }
            });
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (activity.getCurrentFocus() != null){
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }


    }
    private void verify(String name, String password) throws ExecutionException, InterruptedException {
        mUserViewModel = new ViewModelProvider(this).get(userViewModel.class);
        List<User> result = mUserViewModel.isUser(name, password);
        if(!result.isEmpty()){
            Context context = getActivity().getApplicationContext();
            String text = "Login Successful";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            subtitle.setText("You are logged into " + result.get(0).getName() + ", Feel free to login to a new account");

        }
        else{
            Context context = getActivity().getApplicationContext();
            String text = "Login Unsuccessful, Try Again";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            subtitle.setText("Login Failed");
        }
        mNameEditText.setText("");
        mPasswordEditText.setText("");
    }
}


