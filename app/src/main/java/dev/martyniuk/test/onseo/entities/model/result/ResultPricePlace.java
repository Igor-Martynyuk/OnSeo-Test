package dev.martyniuk.test.onseo.entities.model.result;

public class ResultPricePlace extends Result {
    private Position position;

    ResultPricePlace(String name, Position position) {
        super(name);

        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    enum Position {
        FIRST,
        SECOND,
        THIRD
    }
}
