package com.example.buscarcep.interfaces.main;

public interface Presenter {
    void callService(String cep);
    void setView(View view);
}
