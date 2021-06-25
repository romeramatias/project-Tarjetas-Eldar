package com.eldar.desafio.model.Operacion;

import com.eldar.desafio.model.Operacion.Operacion;
import com.eldar.desafio.model.Tarjeta.TarjetaAmex;
import com.eldar.desafio.model.Tarjeta.TarjetaNara;
import com.eldar.desafio.model.Tarjeta.TarjetaVisa;
import com.eldar.desafio.model.Tarjeta.TipoTarjeta;
import lombok.Data;

@Data
public class Tasa {

    private TipoTarjeta tipoTarjeta;
    private Double importe;
    private Double tasaDeOperacion;
    private Double importeConTasa;


    public Tasa(String tipoTarjeta, double importe) {
        this.tipoTarjeta = tipoTarjeta(tipoTarjeta);
        this.importe = importe;
        this.tasaDeOperacion = this.crearOperacion().tasaDeOperacion();
        this.importeConTasa = this.importe + tasaDeOperacion;
    }

    private TipoTarjeta tipoTarjeta(String tipoTarjeta) {
        TipoTarjeta tipoEnum;
        switch (tipoTarjeta) {
            case "VISA":
                tipoEnum = TipoTarjeta.VISA;
                break;
            case "NARA":
                tipoEnum = TipoTarjeta.NARA;
                break;
            case "AMEX":
                tipoEnum = TipoTarjeta.AMEX;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + tipoTarjeta);
        }

        return tipoEnum;
    }

    public Operacion crearOperacion() {
        switch (this.tipoTarjeta) {
            case VISA:
                return new Operacion(new TarjetaVisa(tipoTarjeta), this.importe);
            case NARA:
                return new Operacion(new TarjetaNara(tipoTarjeta), this.importe);
            case AMEX:
                return new Operacion(new TarjetaAmex(tipoTarjeta), this.importe);
            default:
                throw new IllegalStateException("Unexpected value: " + tipoTarjeta);
        }
    }
}
