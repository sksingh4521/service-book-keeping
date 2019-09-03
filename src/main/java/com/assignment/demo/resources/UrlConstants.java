package com.assignment.demo.resources;

public class UrlConstants {
    private UrlConstants() {
    }

    public static final String VERSION = "/v1";

    public static final String API = "/api";

    public static final String VERSIONED_API = API+VERSION;

    public static final String LIBRARY = "/library";

    public static final String URI = LIBRARY+VERSIONED_API;

}
