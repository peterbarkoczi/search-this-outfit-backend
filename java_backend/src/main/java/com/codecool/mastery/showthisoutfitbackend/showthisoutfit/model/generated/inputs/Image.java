package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.inputs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image{

	@JsonProperty("url")
	private String url;

	@JsonProperty("base64")
	private String base64;

	public String getUrl(){
		return url;
	}

	public String getBase64() {
		return base64;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}
}