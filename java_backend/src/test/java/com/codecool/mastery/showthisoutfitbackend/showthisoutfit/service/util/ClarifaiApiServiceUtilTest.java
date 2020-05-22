package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.service.util;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.inputs.Inputs;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.inputs.InputsData;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.inputs.InputsImage;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.inputs.InputsItem;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ClarifaiApiServiceUtilTest {

    private ClarifaiApiServiceUtil util = new ClarifaiApiServiceUtil();

    @Test
    void getCommonHeadersTestContentTypeApplicationJson() {
        HttpHeaders test = util.getCommonHeaders();
        assertThat(test.getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
    }

    @Test
    void getCommonHeadersTestSetApiKey() {
        HttpHeaders test = util.getCommonHeaders();
        List<String> testList = new LinkedList<>();
        testList.add("Key " + System.getenv("API_KEY"));
        assertThat(test.get("Authorization")).isEqualTo(testList);
    }

    @Test
    void createApiInputsTest() {
        InputsImage testInputImage =  new InputsImage();
        testInputImage.setBase64("base64");
        Inputs apiInputs = util.createApiInputs(testInputImage);
        List<InputsItem> inputs = apiInputs.getInputs();
        assertThat(inputs.stream()
                .map(InputsItem::getData)
                .map(InputsData::getImage)
                .map(InputsImage::getBase64))
                .allMatch(s -> s.equals("base64"));
    }

    @Test
    void createLabelSetFromOutputs() {

    }

    @Test
    void getHighestValueColorFromColorOutputs() {
    }
}