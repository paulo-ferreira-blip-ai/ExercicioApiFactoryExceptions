package com.api.contabancaria.model.factory;

import com.api.contabancaria.model.RequestModel;

import java.math.BigDecimal;

public interface InterfaceFactory {
    public BigDecimal calculo(RequestModel requestModel);

}
