package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.contoller;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.entity.Clothing;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.service.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@CrossOrigin
@RestController
public class ClothingController {

    @Autowired
    private ClothingService clothingService;

    @PostMapping("/result")
    public Set<Clothing> result(@RequestParam String labelName) {
        return clothingService.getTop20ClothingByChosenLabelName(labelName);
    }
}