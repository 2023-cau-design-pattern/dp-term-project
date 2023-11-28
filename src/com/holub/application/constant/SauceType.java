package com.holub.application.constant;

public enum SauceType {
    CHILI("chili"),
    MUSTARD("mustard"),
    RANCH("ranch");

    private final String name;

    SauceType(String name) {
        this.name = name;
    }

    public static SauceType[] getSauceType(String sauce_name) {
        String[] sauce_names = sauce_name.split(",");
        SauceType[] sauce = new SauceType[sauce_names.length];
        for (int i = 0; i < sauce_names.length; i++) {
            for (SauceType sauceType : SauceType.values()) {
                if (sauceType.getName().equals(sauce_names[i])) {
                    sauce[i] = sauceType;
                }
            }
        }
        return sauce;
    }

    public String getName() {
        return this.name;
    }
}
