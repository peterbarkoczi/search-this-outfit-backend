package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.inputs.modeltrain.outputs;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Data{

	@JsonProperty("image")
	private Image image;

	@JsonProperty("concepts")
	private List<ConceptsItem> concepts;

	public Image getImage(){
		return image;
	}

	public List<ConceptsItem> getConcepts(){
		return concepts;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"image = '" + image + '\'' + 
			",concepts = '" + concepts + '\'' + 
			"}";
		}
}