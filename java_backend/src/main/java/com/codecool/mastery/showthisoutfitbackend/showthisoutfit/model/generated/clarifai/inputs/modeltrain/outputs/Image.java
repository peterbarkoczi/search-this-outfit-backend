package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.inputs.modeltrain.outputs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image{

	@JsonProperty("url")
	private String url;

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Image{" + 
			"url = '" + url + '\'' + 
			"}";
		}
}