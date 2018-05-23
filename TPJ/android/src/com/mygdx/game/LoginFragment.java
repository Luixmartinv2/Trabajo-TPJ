package com.mygdx.game;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    private TextView lblUser;
    public EditText txtfUser;
    private TextView lblPass;
    public EditText txtfPass;
    public Button btnRegister;
    public Button btnLogin;
    /*Incorporamos la interface que se utilizara para llamar a sus metodos en el LoginFragmentEvent
    * Además la variable listener se utilizará como variable plantilla para setearle la clase que
    * está escuchando sus eventos.
    */
    public LoginFragmentListener listener;

    public LoginFragment() {
        // Required empty public constructor
    }

    /*
    * Este método setea qué clase es la que está escuchando al LoginFragmentListener. Es necesario este
    * método porque dependiendo de qué clases implementen la interfaz tendrán que indicar si estan escuchando.
    * Una vez que se sepa que clase/s externa escucha al LoginFragmentListener se pueden utilizar los métodos de la
    * inferfaz implementados en esa clase/s que escucha.
    *
    * En este caso, es el MainActivityEvents quien está esuchando al LoginFragmentListener y debemos saber que
    * esta interfaz será gestionada por el LoginFragmentEvents porque es en el onClick donde vamos a definir
    * que hace cada botón al ser pulsado.
    */
    public void setListener(LoginFragmentListener listener){
        this.listener = listener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        //Se vinculan las variables con la vista
        lblUser = v.findViewById(R.id.lblUser);
        txtfUser = v.findViewById(R.id.txtfUser);
        lblPass = v.findViewById(R.id.lblPass);
        txtfPass = v.findViewById(R.id.txtfPass);
        btnRegister = v.findViewById(R.id.btnRegister);
        btnLogin = v.findViewById(R.id.btnLogin);
        //Creamos objeto de la clase LoginFragmentEvents y le pasamos como referencia LoginFragment
        LoginFragmentEvents events = new LoginFragmentEvents(this);
        //Añadimos los listener a los botones y la clase que escucha sera LoginFragmentEvents
        btnRegister.setOnClickListener(events);
        btnLogin.setOnClickListener(events);

        return v;
    }

}

//Esta clase escucha los eventos de LoginFragment y solo es accesible desde LoginFragment
class LoginFragmentEvents implements View.OnClickListener{
    private LoginFragment loginFragment;

    //Se pasa la referencia por parámetro y se inicializa la variable
    public LoginFragmentEvents (LoginFragment fragment){
        this.loginFragment = fragment;
    }

    @Override
    public void onClick(View view) {
        //Si se pulsa el botón Registrar o si se pulsa el botón logearse
        if(view.getId()==this.loginFragment.btnRegister.getId()){
            //Se llama al método de la interfaz y se pasa por parámetro el usuario y la contraseña que lo recibira el
            //MainActivityEvents
            this.loginFragment.listener.LoginFragmentRegisterButtonClicked(this.loginFragment.txtfUser.getText().toString()
                    ,this.loginFragment.txtfPass.getText().toString());
        }else if (view.getId()==this.loginFragment.btnLogin.getId()){
            this.loginFragment.listener.LoginFragmentLoginButtonClicked(this.loginFragment.txtfUser.getText().toString()
                    ,this.loginFragment.txtfPass.getText().toString());
        }

    }
}

