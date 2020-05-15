package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.util;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.entity.Clothing;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.entity.ImageLink;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.model.generated.clarifai.inputs.modeltrain.InputsModel;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.respository.ClothingRepository;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.service.ClarifaiApiService;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Component
public class ColorTrainer {

    private ColorCategorizer colorCategorizer;
    private ClothingRepository clothingRepository;
    private List<String> mainColors;
    private Set<String> clothsClasses;
    private ClarifaiApiService clarifaiApiService;

    public ColorTrainer(ColorCategorizer colorCategorizer, ClothingRepository clothingRepository, ClarifaiApiService clarifaiApiService) {
        this.colorCategorizer = colorCategorizer;
        this.clothingRepository = clothingRepository;
        this.clarifaiApiService = clarifaiApiService;
        this.mainColors = colorCategorizer.getMainColors();
        this.clothsClasses = clothingRepository.getAllClassificationENG();
    }

    public Set<Clothing> getFirst10ClothByClassificationAndColor(String clothingType, String color) {
        return clothingRepository.findTop10ByClassificationENGAndColor(clothingType, color);
    }

    public List<String> prepareWriting(Set<Clothing> clothes) {
        List<String> clothTypeImageColorContainer = new LinkedList<>();
        for (Clothing clothing : clothes) {
            for (ImageLink img : clothing.getImages()) {
                StringBuilder builder = new StringBuilder();
                builder.append(img.getUrl() + " ,");
                builder.append(clothing.getColor() + "\n");

                clothTypeImageColorContainer.add(builder.toString());
            }
        }
        return clothTypeImageColorContainer;
    }

    public void uploadImages() throws InterruptedException {
        for (String clothClass : clothsClasses) {
            for (String c : mainColors) {
                List<String> clothes = prepareWriting(getFirst10ClothByClassificationAndColor(clothClass, c));
                for (String cloth : clothes) {
                    String[] split = cloth.split(" ,");
                    String url = split[0];
                    String color = split[1].replaceAll("\n", "");
                    clarifaiApiService.updateModel(url, color);
                    Thread.sleep(2000);
                }
            }

        }
    }
}
