package com.training.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.training.model.Store;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StoreShowAllResponse {
	@JsonProperty("statusCode")
	private int statusCode;

	@JsonProperty("description")
	private String description;

	@JsonProperty("customers")
	private List<Store> stores;

	// Getters and Setters

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}
}
