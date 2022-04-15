package com.nikhilbari.gameoflife;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class UniverseTest {

    @Test
    public void scenario1() {
        int[][] intArray = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        Universe universe = new Universe(intArray);

        universe.tick();
        int[][] actual = universe.currentStatus();


        int[][] expected = new int[][]{{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 1, 0}};

        Assertions.assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void scenario2() {
        int[][] intArray = new int[][]{{1, 1}, {1, 0}};
        Universe universe = new Universe(intArray);

        universe.tick();
        int[][] actual = universe.currentStatus();


        int[][] expected = new int[][]{{1, 1}, {1, 1}};
        Assertions.assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void scenario3() {
        int[][] intArray = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},

        };
        Universe universe = new Universe(intArray);

        universe.tick();
        int[][] actual = universe.currentStatus();


        int[][] expected = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        Assertions.assertTrue(Arrays.deepEquals(expected, actual));
    }
}
