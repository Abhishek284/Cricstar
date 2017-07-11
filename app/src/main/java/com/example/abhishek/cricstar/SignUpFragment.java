package com.example.abhishek.cricstar;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment implements View.OnClickListener{

Button sign_up_button;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sign_up_button = view.findViewById(R.id.sinupbutton);
        sign_up_button.setOnClickListener(this);

    }

    public void onResume(){
        super.onResume();

    }
    public void onClick(View view){
        Intent intent = new Intent(getActivity(),DashboardActivity.class);
        startActivity(intent);

    }

}
