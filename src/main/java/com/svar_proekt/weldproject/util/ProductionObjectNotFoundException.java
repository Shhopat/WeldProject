package com.svar_proekt.weldproject.util;

public class ProductionObjectNotFoundException extends RuntimeException {
    public ProductionObjectNotFoundException(String latter) {
        super(latter);
    }
    public ProductionObjectNotFoundException() {
        super("This kind of production not found!");
    }
}
