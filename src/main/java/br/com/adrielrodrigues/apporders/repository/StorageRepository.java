package br.com.adrielrodrigues.apporders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.adrielrodrigues.apporders.model.Storage;

public interface StorageRepository extends JpaRepository<Storage, Long> {

}
