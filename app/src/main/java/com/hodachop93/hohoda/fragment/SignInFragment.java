package com.hodachop93.hohoda.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hodachop93.hohoda.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {
    @Bind(R.id.edt_user_name)
    EditText edtUsername;
    @Bind(R.id.edt_password)
    EditText edtPassword;
    @Bind(R.id.btn_sign_in)
    Button btnSignIn;
    @Bind(R.id.tv_forgot_password)
    TextView tvForgotPassword;
    @Bind(R.id.tv_sign_up)
    TextView tvSignUp;

    public SignInFragment() {
        // Required empty public constructor
    }

    public static SignInFragment newInstance() {
        return new SignInFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.btn_sign_in)
    public void signIn() {
        //TODO Sign in
    }

    @OnClick(R.id.tv_forgot_password)
    public void forgotPassword() {
        //TODO forgot password
    }

    @OnClick(R.id.tv_sign_up)
    public void signUp() {
        //TODO switch to sign up screen
    }

}
