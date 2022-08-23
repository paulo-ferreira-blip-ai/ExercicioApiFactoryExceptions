package com.api.contabancaria.model.factory;

import com.api.contabancaria.model.RequestModel;

import java.math.BigDecimal;

public class Saque implements InterfaceFactory {
    @Override
    public BigDecimal calculo(RequestModel requestModel) {
        return requestModel.getSaldoAtualDaConta().subtract(requestModel.getValorFornecido());
    }
}
