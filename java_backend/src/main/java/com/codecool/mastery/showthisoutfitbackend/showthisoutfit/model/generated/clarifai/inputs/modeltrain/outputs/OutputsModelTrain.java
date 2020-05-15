package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.inputs.modeltrain.outputs;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OutputsModelTrain{

	@JsonProperty("inputs")
	private List<InputsItem> inputs;

	@JsonProperty("status")
	private Status status;

	public List<InputsItem> getInputs(){
		return inputs;
	}

	public Status getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"OutputsModelTrain{" + 
			"inputs = '" + inputs + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}