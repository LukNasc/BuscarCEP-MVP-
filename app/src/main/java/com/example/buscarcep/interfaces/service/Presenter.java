package com.example.buscarcep.interfaces.service;


import com.example.buscarcep.model.CEP;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Presenter {
    String URL = "{cep}/json/";


    @GET(URL)
    Call<CEP> call(@Path("cep") String cep);
}
