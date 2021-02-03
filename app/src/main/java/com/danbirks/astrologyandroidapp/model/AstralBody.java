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

    @androidx.annotation.NonNull
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getAstralBody()).append("\n");
        for (String s : singleLineMeaning) sb.append(s).append(" ");
        sb.append("\n").append(getAttributes());
        return sb.toString();
    }
}
