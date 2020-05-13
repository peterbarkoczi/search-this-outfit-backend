package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.outputs;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OutputsData {

	@JsonProperty("regions")
	private List<RegionsItem> regions;

	@JsonProperty("concepts")
	private List<ConceptsItem> concepts;

	public List<RegionsItem> getRegions(){
		return regions;
	}

	public List<ConceptsItem> getConcepts(){
		return concepts;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"regions = '" + regions + '\'' + 
			",concepts = '" + concepts + '\'' + 
			"}";
		}
}