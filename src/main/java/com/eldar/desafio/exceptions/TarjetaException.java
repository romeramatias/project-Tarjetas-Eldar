package com.eldar.desafio.exceptions;

public class TarjetaException extends Exception{

    public final static String VENCIDA = "Tarjeta Vencida Exception";

    public TarjetaException(String message) {
        super(message);
    }
}
