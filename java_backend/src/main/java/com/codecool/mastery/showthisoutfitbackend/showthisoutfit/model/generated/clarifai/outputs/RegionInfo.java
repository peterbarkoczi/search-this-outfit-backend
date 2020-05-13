package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.outputs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegionInfo{

	@JsonProperty("bounding_box")
	private BoundingBox boundingBox;

	public BoundingBox getBoundingBox(){
		return boundingBox;
	}

	@Override
 	public String toString(){
		return 
			"RegionInfo{" + 
			"bounding_box = '" + boundingBox + '\'' + 
			"}";
		}
}