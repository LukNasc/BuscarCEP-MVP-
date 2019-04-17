package com.example.buscarcep.presenter.main;

import com.example.buscarcep.interfaces.main.Model;
import com.example.buscarcep.interfaces.main.View;
import com.example.buscarcep.model.CEP;
import com.example.buscarcep.presenter.service.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter implements com.example.buscarcep.interfaces.main.Presenter{
    View view;
    Model model;

    public Presenter(){
        this.model = new CEP(this);
    }

    @Override
    public void callService(final String cep) {
        Call<CEP> call = new RetrofitConfig(view).getCEPService().call(cep);
        call.enqueue(new Callback<CEP>() {
            @Override
            public void onResponse(Call<CEP> call, Response<CEP> response) {
                view.showResult(model.mountObject(response).toString());
            }

            @Override
            public void onFailure(Call<CEP> call, Throwable t) {
                view.showError(t.getMessage());
            }
        });
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }
}
