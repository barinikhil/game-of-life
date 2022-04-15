package com.nikhilbari.gameoflife;

import java.util.ArrayList;
import java.util.List;


public class Life {
    private List<Life> neighbours = new ArrayList<>();
    private boolean alive;
    private boolean nextGenerationAlive;

    public Life(Boolean alive) {
        this.alive = alive;
    }

    public void addNeighbour(Life neighbour) {
        neighbours.add(neighbour);
    }

    public void calculateNextGeneration() {
        int neighboursAlive = getNeighboursAliveCount();
        if (neighboursAlive < 2) {
            nextGenerationAlive = Boolean.FALSE;
        } else if (neighboursAlive == 3) {
            nextGenerationAlive = Boolean.TRUE;
        } else if (neighboursAlive == 2) {
            nextGenerationAlive = alive;
        } else if (neighboursAlive > 3) {
            nextGenerationAlive = Boolean.FALSE;
        }
    }

    private int getNeighboursAliveCount() {
        int neighboursAlive = 0;
        for (Life neighbour : neighbours) {
            if (neighbour.alive) {
                neighboursAlive = neighboursAlive + 1;
            }
        }
        return neighboursAlive;
    }

    public void tick() {
        alive = nextGenerationAlive;
    }

    public boolean isAlive() {
        return alive;
    }
}
