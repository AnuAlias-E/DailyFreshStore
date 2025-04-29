package com.training.dto.response;

import com.training.model.Store;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StoreSearchResponse {
	int statusCode;
	String description;
	Store store;
}
