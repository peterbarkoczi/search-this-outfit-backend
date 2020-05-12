package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageLink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String url;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.MERGE)
    private Clothing clothing;

}
