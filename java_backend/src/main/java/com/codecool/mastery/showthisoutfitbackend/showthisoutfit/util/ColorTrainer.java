package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.util;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.entity.Clothing;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.respository.ClothingRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class ColorTrainer {

    private ColorCategorizer colorCategorizer;
    private ClothingRepository clothingRepository;
    private List<String> mainColors;
    private Set<String> clothsClasses;

    public ColorTrainer(ColorCategorizer colorCategorizer, ClothingRepository clothingRepository) {
        this.colorCategorizer = colorCategorizer;
        this.clothingRepository = clothingRepository;
        this.mainColors = colorCategorizer.getMainColors();
        this.clothsClasses = clothingRepository.getAllClassificationENG();
    }

    public Set<Clothing> getFirst10ClothByClassificationAndColor() {
        return clothingRepository.findTop10ByClassificationENGAndColor("dress", "blue");
    }
}
