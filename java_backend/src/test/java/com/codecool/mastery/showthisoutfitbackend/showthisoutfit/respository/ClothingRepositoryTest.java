package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.respository;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.entity.Clothing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class ClothingRepositoryTest {

    @Autowired
    private ClothingRepository clothingRepository;

    @Test
    public void saveOneSimple() {
        Clothing build = Clothing.builder()
                .brand("TEST")
                .fashionDaysProductName("Big test")
                .priceHUF(120L)
                .build();

        clothingRepository.save(build);
        List<Clothing> all = clothingRepository.findAll();
        assertThat(all).hasSize(1)
                .allMatch(clothing -> clothing.equals(build));
    }


}