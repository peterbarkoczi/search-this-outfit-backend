package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.service;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.entity.Clothing;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.respository.ClothingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ClothingService {

    @Autowired
    private ClothingRepository clothingRepository;

    public Set<Clothing> getTop20ClothingByChosenLabelName(String labelName) {
        return clothingRepository.findTop20ByClassificationENG(labelName);
    }

}
