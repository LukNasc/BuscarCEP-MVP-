package com.example.buscarcep.interfaces.main;

import com.example.buscarcep.model.CEP;

import retrofit2.Response;

public interface Model {
    CEP mountObject(Response<CEP> response);
}
