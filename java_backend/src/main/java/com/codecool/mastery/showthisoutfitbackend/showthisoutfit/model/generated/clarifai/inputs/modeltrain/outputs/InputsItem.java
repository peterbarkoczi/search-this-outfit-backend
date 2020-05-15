package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.inputs.modeltrain.outputs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InputsItem{

	@JsonProperty("data")
	private Data data;

	@JsonProperty("created_at")
	private String createdAt;

	@JsonProperty("id")
	private String id;

	@JsonProperty("status")
	private Status status;

	public Data getData(){
		return data;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getId(){
		return id;
	}

	public Status getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"InputsItem{" + 
			"data = '" + data + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}