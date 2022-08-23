package com.api.contabancaria.controller;

import com.api.contabancaria.model.RequestModel;
import com.api.contabancaria.repository.ModelEntity;
import com.api.contabancaria.service.CBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/contasbancarias")
public class CBController {
    @Autowired
    private CBService cbService;

    @PostMapping
    public ResponseEntity<Object> cadastrarConta(@RequestBody @Valid RequestModel requestModel) {
        if (cbService.existsByNumeroDeContaAndAgencia(requestModel.getNumeroDeConta(), requestModel.getAgencia())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: conta já existente");
        }
        return ResponseEntity.ok(cbService.cadastrarConta(requestModel));
    }

    @GetMapping
    public ResponseEntity<List<ModelEntity>> buscarTodos() {
        return ResponseEntity.ok(cbService.buscarConta());
    }

    @GetMapping(path = "/{id}")
    public Optional<ModelEntity> buscarId(@PathVariable Long id) {
        return cbService.buscarId(id);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> alterarConta(@RequestBody @Valid RequestModel requestModel) {
        if (cbService.existsByNumeroDeContaAndAgencia(requestModel.getNumeroDeConta(), requestModel.getAgencia())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: conta já existente");
        }
        return ResponseEntity.ok(cbService.alterarConta(requestModel));
    }

    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable Long id) {
        cbService.deletar(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> validacaoDeErros(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String campoNome = ((FieldError) error).getField();
            String mensagemDeErro = error.getDefaultMessage();
            errors.put(campoNome, mensagemDeErro);
        });
        return errors;
    }


}
