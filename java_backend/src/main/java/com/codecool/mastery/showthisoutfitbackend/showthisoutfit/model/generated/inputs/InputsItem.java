package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.inputs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InputsItem{

	@JsonProperty("data")
	private Data data;

	public Data getData(){
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
}