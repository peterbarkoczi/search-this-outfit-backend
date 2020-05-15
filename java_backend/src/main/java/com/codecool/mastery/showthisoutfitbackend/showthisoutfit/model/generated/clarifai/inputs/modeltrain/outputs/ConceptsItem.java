package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.inputs.modeltrain.outputs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConceptsItem{

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private String id;

	@JsonProperty("app_id")
	private String appId;

	@JsonProperty("value")
	private int value;

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public String getAppId(){
		return appId;
	}

	public int getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"ConceptsItem{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",app_id = '" + appId + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}