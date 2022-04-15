package com.nikhilbari.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoordinatesTest {

    @Test
    void getNeighboursCoordinates() {

        Coordinates coordinates = new Coordinates(2, 1);

        List<Coordinates> neighboursCoordinates = coordinates.getNeighboursCoordinates();
        List<Coordinates> expected = Arrays.asList(
                new Coordinates(1, 0),
                new Coordinates(1, 1),
                new Coordinates(1, 2),
                new Coordinates(2, 0),
                new Coordinates(2, 2),
                new Coordinates(3, 0),
                new Coordinates(3, 1),
                new Coordinates(3, 2)
        );
        assertEquals(expected, neighboursCoordinates);
    }
}