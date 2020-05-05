package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String color;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.MERGE)
    private Clothing clothing;
}
