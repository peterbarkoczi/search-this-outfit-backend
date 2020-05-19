package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.service;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.Label;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.inputs.Inputs;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.inputs.InputsImage;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.outputs.Outputs;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.service.util.ClarifaiApiServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Set;

@Service
public class ClarifaiApiService {

    @Autowired
    private ClarifaiApiServiceUtil apiServiceUtil;

    private static final String CLARIFAI_APPAREL_DETECTION = "https://api.clarifai.com/v2/models/72c523807f93e18b431676fb9a58e6ad/outputs";
    private static final String CLARIFAI_COLOR_DETECTION = "https://api.clarifai.com/v2/models/eeed0b6733a644cea07cf4c60f87ebb7/outputs";

    public Set<Label> getPictureLabels(InputsImage base64EncodePicture) {
        RestTemplate restTemplate =  new RestTemplate();

        HttpHeaders commonHeaders = apiServiceUtil.getCommonHeaders();
        Inputs inputs = apiServiceUtil.createApiInputs(base64EncodePicture);
        HttpEntity<Object> requestEntity = new HttpEntity<>(inputs, commonHeaders);

        ResponseEntity<Outputs> outputsResponseEntity =
                restTemplate.exchange(
                        CLARIFAI_APPAREL_DETECTION,
                        HttpMethod.POST,
                        requestEntity,
                        Outputs.class);

        return apiServiceUtil.createLabelSetFromOutputs(Objects.requireNonNull(outputsResponseEntity.getBody()));
    }

}
