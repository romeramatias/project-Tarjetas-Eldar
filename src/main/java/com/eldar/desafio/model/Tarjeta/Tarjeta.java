package com.eldar.desafio.model.Tarjeta;

import com.eldar.desafio.exceptions.TarjetaException;
import lombok.Data;

import java.time.LocalDate;
import java.time.YearMonth;

@Data
public abstract class Tarjeta {

    private TipoTarjeta tipoTarjeta;
    private Integer numTarjeta;
    private String titular;
    private YearMonth fechaVencimiento;

    static final Double TASA_SERVICIO_MINIMA = 0.3;
    static final Double TASA_SERVICIO_MAXIMA = 5.0;

    public Tarjeta(TipoTarjeta tipoTarjeta, Integer numTarjeta, String titular, YearMonth fechaVencimiento) {
        this.tipoTarjeta = tipoTarjeta;
        this.numTarjeta = numTarjeta;
        this.titular = titular;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Tarjeta(TipoTarjeta tipoTarjeta){
        this.tipoTarjeta = tipoTarjeta;
    }

    public abstract Double tasaServicio();

    public Boolean esValida() throws TarjetaException {
        var vencida = !fechaVencimiento.isAfter(YearMonth.from(LocalDate.now()));
        if (vencida) throw new TarjetaException(TarjetaException.VENCIDA);

        return fechaVencimiento.isAfter(YearMonth.from(LocalDate.now()));
    }

    @Override
    public String toString() {
        return "Titular=" + titular +
                ", Tipo de Tarjeta=" + tipoTarjeta +
                ", Numero de Tarjeta=" + numTarjeta +
                ", Fecha de Vencimiento=" + fechaVencimiento;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tarjeta)) return false;

        // CONSULTA cuando dos tarjetas son iguales? cuando solamente tienen el mismo numero?
        // o comparamos todos los campos
        var tarjeta = (Tarjeta) obj;
        return tarjeta.getNumTarjeta().equals(this.getNumTarjeta());
    }
}
