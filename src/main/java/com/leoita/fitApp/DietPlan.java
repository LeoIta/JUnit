package com.leoita.fitApp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class DietPlan {
    private int calories;
    private int protein;
    private int fat;
    private int carbohydrate;

}
