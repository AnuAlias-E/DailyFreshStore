package com.training.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

}
