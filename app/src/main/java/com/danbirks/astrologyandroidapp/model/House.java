package com.danbirks.astrologyandroidapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class House {

    private int house;
    private String attributes;

    public House(int house, String attributes) {
        this.house = house;
        this.attributes = attributes;
    }

    public House() {
    }

    @androidx.annotation.NonNull
    @Override
    public String toString() {
        String sb = "\n House: " + getHouse() + "\n" +
                "\n" + getAttributes() + "\n";
        return sb;
    }
}
