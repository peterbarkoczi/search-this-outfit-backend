package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ColorCategorizerTest {

    private ColorCategorizer colorCategorizer = new ColorCategorizer();

    @Test
    public void getCategoryTestValidInput() {
        assertThat("red".equals(colorCategorizer.getCategory("piros")));
    }

    @Test
    public void getCategoryTestValidInputButNotInTheCategory() {
        assertThat("else".equals(colorCategorizer.getCategory("körte")));
    }

    @Test
    public void getCategoryTestInvalidInputEmptyString() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> colorCategorizer.getCategory(""));
    }

    @Test
    public void getCategoryTestInvalidInputWhiteSpace() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> colorCategorizer.getCategory(" "));
    }

}