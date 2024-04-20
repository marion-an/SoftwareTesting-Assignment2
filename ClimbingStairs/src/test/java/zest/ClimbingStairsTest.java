package zest;

import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {

    //Tests for specification-based testing and structural testing
    @Test
    void basicTest() {
        assertEquals(0, ClimbingStairs.climbStairs(0)); //T1
        assertEquals(1, ClimbingStairs.climbStairs(1)); //T2
        assertEquals(2, ClimbingStairs.climbStairs(2)); //T3
    }
    @Test
    void biggerTest() {
        assertEquals(3, ClimbingStairs.climbStairs(3)); //T4
        assertEquals(5, ClimbingStairs.climbStairs(4)); //T5
        assertEquals(8, ClimbingStairs.climbStairs(5)); //T6
    }

    @Test
    void exceptionInput() { //T7
        Exception exception = assertThrows(RuntimeException.class, () -> ClimbingStairs.climbStairs(-1));
        assertEquals("Integer cannot be negative.", exception.getMessage());
        Exception exception2 = assertThrows(RuntimeException.class, () -> ClimbingStairs.climbStairs(46));
        assertEquals("Integer too big.", exception2.getMessage());
    }

    @Test
    void SpecificationAugmentedTest() { //T8
        assertEquals(89, ClimbingStairs.climbStairs(10));
        assertEquals(1836311903 , ClimbingStairs.climbStairs(45));
    }


    @Test
    void preCondition() {
        Exception exception = assertThrows(RuntimeException.class, () -> ClimbingStairs.climbStairs(-1));
        assertEquals("Integer cannot be negative.", exception.getMessage()); //T9

        assertEquals(0, ClimbingStairs.climbStairs(0)); //T10
    }

    @Test
    void postCondition() { //T11
        assertTrue(0 <= ClimbingStairs.climbStairs(0));
        assertTrue(0 <= ClimbingStairs.climbStairs(3));


        assertEquals(0, ClimbingStairs.climbStairs(0));
        assertEquals(3, ClimbingStairs.climbStairs(3));
    }

    @Test
    void invariant() { //T12

        int[] expected = new int[]{0, 1, 2, 3, 5, 8, 13, 21, 34, 55};

        for (int i = 0; i < 10; i++) {
            assertEquals(expected[i], ClimbingStairs.climbStairs(i));
        }
    }

    @Property
    @Report(Reporting.GENERATED)
    void climbingStairsGenerated(
            @ForAll
            @IntRange(max = 45)
            int n
    ) {

        if (n<=2) {
            assertEquals(n, ClimbingStairs.climbStairs(n));
        }
        else {
            int expected = nthFibonacciTerm(n+1);
            assertEquals(expected, ClimbingStairs.climbStairs(n));
        }
    }

    public static int nthFibonacciTerm(int n) {
        double squareRootOf5 = Math.sqrt(5);
        double phi = (1 + squareRootOf5)/2;
        int nthTerm = (int) ((Math.pow(phi, n) - Math.pow(-phi, -n))/squareRootOf5);
        return nthTerm;
    }

}