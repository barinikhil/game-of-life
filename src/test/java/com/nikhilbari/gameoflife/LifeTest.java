package com.nikhilbari.gameoflife;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class LifeTest {

    @Test
    public void shouldBeInitiallyAlive() {
        Life life = new Life(Boolean.TRUE);

        Assertions.assertTrue(life.isAlive());
    }

    @Test
    public void shouldBeInitiallyDead() {
        Life life = new Life(Boolean.FALSE);

        Assertions.assertFalse(life.isAlive());
    }

    @Test
    public void shouldBeDeadNextStageAsOnlyOneNeighbourAlive() {
        Life life = new Life(Boolean.TRUE);
        Life neighbour1 = new Life(Boolean.TRUE);
        Life neighbour2 = new Life(Boolean.FALSE);
        Life neighbour3 = new Life(Boolean.FALSE);
        life.addNeighbour(neighbour1);
        life.addNeighbour(neighbour2);
        life.addNeighbour(neighbour3);

        life.calculateNextGeneration();
        life.tick();

        Assertions.assertFalse(life.isAlive());
    }

    @Test
    public void shouldBeAliveNextStageAsTwoNeighbourAlive() {
        Life life = new Life(Boolean.TRUE);
        Life neighbour1 = new Life(Boolean.TRUE);
        Life neighbour2 = new Life(Boolean.TRUE);
        Life neighbour3 = new Life(Boolean.FALSE);
        life.addNeighbour(neighbour1);
        life.addNeighbour(neighbour2);
        life.addNeighbour(neighbour3);

        life.calculateNextGeneration();
        life.tick();

        Assertions.assertTrue(life.isAlive());
    }

    @Test
    public void shouldBeDeadNextStageAsTwoNeighbourAlive() {
        Life life = new Life(Boolean.FALSE);
        Life neighbour1 = new Life(Boolean.TRUE);
        Life neighbour2 = new Life(Boolean.TRUE);
        Life neighbour3 = new Life(Boolean.FALSE);
        life.addNeighbour(neighbour1);
        life.addNeighbour(neighbour2);
        life.addNeighbour(neighbour3);

        life.calculateNextGeneration();
        life.tick();

        Assertions.assertFalse(life.isAlive());
    }

    @Test
    public void shouldBeAliveNextStageAsThreeNeighbourAlive() {
        Life life = new Life(Boolean.TRUE);
        Life neighbour1 = new Life(Boolean.TRUE);
        Life neighbour2 = new Life(Boolean.TRUE);
        Life neighbour3 = new Life(Boolean.TRUE);
        life.addNeighbour(neighbour1);
        life.addNeighbour(neighbour2);
        life.addNeighbour(neighbour3);

        life.calculateNextGeneration();
        life.tick();

        Assertions.assertTrue(life.isAlive());
    }

    @Test
    public void shouldBeDeadNextStageAsFourNeighbourAlive() {
        Life life = new Life(Boolean.TRUE);
        Life neighbour1 = new Life(Boolean.TRUE);
        Life neighbour2 = new Life(Boolean.TRUE);
        Life neighbour3 = new Life(Boolean.TRUE);
        Life neighbour4 = new Life(Boolean.TRUE);
        life.addNeighbour(neighbour1);
        life.addNeighbour(neighbour2);
        life.addNeighbour(neighbour3);
        life.addNeighbour(neighbour4);

        life.calculateNextGeneration();
        life.tick();

        Assertions.assertFalse(life.isAlive());
    }

    @Test
    public void shouldBeAliveNextStageAsThreeNeighbourAliveButCurrentIsAlive() {
        Life life = new Life(Boolean.TRUE);
        Life neighbour1 = new Life(Boolean.TRUE);
        Life neighbour2 = new Life(Boolean.TRUE);
        Life neighbour3 = new Life(Boolean.TRUE);
        Life neighbour4 = new Life(Boolean.FALSE);
        life.addNeighbour(neighbour1);
        life.addNeighbour(neighbour2);
        life.addNeighbour(neighbour3);
        life.addNeighbour(neighbour4);

        life.calculateNextGeneration();
        life.tick();

        Assertions.assertTrue(life.isAlive());
    }

    @Test
    public void shouldBeAliveNextStageAsThreeNeighbourAliveButCurrentIsDead() {
        Life life = new Life(Boolean.FALSE);
        Life neighbour1 = new Life(Boolean.TRUE);
        Life neighbour2 = new Life(Boolean.TRUE);
        Life neighbour3 = new Life(Boolean.TRUE);
        Life neighbour4 = new Life(Boolean.FALSE);
        life.addNeighbour(neighbour1);
        life.addNeighbour(neighbour2);
        life.addNeighbour(neighbour3);
        life.addNeighbour(neighbour4);

        life.calculateNextGeneration();
        life.tick();

        Assertions.assertTrue(life.isAlive());
    }
}
