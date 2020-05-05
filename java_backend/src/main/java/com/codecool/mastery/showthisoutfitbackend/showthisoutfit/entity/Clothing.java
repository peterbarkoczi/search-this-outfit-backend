package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Clothing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String genderENG;
    private String classificationENG;
    private String subclassificationENG;
    private String genderHUN;
    private String classificationHUN;
    private String subclassificationHUN;
    private Long fashionDaysProductId;
    private String similarProductsLink;
    private String mainProductsLink;
    private String fashionDaysProductName;
    private Long priceHUF;
    private Float priceEUR;
    private String brand;
    private String stockStatusENG;

    @Singular
    @OneToMany(mappedBy = "clothing",cascade = CascadeType.MERGE)
    @EqualsAndHashCode.Exclude
    private List<ImageLink> images = new LinkedList<>();

    @Singular
    @OneToMany(mappedBy = "clothing",cascade = CascadeType.MERGE)
    @EqualsAndHashCode.Exclude
    private Set<Color> colors = new HashSet<>();

    private String catalogId;
    private String productDetails;

}
