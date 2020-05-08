package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.inputs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data{

	@JsonProperty("image")
	private Image image;

	public Image getImage(){
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}