package com.hodachop93.hohoda.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.hodachop93.hohoda.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {
    @Bind(R.id.edt_email)
    EditText edtEmail;
    @Bind(R.id.edt_user_name)
    EditText edtUsername;
    @Bind(R.id.edt_password)
    EditText edtPassword;
    @Bind(R.id.chk_terms_condition)
    CheckBox chkTermsCondition;
    @Bind(R.id.btn_create_account)
    Button btnCreateAccount;

    public SignUpFragment() {
        // Required empty public constructor
    }

    public static SignUpFragment newInstance() {
        return new SignUpFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.chk_terms_condition)
    public void checkTermsCondition() {
        if (chkTermsCondition.isChecked()) {
            btnCreateAccount.setEnabled(true);
        } else {
            btnCreateAccount.setEnabled(false);
        }
    }

    @OnClick(R.id.btn_create_account)
    public void createAccount() {
        //TODO create a new account
    }
}
