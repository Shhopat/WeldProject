package com.svar_proekt.weldproject.util;

public class NoSuchItamId extends RuntimeException{
    public NoSuchItamId(String massage) {
        super(massage);
    }

    public NoSuchItamId() {
        super("Not such kind of itam");
    }
}
