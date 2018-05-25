package com.mygdx.game;




import android.app.Fragment;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    private TextView lblRUser;
    public EditText txtfRUser;
    private TextView lblRPass;
    public EditText txtfRPass;
    public Button btnRBack;
    public Button btnROK;
    public RegisterFragmentListener listener;


    public RegisterFragment() {
        // Required empty public constructor
    }

    public void setListener (RegisterFragmentListener listener){
        this.listener = listener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_register, container, false);
        lblRUser = v.findViewById(R.id.lblRUser);
        txtfRUser = v.findViewById(R.id.txtfRUser);
        lblRPass = v.findViewById(R.id.lblRPass);
        txtfRPass = v.findViewById(R.id.txtfRPass);
        btnRBack = v.findViewById(R.id.btnRBack);
        btnROK = v.findViewById(R.id.btnROK);
        RegisterFragmentEvents events = new RegisterFragmentEvents(this);
        btnRBack.setOnClickListener(events);
        btnROK.setOnClickListener(events);

        return v;
    }

}

class RegisterFragmentEvents implements View.OnClickListener{
    private RegisterFragment registerFragment;

    //Se pasa la referencia por parámetro y se inicializa la variable
    public RegisterFragmentEvents (RegisterFragment fragment){
        this.registerFragment = fragment;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()== this.registerFragment.btnRBack.getId()){
            this.registerFragment.listener.RegisterFragmentBackButtonClicked();
        }else if (view.getId()== this.registerFragment.btnROK.getId()){
            Log.v("EEE1", "oofofof"+this.registerFragment.txtfRUser.getText().toString());
            this.registerFragment.listener.RegisterFragmentOKButtonClicked(this.registerFragment.txtfRUser.getText().toString()
                    ,this.registerFragment.txtfRPass.getText().toString());
        }
    }
}
