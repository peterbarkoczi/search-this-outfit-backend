package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.outputs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OutputsItem{

	@JsonProperty("input")
	private OutputsInput input;

	@JsonProperty("data")
	private OutputsData data;

	@JsonProperty("created_at")
	private String createdAt;

	@JsonProperty("model")
	private Model model;

	@JsonProperty("id")
	private String id;

	@JsonProperty("status")
	private Status status;

	public OutputsInput getInput(){
		return input;
	}

	public OutputsData getData(){
		return data;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public Model getModel(){
		return model;
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
			"OutputsItem{" + 
			"input = '" + input + '\'' + 
			",data = '" + data + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",model = '" + model + '\'' + 
			",id = '" + id + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}