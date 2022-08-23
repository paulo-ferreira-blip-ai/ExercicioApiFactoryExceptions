package com.api.contabancaria.model.factory;

public class CalculoFactory {
    public static InterfaceFactory calcular(String tipoDeServico) {
        if (tipoDeServico.equalsIgnoreCase("deposito")) {
            return new Deposito();
        } else if (tipoDeServico.equalsIgnoreCase("saque")) {
            return new Saque();
        } else {
            return null;
        }
    }
}
