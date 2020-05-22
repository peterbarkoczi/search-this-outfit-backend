package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.coloroutputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ColorsItem{

	@JsonProperty("raw_hex")
	private String rawHex;

	@JsonProperty("w3c")
	private W3c w3c;

	@JsonProperty("value")
	private double value;

}