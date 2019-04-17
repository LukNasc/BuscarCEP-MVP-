package com.example.buscarcep.interfaces.service;

public interface ListenerService {
    void onSuccess(Object response, String msg);
    void onError(String title,String msg);
}
