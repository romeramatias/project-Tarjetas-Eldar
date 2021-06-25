package com.eldar.desafio;

import com.eldar.desafio.exceptions.OperacionException;
import com.eldar.desafio.exceptions.TarjetaException;
import com.eldar.desafio.model.Operacion.Operacion;
import com.eldar.desafio.model.Tarjeta.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.YearMonth;
import java.util.ArrayList;

@SpringBootApplication
public class DesafioApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafioApplication.class, args);

        // Tarjetas
        var tarjetas = new ArrayList<Tarjeta>();
        tarjetas.add(new TarjetaAmex(TipoTarjeta.AMEX, 9121, "Matias Romera", YearMonth.of(2018, 9)));
        tarjetas.add(new TarjetaNara(TipoTarjeta.NARA, 1218, "Pablo Tamashiro", YearMonth.of(2022, 12)));
        tarjetas.add(new TarjetaVisa(TipoTarjeta.VISA, 3191, "Daniela Belcecchi", YearMonth.of(2023, 12)));

        for (Tarjeta t : tarjetas) {
            try {
                // - Informar si una tarjeta es válida para operar
                System.out.println((t.esValida()) ? "Es valida" : "No es valida");

                // - Invocar un método que devuelva toda la información de una tarjeta
                System.out.println("Tarjeta: " + t);

                // - Calcular la tasa por el servicio que es desde 0.3% hasta 5% segun tipo
                System.out.println("Tasa de servicio: " + t.tasaServicio() + "%");

            } catch (TarjetaException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }

        // Operaciones
        var operaciones = new ArrayList<Operacion>();
        operaciones.add(new Operacion(tarjetas.get(0), 900D));
        operaciones.add(new Operacion(tarjetas.get(1), 1500D));
        operaciones.add(new Operacion(tarjetas.get(2), 500D));

        for (Operacion o : operaciones) {
            try {
                // - Informar si una operación es valida
                System.out.println(o.esValida() ? "Es valida" : "No es valida");

                // - Obtener por medio de un método la tasa de una operación informando marca e importe
                System.out.println("Tasa de operacion: $" + o.tasaDeOperacion());
            } catch (OperacionException | TarjetaException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }

        // - Identificar si una tarjeta es distinta a otra
        System.out.println(tarjetas.get(0).equals(tarjetas.get(1)));
        System.out.println(tarjetas.get(0).equals(new TarjetaAmex(TipoTarjeta.AMEX, 9121, "A", YearMonth.of(2018, 9))));

    }
}
