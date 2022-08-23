package com.api.contabancaria.service;

import com.api.contabancaria.model.RequestModel;
import com.api.contabancaria.model.ResponseModel;
import com.api.contabancaria.model.factory.CalculoFactory;
import com.api.contabancaria.repository.CBRepository;
import com.api.contabancaria.repository.ModelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CBService {
    @Autowired
    private CBRepository cbRepository;

    public List<ModelEntity> buscarConta() {
        return cbRepository.findAll();
    }

    public ResponseModel cadastrarConta(RequestModel requesicao) {
        BigDecimal resultado = CalculoFactory.calcular(requesicao.getTipoDeServico()).calculo(requesicao);
        requesicao.setValorFinal(resultado);
        ModelEntity entidade = new ModelEntity(null, requesicao.getNumeroDeConta(), requesicao.getAgencia(), requesicao.getNomeDoUsuario(), requesicao.getSaldoAtualDaConta(),  requesicao.getTipoDeServico(), requesicao.getValorFornecido(),requesicao.getValorFinal());
        cbRepository.save(entidade);
        ResponseModel resposta = new ResponseModel(entidade.getId(), entidade.getNomeDoUsuario(), entidade.getSaldoAtualDaConta(),entidade.getTipoDeServico(), entidade.getValorFornecido(),entidade.getValorFinal());
        return resposta;
    }

    public ResponseModel alterarConta(RequestModel requesicao) {
        BigDecimal resultado = CalculoFactory.calcular(requesicao.getTipoDeServico()).calculo(requesicao);
        requesicao.setValorFinal(resultado);
        ModelEntity entidade = new ModelEntity(null, requesicao.getNumeroDeConta(), requesicao.getAgencia(), requesicao.getNomeDoUsuario(), requesicao.getSaldoAtualDaConta(),  requesicao.getTipoDeServico(), requesicao.getValorFornecido(),requesicao.getValorFinal());
        cbRepository.save(entidade);
        ResponseModel resposta = new ResponseModel(entidade.getId(), entidade.getNomeDoUsuario(), entidade.getSaldoAtualDaConta(),entidade.getTipoDeServico(), entidade.getValorFornecido(),entidade.getValorFinal());
        return resposta;
    }

    public Optional<ModelEntity> buscarId(Long id) {
        return cbRepository.findById(id);
    }

    public void deletar(Long codigo) {
        cbRepository.deleteById(codigo);
    }


    public boolean existsByNumeroDeContaAndAgencia(String numeroDeConta, String agencia) {
        return cbRepository.existsByNumeroDeContaAndAgencia(numeroDeConta, agencia);
    }

}
