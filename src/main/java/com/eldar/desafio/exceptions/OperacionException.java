package com.eldar.desafio.exceptions;

public class OperacionException extends Exception{

    public final static String EXCEDIDA = "Operacion Excedida Exception";

    public OperacionException(String message) {
        super(message);
    }
}
