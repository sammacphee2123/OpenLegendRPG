package com.journaldev.navigationdrawer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

public class CreateAccountFragment extends Fragment {
    private userViewModel mUserViewModel;
    private Button mLoginButton;
    private EditText mNameEditText;
    private EditText mPasswordEditText;
    private EditText mEmailEditText;
    private EditText mRenterPasswordEditText;
    private TextView subtitle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.create_account, container, false);
        mNameEditText = rootView.findViewById(R.id.et_name);
        mPasswordEditText = rootView.findViewById(R.id.et_password);
        mEmailEditText = rootView.findViewById(R.id.et_email);
        subtitle = rootView.findViewById(R.id.tv_subtitle);
        mRenterPasswordEditText = rootView.findViewById(R.id.et_repassword);
        Button register = rootView.findViewById(R.id.btn_register);
        setupUI(rootView);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                String name = mNameEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();
                String email = mEmailEditText.getText().toString();
                String confirm = mRenterPasswordEditText.getText().toString();
                if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(confirm) && TextUtils.equals(password, confirm)){
                    try {
                        createAccount(name, password, email);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Context context = getActivity().getApplicationContext();
                    String text = "Incomplete information or password confirmation was not the same";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                mNameEditText.setText("");
                mPasswordEditText.setText("");
                mEmailEditText.setText("");
                mRenterPasswordEditText.setText("");
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
    private void createAccount(String name, String password, String email) throws ExecutionException, InterruptedException {
        mUserViewModel = new ViewModelProvider(this).get(userViewModel.class);
        boolean result = mUserViewModel.createUser(name, password, email);
        if(!result){
            subtitle.setText("Cannot create account username is taken");
        }
        else{
            subtitle.setText("AccountCreated, Login and you are set");
        }
        mNameEditText.setText("");
        mPasswordEditText.setText("");
        mEmailEditText.setText("");
        mRenterPasswordEditText.setText("");
    }
}