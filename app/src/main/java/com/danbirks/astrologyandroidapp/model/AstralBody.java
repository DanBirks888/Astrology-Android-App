package com.danbirks.astrologyandroidapp.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AstralBody {

    private String astralBody;
    private List<String> singleLineMeaning;
    private String attributes;

    public AstralBody(String astralBody, List<String> singleLineMeaning, String attributes) {
        this.astralBody = astralBody;
        this.singleLineMeaning = singleLineMeaning;
        this.attributes = attributes;
    }

    public AstralBody() {
    }
}
