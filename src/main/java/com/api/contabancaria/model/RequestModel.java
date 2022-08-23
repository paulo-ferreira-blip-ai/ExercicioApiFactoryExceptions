package com.api.contabancaria.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class RequestModel {
    @NotBlank(message = "Campo vazio")
    @Size(max = 4, message = "O número da conta deve conter 4 digitos")
    private String numeroDeConta;

    @NotBlank(message = "Campo vazio")
    @Size(max = 6, message = "O número da agencia deve conter 6 digitos")
    private String agencia;

    @NotBlank(message = "Campo vazio")
    private String nomeDoUsuario;


    private BigDecimal saldoAtualDaConta;

    private BigDecimal valorFinal;

    private BigDecimal valorFornecido;

    @NotBlank(message = "Campo vazio")
    private String tipoDeServico;

}
