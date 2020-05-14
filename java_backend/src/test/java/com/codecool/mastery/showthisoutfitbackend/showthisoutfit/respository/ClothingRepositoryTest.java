package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.respository;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.entity.Clothing;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.entity.ImageLink;
import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class ClothingRepositoryTest {

    @Autowired
    private ClothingRepository clothingRepository;

    @Autowired
    private ImageLinkRepository imageLinkRepository;

    @Test
    public void saveOneSimple() {
        Clothing clothing = Clothing.builder()
                .brand("TEST")
                .fashionDaysProductName("Big test")
                .priceHUF(120L)
                .build();

        List<ImageLink> imageLinks = new LinkedList<>();
        imageLinks.add(ImageLink.builder().url("test1.com").clothing(clothing).build());
        imageLinks.add(ImageLink.builder().url("test2.com").clothing(clothing).build());
        imageLinks.add(ImageLink.builder().url("test3.com").clothing(clothing).build());

        clothing.setImages(imageLinks);
        imageLinkRepository.saveAll(imageLinks);

        clothingRepository.save(clothing);
        List<Clothing> all = clothingRepository.findAll();

        assertThat(all).hasSize(1)
                .allMatch(clothing1 -> clothing1.equals(clothing));
    }

    @Test
    public void findTop20ByClassificationENGTestReturnTop20ClothsWithChosenLabelName() {
        String clothClassificationENG = "pants";

        for (int piece = 0; piece < 30; piece++) {
            clothingRepository.save(Clothing.builder().classificationENG(clothClassificationENG).build());
        }

        Set<Clothing> clothingSet = clothingRepository.findTop20ByClassificationENG(clothClassificationENG);

        assertThat(clothingSet)
                .hasSize(20)
                .allMatch(clothing1 -> clothClassificationENG.equals(clothing1.getClassificationENG()));
    }

    @Test
    public void findTop20ByClassificationENGTestEmptyString() {
        String clothClassificationENG = "pants";

        for (int piece = 0; piece < 30; piece++) {
            clothingRepository.save(Clothing.builder().classificationENG(clothClassificationENG).build());
        }

        Set<Clothing> clothingSet = clothingRepository.findTop20ByClassificationENG("");

        assertThat(clothingSet)
                .hasSize(0);

    }

    @Test
    public void findTop20ByClassificationENGTestWhiteSpaceString() {
        String clothClassificationENG = "pants";

        for (int piece = 0; piece < 30; piece++) {
            clothingRepository.save(Clothing.builder().classificationENG(clothClassificationENG).build());
        }

        Set<Clothing> clothingSet = clothingRepository.findTop20ByClassificationENG(" ");

        assertThat(clothingSet)
                .hasSize(0);

    }

    @Test
    public void getAllClassificationENGTest() {
        Set<String> clothsClasses = Sets.newHashSet("pants", "dress", "top");

        for (String clothClass : clothsClasses) {
            clothingRepository.save(
                    Clothing.builder()
                            .classificationENG(clothClass)
                            .build());
        }

        Set<String> allClassificationENG = clothingRepository.getAllClassificationENG();
        assertThat(clothsClasses.equals(allClassificationENG));
    }


}