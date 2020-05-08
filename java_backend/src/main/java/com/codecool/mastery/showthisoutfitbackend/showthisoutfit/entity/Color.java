package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String color;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.MERGE)
    private Clothing clothing;
}
