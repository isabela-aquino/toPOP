package com.example.topop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.topop.R;
import com.google.android.material.snackbar.Snackbar;

public class activity_registrar extends AppCompatActivity {

    public TextView textViewEntrarAgora;
    public ImageView imageViewVoltarRegistrar;
    private EditText edit_nome, edit_email, edit_senha, edit_confirmasenha;
    private Button btn_TelaRegistrar;
    String[] mensagens = {"Preencha todos os campos", "login ok", "Senhas incompatíveis"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        textViewEntrarAgora = (TextView) findViewById(R.id.TvEntrarAgora);
        imageViewVoltarRegistrar = (ImageView) findViewById(R.id.voltarRegistrar) ;
        IniciarComponentes();

        textViewEntrarAgora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(activity_registrar.this, activity_login.class);
                startActivity(myIntent);
            }
        });

        imageViewVoltarRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(activity_registrar.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
        btn_TelaRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = edit_nome.getText().toString();
                String email = edit_email.getText().toString();
                String senha = edit_senha.getText().toString();
                String ConfirmaSenha = edit_confirmasenha.getText().toString();

                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || ConfirmaSenha.isEmpty()){
                    Snackbar snackbar = Snackbar.make(view, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.BLACK);
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();

                } else if (senha!=ConfirmaSenha){
                    Snackbar snackbar = Snackbar.make(view, mensagens[2], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.BLACK);
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else CadastrarUsuario();
            }
        });
    }
    private void CadastrarUsuario(){
        String nome = edit_nome.getText().toString();
        String email = edit_email.getText().toString();
        String senha = edit_senha.getText().toString();
        String ConfirmaSenha = edit_confirmasenha.getText().toString();

    }

    private void IniciarComponentes(){
        edit_nome = findViewById(R.id.txtUsenamer);
        edit_email = findViewById(R.id.txtEmail);
        edit_senha = findViewById(R.id.txtPassword);
        edit_confirmasenha = findViewById(R.id.txtConfirmPassword);
        btn_TelaRegistrar = findViewById(R.id.btnTelaRegistrar);
    }

}