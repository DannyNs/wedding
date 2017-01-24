package com.dannyns.wedding.services;

import org.springframework.stereotype.Service;

@Service
public class ErrorService {

    public String generateErrorMessage(final int error_code){
        String message="";

        switch(error_code){
            case 400: message="Zły request";
                break;
            case 401: message="Wstęp wzbroniony";
                break;
            case 404: message="Strona nie została odnaleziona";
                break;
            case 500: message="Błąd serwera";
                break;
        }

        return message;
    }
}
