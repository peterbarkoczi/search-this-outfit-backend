package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.coloroutputs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class W3c{

	@JsonProperty("name")
	private String name;

	@JsonProperty("hex")
	private String hex;

	public String getName(){
		return name;
	}

	public String getHex(){
		return hex;
	}
}