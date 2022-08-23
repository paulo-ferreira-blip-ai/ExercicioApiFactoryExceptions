package com.api.contabancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CBRepository extends JpaRepository<ModelEntity, Long> {
    boolean existsByNumeroDeContaAndAgencia(String numeroDeConta, String agencia);

}
