package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.service.util;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.Label;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.appareloutputs.*;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.inputs.Inputs;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.inputs.InputsData;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.inputs.InputsImage;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.inputs.InputsItem;
import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.*;

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
    void createLabelSetFromOutputsTest() {
        ConceptsItem conceptsItem = new ConceptsItem();
        conceptsItem.setName("test");

        OutputsData outputsData = new OutputsData();
        outputsData.setConcepts(Arrays.asList(conceptsItem));

        BoundingBox boundingBox = new BoundingBox();
        boundingBox.setLeftCol(0.1);
        boundingBox.setRightCol(0.2);
        boundingBox.setTopRow(0.3);
        boundingBox.setBottomRow(0.4);

        RegionInfo regionInfo = new RegionInfo();
        regionInfo.setBoundingBox(boundingBox);

        RegionsItem regionsItem = new RegionsItem();
        regionsItem.setData(outputsData);
        regionsItem.setRegionInfo(regionInfo);

        OutputsData data = new OutputsData();
        data.setRegions(Arrays.asList(regionsItem));

        OutputsItem outputsItem = new OutputsItem();
        outputsItem.setData(data);

        Outputs outputs = new Outputs();
        outputs.setOutputs(Arrays.asList(outputsItem));

        Label label = new Label(Arrays.asList("test"), boundingBox);
        Set<Label> labels = Sets.newHashSet(label);

        assertThat(labels).isEqualTo(util.createLabelSetFromOutputs(outputs));
    }

    @Test
    void getHighestValueColorFromColorOutputs() {
    }
}