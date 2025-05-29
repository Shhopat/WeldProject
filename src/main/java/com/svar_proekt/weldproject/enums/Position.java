package com.svar_proekt.weldproject.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Position {
    WELDER("Сварщик"),
    ELECTRICIAN("Электрик"),
    PLUMBER("Сантехник"),
    FITTER("Слесарь");

    private final String displayName;




}
