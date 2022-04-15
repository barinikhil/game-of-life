package com.nikhilbari.gameoflife;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
public class Coordinates {

    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<Coordinates> getNeighboursCoordinates() {
        List<Coordinates> coordinatesList = new ArrayList<>();
        int maxX = x + 1;
        int minX = x - 1;
        int maxY = y + 1;
        int minY = y - 1;
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                coordinatesList.add(new Coordinates(i, j));
            }
        }
        coordinatesList.remove(this);

        return coordinatesList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates coordinates = (Coordinates) o;
        return y == coordinates.y && x == coordinates.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }


    @Override
    public String toString() {
        return "Coordinates{" + "x=" + x + ", y=" + y + '}';
    }
}
