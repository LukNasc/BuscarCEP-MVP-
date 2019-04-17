package com.example.buscarcep.presenter.service;

import com.example.buscarcep.interfaces.main.View;
import com.example.buscarcep.interfaces.service.Presenter;
import com.example.buscarcep.model.CEP;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig implements Presenter {
    Retrofit retrofit;
    View view;

    public RetrofitConfig(View view) {
        this.view = view;
        try {
            this.retrofit = new Retrofit.Builder()
                    .baseUrl("http://viacep.com.br/ws/")
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
        }catch (Exception e){
            view.showError(e.getMessage());
        }
    }

    public Presenter getCEPService() {
        return this.retrofit.create(Presenter.class);
    }

    @Override
    public Call<CEP> call(String cep) {
        return null;
    }
}
