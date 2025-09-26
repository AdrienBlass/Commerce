package com.example.commerce.enums;

import lombok.Getter;

@Getter
public enum Tva {
    TVA_5_5("5.5%"),
    TVA_10("10%"),
    TVA_20("20%");

    private final String label;

    Tva(String label) {
        this.label = label;
    }

    public static Tva fromLabel(String label) {
        for (Tva t : values()) {
            if (t.label.equals(label)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Taux TVA inconnu: " + label);
    }
}
