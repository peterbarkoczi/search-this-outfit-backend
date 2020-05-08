package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.service;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.inputs.Data;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.inputs.Image;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.outputs.Outputs;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.inputs.Inputs;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.inputs.InputsItem;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class ClarifaiApiService {

    private static final String CLARIFAI_API_URL = "https://api.clarifai.com/v2/models/72c523807f93e18b431676fb9a58e6ad/outputs";

    public Outputs getPictureLabels(String base64EncodePicture) {
        RestTemplate restTemplate =  new RestTemplate();
        String apiKey = System.getenv("API_KEY");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setBasicAuth(apiKey);

        Image image = new Image();
        image.setBase64(base64EncodePicture);

        Data data = new Data();
        data.setImage(image);

        InputsItem inputsItem = new InputsItem();
        inputsItem.setData(data);

        Inputs inputs = new Inputs();
        inputs.setInputs(Collections.singletonList(inputsItem));

        HttpEntity<Object> requestEntity = new HttpEntity<>(inputs, httpHeaders);


        ResponseEntity<Outputs> outputsResponseEntity = restTemplate.exchange(CLARIFAI_API_URL, HttpMethod.POST, requestEntity, Outputs.class);

        return outputsResponseEntity.getBody();
    }

}
