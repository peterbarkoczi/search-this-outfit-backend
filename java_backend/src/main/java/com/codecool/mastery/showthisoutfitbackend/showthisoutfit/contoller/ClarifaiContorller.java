package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.contoller;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.inputs.InputsImage;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.outputs.Outputs;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.service.ClarifaiApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClarifaiContorller {

    @Autowired
    private ClarifaiApiService clarifaiApiService;

    @PostMapping("/picture/upload")
    public Outputs getUploadImageLabels(@RequestBody InputsImage base64Image) throws JsonProcessingException {
        return clarifaiApiService.getPictureLabels(base64Image);
    }

}
