package com.training.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.dto.request.StoreUpdateRequest;
import com.training.dto.response.StoreAddResponse;
import com.training.dto.response.StoreSearchResponse;
import com.training.dto.response.StoreShowAllResponse;
import com.training.dto.response.StoreUpdateResponse;
import com.training.exception.StoreNotFoundException;
import com.training.model.Store;
import com.training.service.StoreService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class StoreController {

	@Autowired
	StoreService service;

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StoreAddResponse> addNewStore(@Valid @RequestBody StoreAddResponse request) {
		StoreAddResponse response = new StoreAddResponse();
		Store store = service.addNewStore(request.getStore());
		response.setStatusCode(201);
		response.setDescription("Store Added Successfully");
		response.setStore(store);

		return new ResponseEntity<>(response, HttpStatus.CREATED);

	}

	@PutMapping(value = "/modify")
	public ResponseEntity<StoreUpdateResponse> updateCustomer(@RequestBody StoreUpdateRequest request)
			throws StoreNotFoundException {
		StoreUpdateResponse response = new StoreUpdateResponse();

		Store store = service.searchStore(request.getStore().getStoreId());
		if (store != null) {

			Store storeResult = service.updateStore(request.getStore());
			response.setStatusCode(200);
			response.setDescription("Store Modified Successfully");
			response.setStore(storeResult);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setStatusCode(404);
			response.setDescription("Store Not Found");
			response.setStore(store);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/find/{sid}")
	public ResponseEntity<StoreSearchResponse> searchStore(@PathVariable(name = "sid") int storeId) throws Exception {
		Store store = service.searchStore(storeId);
		StoreSearchResponse response = new StoreSearchResponse();
		if (store != null) {
			response.setStatusCode(200);
			response.setDescription("Store fetched Successfully");
			response.setStore(store);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			Exception e = new StoreNotFoundException("Store Not Found with id:" + storeId);
			throw e;
		}
	}

	@GetMapping(value = "/showAll", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<StoreShowAllResponse> getAllCustomers() throws StoreNotFoundException {
		List<Store> stores = service.getAllCustomers();
		StoreShowAllResponse response = new StoreShowAllResponse();
		response.setStatusCode(200);
		response.setDescription("All stores Fetched");
		response.setStores(stores);

		return ResponseEntity.ok(response);
	}

}
