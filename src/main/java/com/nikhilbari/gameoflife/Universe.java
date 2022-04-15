package com.nikhilbari.gameoflife;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Universe {
    private Map<Coordinates, Life> coordinatesLifeMap = new HashMap<>();
    private Coordinates maxCoordinates;

    public Universe(int[][] inputLives) {
        processInputToLives(inputLives);
        setNeighbours();
    }

    private void setNeighbours() {
        for (Coordinates coordinates : coordinatesLifeMap.keySet()) {
            Life currentLife = coordinatesLifeMap.get(coordinates);
            List<Coordinates> neighboursCoordinates = coordinates.getNeighboursCoordinates();
            for (Coordinates neighbourCoordinates : neighboursCoordinates) {
                Life neighbour = coordinatesLifeMap.get(neighbourCoordinates);
                if (neighbour != null) {
                    currentLife.addNeighbour(neighbour);
                }
            }
        }
    }


    private void processInputToLives(int[][] inputLives) {
        for (int coordinateX = 0; coordinateX < inputLives.length; coordinateX++) {
            int[] row = inputLives[coordinateX];
            for (int coordinateY = 0; coordinateY < row.length; coordinateY++) {
                int value = row[coordinateY];
                Boolean alive = (value == 1);

                Coordinates coordinates = new Coordinates(coordinateX, coordinateY);
                Life life = new Life(alive);
                coordinatesLifeMap.put(coordinates, life);
                maxCoordinates = coordinates;
            }
        }
    }

    public void tick() {

        Set<Map.Entry<Coordinates, Life>> lives = coordinatesLifeMap.entrySet();
        Set<Coordinates> coordinates = coordinatesLifeMap.keySet();

        for (Coordinates coordinates1 : coordinates) {
            coordinatesLifeMap.get(coordinates1).calculateNextGeneration();
        }
        for (Coordinates coordinates1 : coordinates) {
            coordinatesLifeMap.get(coordinates1).tick();
        }
    }

    public int[][] currentStatus() {
        int[][] outputLives = new int[maxCoordinates.getX() + 1][maxCoordinates.getY() + 1];
        for (int i = 0; i <= maxCoordinates.getX(); i++) {
            for (int j = 0; j <= maxCoordinates.getY(); j++) {
                outputLives[i][j] = coordinatesLifeMap.get(new Coordinates(i, j)).isAlive() ? 1 : 0;
            }

        }

        return outputLives;
    }
}
