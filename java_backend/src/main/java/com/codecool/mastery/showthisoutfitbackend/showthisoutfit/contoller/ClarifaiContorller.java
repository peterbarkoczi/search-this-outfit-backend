package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.contoller;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.Label;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.inputs.InputsImage;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.service.ClarifaiApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@CrossOrigin
@RestController
public class ClarifaiContorller {

    @Autowired
    private ClarifaiApiService clarifaiApiService;

    @PostMapping("/picture/upload")
    public Set<Label> getUploadImageLabels(@RequestBody InputsImage base64Image) throws JsonProcessingException {
        return clarifaiApiService.getPictureLabels(base64Image);
    }

}
