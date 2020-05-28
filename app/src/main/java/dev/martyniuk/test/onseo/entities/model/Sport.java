package dev.martyniuk.test.onseo.entities.model;

public class Sport {
    public static String ID_SOCCER = "14";
    public static String ID_TENNIS = "15";
    public static String ID_VOLLEYBALL = "17";
    public static String ID_FORMULA_1 = "99";

    private String id;

    public Sport(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
