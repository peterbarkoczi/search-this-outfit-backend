package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.outputs.BoundingBox;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
public class Label {

    @NotEmpty
    private List<String> names;

    @NotEmpty
    private BoundingBox boundingBox;
}
