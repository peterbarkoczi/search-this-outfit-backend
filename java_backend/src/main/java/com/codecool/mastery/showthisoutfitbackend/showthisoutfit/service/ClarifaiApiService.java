package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.service;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.Label;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.inputs.*;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.inputs.modeltrain.*;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.inputs.modeltrain.outputs.OutputsModelTrain;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.outputs.Outputs;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.service.util.ClarifaiApiServiceUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@Service
public class ClarifaiApiService {

    @Autowired
    private ClarifaiApiServiceUtil apiServiceUtil;

    private static final String CLARIFAI_API_URL = "https://api.clarifai.com/v2/models/72c523807f93e18b431676fb9a58e6ad/outputs";

    public Set<Label> getPictureLabels(InputsImage base64EncodePicture) throws JsonProcessingException {
        RestTemplate restTemplate =  new RestTemplate();

        HttpHeaders commonHeaders = apiServiceUtil.getCommonHeaders();
        Inputs inputs = apiServiceUtil.createApiInputs(base64EncodePicture);
        HttpEntity<Object> requestEntity = new HttpEntity<>(inputs, commonHeaders);

        ResponseEntity<Outputs> outputsResponseEntity =
                restTemplate.exchange(
                        CLARIFAI_API_URL,
                        HttpMethod.POST,
                        requestEntity,
                        Outputs.class);

        return apiServiceUtil.createLabelSetFromOutputs(Objects.requireNonNull(outputsResponseEntity.getBody()));
    }

    public void updateModel(String url, String color) {
        RestTemplate restTemplate =  new RestTemplate();

        HttpHeaders commonHeaders = apiServiceUtil.getCommonHeaders();

        InputsImageModel imgUrl = new InputsImageModel();
        imgUrl.setUrl(url);

        ConceptsItemModel itemModel = new ConceptsItemModel();
        itemModel.setId(color);
        itemModel.setValue(true);

        InputsDataModel dataModel = new InputsDataModel();
        dataModel.setImage(imgUrl);
        dataModel.setConceptsItemModels(Collections.singletonList(itemModel));


        InputsItemModel inputsItem = new InputsItemModel();
        inputsItem.setData(dataModel);

        InputsModel inputs = new InputsModel();
        inputs.setInputs(Collections.singletonList(inputsItem));

        HttpEntity<Object> requestEntity = new HttpEntity<>(inputs, commonHeaders);

        ResponseEntity<OutputsModelTrain> outputsResponseEntity =
                restTemplate.exchange(
                        "https://api.clarifai.com/v2/inputs",
                        HttpMethod.POST,
                        requestEntity,
                        OutputsModelTrain.class);


        System.out.println(outputsResponseEntity.getBody());



    }

}
