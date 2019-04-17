package com.example.buscarcep.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buscarcep.R;
import com.example.buscarcep.interfaces.main.Presenter;
import com.example.buscarcep.interfaces.main.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View {
    Presenter presenter;
    @BindView(R.id.etMain_cep)
    EditText cep;
    @BindView(R.id.etMain_resposta)
    TextView resposta;
    @BindView(R.id.btnMain_buscarCep)
    Button buscarCep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new com.example.buscarcep.presenter.main.Presenter();
        presenter.setView(this);
    }

    @OnClick(R.id.btnMain_buscarCep)
    public void buscar() {
        presenter.callService(cep.getText().toString());
    }

    @Override
    public void showResult(String msg) {
        resposta.setText(msg);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
