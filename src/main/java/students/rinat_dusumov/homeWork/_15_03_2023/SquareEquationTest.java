package main.java.students.rinat_dusumov.homeWork._15_03_2023;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareEquationTest {
    SquareEquation sq = new SquareEquation();
    @Test
    public void discriminantLessThanZero() {
        double result = sq.rootSearch(3.0,-4.0,2.0);
        assertEquals(result, 0);
    }
    @Test
    public void discriminantIsZero() {
        double result = sq.rootSearch(1.0,-6.0,9.0);
        assertEquals(result, 1);
    }
    @Test
    public void discriminantGreaterThanZero() {
        double result = sq.rootSearch(1.0,-4.0,-5.0);
        assertEquals(result, 2);
    }
}