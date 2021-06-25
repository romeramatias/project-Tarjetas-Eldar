package com.eldar.desafio.model.Tarjeta;

import java.time.LocalDate;
import java.time.YearMonth;

public class TarjetaNara extends Tarjeta {

    private final static Double TASA_SERVICIO = 0.5;

    public TarjetaNara(TipoTarjeta tipoTarjeta, Integer numTarjeta, String titular, YearMonth fechaVencimiento) {
        super(tipoTarjeta, numTarjeta, titular, fechaVencimiento);
    }

    public TarjetaNara(TipoTarjeta tipoTarjeta){
        super(tipoTarjeta);
    }

    @Override
    public Double tasaServicio() {
        var tasa = LocalDate.now().getDayOfMonth() * TASA_SERVICIO;
        if (tasa < TASA_SERVICIO_MINIMA) return TASA_SERVICIO_MINIMA;
        if (tasa > TASA_SERVICIO_MAXIMA) return TASA_SERVICIO_MAXIMA;
        return tasa;
    }
}
