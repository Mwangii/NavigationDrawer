package com.example.navdrawer.ui.account;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.navdrawer.R;
import com.example.navdrawer.UserActivity;

public class AccountFragment extends Fragment {

    private AccountViewModel mViewModel;

    public static AccountFragment newInstance() {
        return new AccountFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       // return inflater.inflate(R.layout.account_fragment, container, false);
        View view=inflater.inflate(R.layout.account_fragment, container, false);
        Button btnNext=view.findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(),"A USERS ACCOUNT  is clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(),UserActivity.class));

            }
        });
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AccountViewModel.class);
        // TODO: Use the ViewModel
    }

}
