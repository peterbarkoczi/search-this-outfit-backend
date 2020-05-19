package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.coloroutputs;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ColorOutputs {

	@JsonProperty("outputs")
	private List<OutputsItem> outputs;

	@JsonProperty("status")
	private Status status;

	public List<OutputsItem> getOutputs(){
		return outputs;
	}

	public Status getStatus(){
		return status;
	}
}