package com.eldar.desafio.model.Operacion;

import com.eldar.desafio.exceptions.OperacionException;
import com.eldar.desafio.exceptions.TarjetaException;
import com.eldar.desafio.model.Tarjeta.Tarjeta;
import lombok.Data;

@Data
public class Operacion {

    private Tarjeta tarjeta;
    private Double importe;
    private static final Double IMPORTE_MAXIMO = 1000D;

    public Operacion(Tarjeta tarjeta, Double importe) {
        this.tarjeta = tarjeta;
        this.importe = importe;
    }

    public Boolean esValida() throws OperacionException, TarjetaException {
        this.tarjeta.esValida();
        if (this.getImporte() > IMPORTE_MAXIMO) throw new OperacionException(OperacionException.EXCEDIDA);
        return this.getImporte() <= IMPORTE_MAXIMO;

    }

    public Double tasaDeOperacion() {
        return this.tarjeta.tasaServicio() * this.importe / 100;
    }

}
