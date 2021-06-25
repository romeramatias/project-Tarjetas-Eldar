package com.eldar.desafio.controller;

import com.eldar.desafio.model.Operacion.Tasa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControladorOperacion {

    /* JSON
    {
        "tipoTarjeta": "AMEX",
        "importe": 1000
    } */
    @GetMapping("/tasa")
    public Tasa tasa(@RequestBody Tasa tasa){
        return tasa;
    }

}
