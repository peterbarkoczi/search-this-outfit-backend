package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.outputs.BoundingBox;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class Label {

    @NotEmpty
    private String name;

    @NotEmpty
    private BoundingBox boundingBox;
}
