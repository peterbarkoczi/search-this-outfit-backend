package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.service.util;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.inputs.Inputs;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.inputs.InputsData;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.inputs.InputsImage;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.inputs.InputsItem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ClarifaiApiServiceUtil {

    private static final String API_KEY = System.getenv("API_KEY");

    public HttpHeaders getCommonHeaders() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("Authorization", "Key " + API_KEY);

        return httpHeaders;
    }

    public Inputs createApiInputs(InputsImage base64EncodePicture) {
        InputsData data = new InputsData();
        data.setImage(base64EncodePicture);

        InputsItem inputsItem = new InputsItem();
        inputsItem.setData(data);

        Inputs inputs = new Inputs();
        inputs.setInputs(Collections.singletonList(inputsItem));

        return inputs;
    }

}
