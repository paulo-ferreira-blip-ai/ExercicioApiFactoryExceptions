package com.api.contabancaria.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ResponseModel {
    private Long id;
    private String nomeDoUsuario;
    private BigDecimal saldoAtualDaConta;
    private String tipoDeServico;
    private BigDecimal valorFornecido;
    private BigDecimal valorFinal;
}
