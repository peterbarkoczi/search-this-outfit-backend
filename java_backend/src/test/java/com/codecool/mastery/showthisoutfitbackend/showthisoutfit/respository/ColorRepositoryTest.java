package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.respository;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.entity.Color;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class ColorRepositoryTest {

    @Autowired
    private ColorRepository colorRepository;

    @Test
    public void saveOneSimpler() {
        Color blue = Color.builder().color("blue").build();

        colorRepository.save(blue);

        List<Color> colors = colorRepository.findAll();
        assertThat(colors)
                .hasSize(1)
                .allMatch(color -> color.equals(blue));

    }

}