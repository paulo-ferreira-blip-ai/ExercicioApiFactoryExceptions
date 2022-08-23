package com.api.contabancaria.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "contabancaria")
@AllArgsConstructor
@NoArgsConstructor
public class ModelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "conta", nullable = false, unique = true, length = 50)
    private String numeroDeConta;

    @Column(name = "agencia", nullable = false, unique = true, length = 50)
    private String agencia;

    @Column(name = "cliente", nullable = false, length = 50)
    private String nomeDoUsuario;

    @Column(name = "saldo", nullable = false, length = 50)
    private BigDecimal saldoAtualDaConta;

    @Column(name = "tipo_de_servico", nullable = false, length = 50)
    private String tipoDeServico;

    @Column(name = "valor_movimentado", nullable = false, length = 50)
    private BigDecimal valorFornecido;

    @Column(name = "saldo_final", length = 50)
    private BigDecimal valorFinal;
}
