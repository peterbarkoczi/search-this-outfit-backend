package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.inputs.modeltrain;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.inputs.InputsImage;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class InputsDataModel {
    @JsonProperty("image")
    private InputsImageModel image;

    @JsonProperty("concepts")
    private List<ConceptsItemModel> conceptsItemModels = new ArrayList<>();

}
