package br.com.marcotuliologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText login, senha;
    Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.id_login);
        senha = findViewById(R.id.id_senha);
        entrar = findViewById(R.id.id_entrar);
        entrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                entrando();
            }
        });
    }


    public void chamaCadastro(){
        Intent tCadastro = new Intent(this,segunda_tela.class);
        startActivity(tCadastro);
    }



    private void entrando() {
        if(login.getText().toString().equals("tulio")&& senha.getText().toString().equals("123"))
        {
//            Intent intent = new Intent(this,segunda_tela.class);
//            Bundle n = new Bundle();
//            n.putString("LOGIN",login.getText().toString());
//            n.putString("SENHA",senha.getText().toString());
//            intent.putExtras(n);
//            startActivity(intent);

            chamaCadastro();

        }else{
            login.setText("");
            senha.setText("");
            login.requestFocus();
            Toast.makeText(this, "DADOS INVALIDOS", Toast.LENGTH_LONG).show();
        }
    }


}