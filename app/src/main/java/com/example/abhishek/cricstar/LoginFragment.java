package com.example.abhishek.cricstar;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener{
    TextView textView;
    Button login_button;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    public void onResume(){
        super.onResume();
        textView = getView().findViewById(R.id.click);
        textView.setOnClickListener(this);
        login_button = getView().findViewById(R.id.login_button);
        login_button.setOnClickListener(this);

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
                Intent intent = new Intent(getActivity(),DashboardActivity.class);
                startActivity(intent);

        }


    }

}
