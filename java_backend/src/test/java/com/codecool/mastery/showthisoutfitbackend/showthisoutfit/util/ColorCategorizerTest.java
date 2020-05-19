package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ColorCategorizerTest {

    private ColorCategorizer colorCategorizer = new ColorCategorizer();

    @Test
    public void getColorGroupNameFromColorCatalogTestValidInput() {
        assertThat("Gray").isEqualTo(colorCategorizer.getColorGroupNameFromColorCatalog("fekete"));
    }

    @Test
    public void getColorGroupNameFromColorCatalogTestValidInputButNotInTheCategory() {
        assertThat("Unknown").isEqualTo(colorCategorizer.getColorGroupNameFromColorCatalog("something"));
    }

    @Test
    public void getColorGroupNameFromColorCatalogyTestInvalidInputEmptyString() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> colorCategorizer.getColorGroupNameFromColorCatalog(""));
    }

    @Test
    public void getColorGroupNameFromColorCatalogTestInvalidInputWhiteSpace() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> colorCategorizer.getColorGroupNameFromColorCatalog(" "));
    }

}