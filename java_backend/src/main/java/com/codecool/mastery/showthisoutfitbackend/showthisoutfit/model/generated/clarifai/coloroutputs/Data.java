package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.coloroutputs;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
@lombok.Data
public class Data{

	@JsonProperty("colors")
	private List<ColorsItem> colors;

	@JsonProperty("image")
	private Image image;

	public List<ColorsItem> getColors(){
		return colors;
	}

	public Image getImage(){
		return image;
	}
}