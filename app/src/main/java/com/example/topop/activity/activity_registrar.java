package com.example.topop.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.topop.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class activity_registrar extends AppCompatActivity {

    public TextView textViewEntrarAgora;
    public ImageView imageViewVoltarRegistrar;
    private EditText edit_nome, edit_email, edit_senha, edit_confirmasenha;
    private Button btn_TelaRegistrar;
    String[] mensagens = {"Preencha todos os campos", "Cadastro realizado", "Senhas incompatíveis"};
    String usuarioId;

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

                } else if (!senha.equals(ConfirmaSenha)){
                    Snackbar snackbar = Snackbar.make(view, mensagens[2], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.BLACK);
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else CadastrarUsuario(view);
            }
        });
    }
    private void CadastrarUsuario(View view){
        String email = edit_email.getText().toString();
        String senha = edit_senha.getText().toString();
        String userName = edit_nome.getText().toString();


        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    SalvarDados();

                    Snackbar snackbar = Snackbar.make(view, mensagens[1], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.BLACK);
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                    telaPrincipal();
                } else {
                    String erro;
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e) {
                        erro = "Digite uma senha com no mínimo 6 caracteres";
                    } catch (FirebaseAuthUserCollisionException e) {
                        erro = "Essa conta já está cadastrada";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        erro = "Email inválido";
                    } catch (Exception e) {
                        e.printStackTrace();
                        erro = "Erro ao cadastrar o usuário";
                    }
                    Snackbar snackbar = Snackbar.make(view, erro, Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.BLACK);
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                }
            }
        });

    }

    private void SalvarDados(){
        String nome = edit_nome.getText().toString();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String,Object> usuários = new HashMap<>();
        usuários.put("Nome", nome);

        usuarioId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Usuários").document(usuarioId);
        documentReference.set(usuários).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d("db", "Sucesso ao salvar os dados");

            }
        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("db_error", "erro ao salvar os dados" + e.toString());

                    }
                });


    }
    private void IniciarComponentes(){
        edit_nome = findViewById(R.id.txtUsenamer);
        edit_email = findViewById(R.id.txtEmail);
        edit_senha = findViewById(R.id.txtPassword);
        edit_confirmasenha = findViewById(R.id.txtConfirmPassword);
        btn_TelaRegistrar = findViewById(R.id.btnTelaRegistrar);
    }

    private void telaPrincipal() {
        Intent intent = new Intent(activity_registrar.this, activity_pagina_inicial.class);
        startActivity(intent);
        finish();
    }

}