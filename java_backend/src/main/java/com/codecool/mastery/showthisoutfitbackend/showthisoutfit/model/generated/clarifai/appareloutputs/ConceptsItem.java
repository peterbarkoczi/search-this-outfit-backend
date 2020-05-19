package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.appareloutputs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConceptsItem{

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private String id;

	@JsonProperty("value")
	private double value;

	@JsonProperty("app_id")
	private String appId;

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public double getValue(){
		return value;
	}

	public String getAppId(){
		return appId;
	}

	@Override
 	public String toString(){
		return 
			"ConceptsItem{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",value = '" + value + '\'' + 
			",app_id = '" + appId + '\'' + 
			"}";
		}
}