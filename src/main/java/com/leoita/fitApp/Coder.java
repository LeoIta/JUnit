package com.leoita.fitApp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Coder {
    private double height;
    private double weight;
    private int age;
    private Gender gender;

    public Coder(double height, double weight) {
        super();
        this.height = height;
        this.weight = weight;
    }
}
