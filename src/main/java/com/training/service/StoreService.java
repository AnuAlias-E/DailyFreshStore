package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.db.StoreRepository;
import com.training.exception.StoreNotFoundException;
import com.training.model.Store;

@Service
public class StoreService {

	@Autowired
	StoreRepository repo;

	public Store addNewStore(Store store) {
		return repo.save(store);
	}

	public Store updateStore(Store store) {
		return repo.save(store);
	}

	public Store searchStore(int id) throws StoreNotFoundException {
		return repo.findById(id).orElseThrow(() -> new StoreNotFoundException("Store not found with id: " + id));
	}

	public List<Store> getAllCustomers() {
		return repo.findAll();

	}

	public boolean deleteStore(Store store) {
		repo.delete(store);
		return true;
	}

}
