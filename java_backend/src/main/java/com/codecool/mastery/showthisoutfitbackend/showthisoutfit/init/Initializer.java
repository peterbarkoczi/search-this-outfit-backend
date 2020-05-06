package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.init;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.entity.Clothing;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.entity.ImageLink;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.util.DatasetFileReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
@Profile("production")
public class Initializer {

    private static final String DATASET_MAIN_FOLDER_PATH = "src/main/resources/static/databasedata/";

    private DatasetFileReader datasetFileReader;

    private String[] datasetFileNames = {"women_dress.csv",
            "women_jeans.csv",
            "women_skirt.csv",
            "women_tshirt.csv"};

    public Initializer(DatasetFileReader datasetFileReader) {
        this.datasetFileReader = datasetFileReader;
    }

    @Bean
    public CommandLineRunner afterInit() {

        return args -> {
            for (String fileName : datasetFileNames) {
                List<String> fileRows = datasetFileReader.readFile(DATASET_MAIN_FOLDER_PATH + fileName);
                for (String row : fileRows) {
                    String[] result = row.split(",");
                    Clothing clothing = new Clothing();
                    clothing.setGenderENG(result[0]);
                    clothing.setClassificationENG(result[1]);
                    clothing.setSubclassificationENG(result[2]);
                    clothing.setGenderHUN(result[3]);
                    clothing.setClassificationHUN(result[4]);
                    clothing.setSubclassificationHUN(result[5]);
                    clothing.setFashionDaysProductId(Long.parseLong(result[6]));
                    clothing.setSimilarProductsLink(result[7]);
                    clothing.setMainProductsLink(result[8]);
                    clothing.setFashionDaysProductName(result[9]);
                    clothing.setPriceHUF(Long.parseLong(result[10]));
                    clothing.setPriceEUR(Float.parseFloat(result[11]));
                    clothing.setBrand(result[12]);
                    clothing.setStockStatusENG(result[13]);

                    System.out.println(clothing);
                    break;
                }
            }

        };
    }

}
