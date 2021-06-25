package com.eldar.desafio.model.Tarjeta;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class TarjetaVisa extends Tarjeta {

    private final static Double TASA_SERVICIO = 0.5;

    public TarjetaVisa(TipoTarjeta tipoTarjeta, Integer numTarjeta, String titular, YearMonth fechaVencimiento) {
        super(tipoTarjeta, numTarjeta, titular, fechaVencimiento);
    }

    public TarjetaVisa(TipoTarjeta tipoTarjeta){
        super(tipoTarjeta);
    }

    @Override
    public Double tasaServicio() {
        var anio = Double.parseDouble(LocalDate.now().format(DateTimeFormatter.ofPattern("uu")));
        var tasa = anio / LocalDate.now().getMonthValue();

        if (tasa < TASA_SERVICIO_MINIMA) return TASA_SERVICIO_MINIMA;
        if (tasa > TASA_SERVICIO_MAXIMA) return TASA_SERVICIO_MAXIMA;
        return tasa;
    }
}
