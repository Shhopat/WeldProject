package com.svar_proekt.weldproject.enums;

public enum Position {
    WELDER("Сварщик"),
    ELECTRICIAN("Электрик"),
    PLUMBER("Сантехник"),
    FITTER("Слесарь");

    private final String displayName;

    Position(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
