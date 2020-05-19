package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.coloroutputs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ColorsItem{

	@JsonProperty("raw_hex")
	private String rawHex;

	@JsonProperty("w3c")
	private W3c w3c;

	@JsonProperty("value")
	private double value;

	public String getRawHex(){
		return rawHex;
	}

	public W3c getW3c(){
		return w3c;
	}

	public double getValue(){
		return value;
	}
}