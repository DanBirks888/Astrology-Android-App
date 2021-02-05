package com.danbirks.astrologyandroidapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sign {

    private String zodiac;
    private String element;
    private String mode;
    private int house;
    private String attributes;

    public Sign(String zodiac, String element, String mode, int house, String attributes) {
        this.zodiac = zodiac;
        this.element = element;
        this.mode = mode;
        this.house = house;
        this.attributes = attributes;
    }

    public Sign() {
    }
}
