package com.training.dto.request;

import com.training.model.Store;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreUpdateRequest {
	Store store;

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	
}
