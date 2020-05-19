package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.appareloutputs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegionsItem{

	@JsonProperty("region_info")
	private RegionInfo regionInfo;

	@JsonProperty("data")
	private OutputsData data;

	@JsonProperty("id")
	private String id;

	public RegionInfo getRegionInfo(){
		return regionInfo;
	}

	public OutputsData getData(){
		return data;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"RegionsItem{" + 
			"region_info = '" + regionInfo + '\'' + 
			",data = '" + data + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}