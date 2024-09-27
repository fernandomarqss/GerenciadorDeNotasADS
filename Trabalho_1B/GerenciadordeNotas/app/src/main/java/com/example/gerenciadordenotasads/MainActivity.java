package com.example.gerenciadordenotasads;

import android.os.Bundle;

import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNome, etEmail, etIdade, etDisciplina, etNota1, etNota2;
    private TextView tvResultado;
    private Button btnSalvar, btnResetar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome = findViewById(R.id.etNome);
        etEmail = findViewById(R.id.etEmail);
        etIdade = findViewById(R.id.etIdade);
        etDisciplina = findViewById(R.id.etDisciplina);
        etNota1 = findViewById(R.id.etNota1);
        etNota2 = findViewById(R.id.etNota2);
        tvResultado = findViewById(R.id.tvResultado);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnResetar = findViewById(R.id.btnResetar);

        btnSalvar.setOnClickListener(v -> {
            if (validarDados()) {
                calcularMedia();
            }
        });

        btnResetar.setOnClickListener(v -> resetarFormulario());
    }

    private boolean validarDados() {
        if (TextUtils.isEmpty(etNome.getText().toString())) {
            mostrarErro("O campo de nome está vazio.");
            return false;
        }
        if (TextUtils.isEmpty(etEmail.getText().toString()) || !Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches()) {
            mostrarErro("O email é inválido.");
            return false;
        }
        if (TextUtils.isEmpty(etIdade.getText().toString())) {
            mostrarErro("O campo de idade está vazio.");
            return false;
        }
        if (TextUtils.isEmpty(etDisciplina.getText().toString())) {
            mostrarErro("O campo de disciplina está vazio.");
            return false;
        }
        if (TextUtils.isEmpty(etNota1.getText().toString()) || TextUtils.isEmpty(etNota2.getText().toString())) {
            mostrarErro("Os campos de nota 1º e 2º Bimestres estão vazios.");
            return false;
        }

        try {
            int idade = Integer.parseInt(etIdade.getText().toString());
            if (idade <= 0) {
                mostrarErro("A idade deve ser um número positivo.");
                return false;
            }
            double nota1 = Double.parseDouble(etNota1.getText().toString());
            double nota2 = Double.parseDouble(etNota2.getText().toString());
            if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10) {
                mostrarErro("As notas devem estar entre 0 e 10.");
                return false;
            }
        } catch (NumberFormatException e) {
            mostrarErro("Os campos de idade, nota 1º e 2º Bimestres devem conter números válidos.");
            return false;
        }

        return true;
    }

    private void calcularMedia() {
        String nome = etNome.getText().toString();
        String email = etEmail.getText().toString();
        String idadeStr = etIdade.getText().toString();
        String disciplina = etDisciplina.getText().toString();
        String nota1Str = etNota1.getText().toString();
        String nota2Str = etNota2.getText().toString();

        double nota1 = Double.parseDouble(nota1Str);
        double nota2 = Double.parseDouble(nota2Str);
        double media = (nota1 + nota2) / 2;
        String mensagem = media >= 6 ? getString(R.string.resultado_aprovado) : getString(R.string.resultado_reprovado);

        String resultado = getString(R.string.resultado_nome, nome) + "\n" +
                getString(R.string.resultado_email, email) + "\n" +
                getString(R.string.resultado_idade, idadeStr) + "\n" +
                getString(R.string.resultado_disciplina, disciplina) + "\n" +
                getString(R.string.resultado_notas, nota1, nota2) + "\n" +
                getString(R.string.resultado_media, media) + "\n" +
                mensagem;

        tvResultado.setText(resultado);
        Toast.makeText(this, getString(R.string.dados_salvos), Toast.LENGTH_SHORT).show();
    }

    private void resetarFormulario() {
        etNome.setText("");
        etEmail.setText("");
        etIdade.setText("");
        etDisciplina.setText("");
        etNota1.setText("");
        etNota2.setText("");
        tvResultado.setText("");
    }

    private void mostrarErro(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }
}