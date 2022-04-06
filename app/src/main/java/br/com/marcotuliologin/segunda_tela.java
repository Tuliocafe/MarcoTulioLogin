package br.com.marcotuliologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class segunda_tela extends AppCompatActivity {
    private EditText nome, cpf, email;
    private TextView tNome, tCpf, tEmail;
    private Button salvar, recuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);
        nome = findViewById(R.id.edtNomeCP);
        cpf  =findViewById(R.id.edtCpfCP);
        email = findViewById(R.id.edtEmailCP);
        salvar = findViewById(R.id.butsalvar);
        recuperar = findViewById(R.id.butRecuperar);
        tNome = findViewById(R.id.txtNome);
        tCpf = findViewById(R.id.txtCPF);
        tEmail = findViewById(R.id.txtemail);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });
        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recuperar();
            }
        });
    }


    public void salvar(){

        String txtNome = nome.getText().toString();
        String txtCpf = cpf.getText().toString();
        String txtEmail = email.getText().toString();
        SharedPreferences obj = getSharedPreferences("Dados", Context.MODE_PRIVATE);
        SharedPreferences.Editor  edicao = obj.edit();
        edicao.putString("NOME",txtNome);
        edicao.putString("CPF",txtCpf);
        edicao.putString("EMAIL",txtEmail);
        edicao.apply();
        Toast.makeText(getBaseContext(),"DADOS INSERIDOS COM SUCESSO",Toast.LENGTH_LONG).show();
    }



    public void recuperar(){
        SharedPreferences objRecupera = getSharedPreferences("Dados",Context.MODE_PRIVATE);
        tNome.setText(objRecupera.getString("NOME","nulo"));
        tCpf.setText(objRecupera.getString("CPF","nulo"));
        tEmail.setText(objRecupera.getString("EMAIL","nulo"));


    }

}

