package br.com.adrielrodrigues.apporders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.adrielrodrigues.apporders.model.StorageData;

public interface StorageDataRepository extends JpaRepository<StorageData, Long> {

}
