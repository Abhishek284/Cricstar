package com.example.abhishek.cricstar;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener{
    TextView textView;
    Button login_button;
    EditText username, password;
    private SharedPreferences sharedPreferences;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        username = view.findViewById(R.id.username_et);
        password = view.findViewById(R.id.password_edt);

        textView = view.findViewById(R.id.click);
        textView.setOnClickListener(this);
        login_button = view.findViewById(R.id.login_button);
        login_button.setOnClickListener(this);
        sharedPreferences = getActivity().getSharedPreferences(getActivity().getPackageName(), Activity.MODE_PRIVATE);
    }

    public void onResume(){
        super.onResume();


    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.click:

                System.out.println("Calling the signup Fragment");
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                SignUpFragment fragment = new SignUpFragment();
                fragmentTransaction.replace(R.id.ffff, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;

            case R.id.login_button:



                sharedPreferences.edit().putString("Email",username.getText().toString()).apply();
                sharedPreferences.edit().putString("Password", password.getText().toString()).apply();
                Intent intent = new Intent(getActivity(),DashboardActivity.class);
                startActivity(intent);
                getActivity().finish();



        }


    }

}
