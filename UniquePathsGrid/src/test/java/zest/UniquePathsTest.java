package zest;


import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UniquePathsTest {

    UniquePaths grid = new UniquePaths();
    @Test
    public void testOneByOneReturnsOne(){
        int actual = this.grid.uniquePaths(1,1);
        assertEquals(1,actual);
    }

    @Test
    public void testOneByThreeReturnsOne(){
        int actual = this.grid.uniquePaths(1,3);
        assertEquals(1,actual);
    }

    @Test
    public void testTwoByOneReturnsOne(){
        int actual = this.grid.uniquePaths(2,1);
        assertEquals(1,actual);
    }

    @Test
    public void testTwoByFiveReturnsFour(){
        int actual = this.grid.uniquePaths(2,5);
        assertEquals(5,actual);
    }

    @Test
    public void testFourByOneReturnsOne(){
        int actual = this.grid.uniquePaths(4,1);
        assertEquals(1,actual);
    }

    @Test
    public void testFourByFourReturnsTwenty(){
        int actual = this.grid.uniquePaths(4,4);
        assertEquals(20,actual);
    }

    @Test
    public void testSeventeenByThirteenReturnsHighNumber(){
        int expected = 30421755;
        int actual = this.grid.uniquePaths(17,13);
        assertEquals(expected,actual);
    }

    @Test
    public void testValueBelowOneReturnsZero(){
        int actual = this.grid.uniquePaths(-3,20);
        assertEquals(0,actual);
    }

    @Property
    public void testValueOneReturnsOne(@ForAll @IntRange(min = 1,max = 100) int a){
        int actual = this.grid.uniquePaths(a,1);
        assertEquals(1,actual);
    }

    //this test only checks for maximal value of 15 since if the numbers get too big they go out of the integer range
    @Property
    public void testValesReturnPositive(@ForAll @IntRange(min = 1,max = 15) int a, @ForAll @IntRange(min = 1, max = 15) int b){
        int actual = this.grid.uniquePaths(a,b);
        assertTrue(actual>=0);
    }

    @Property
    public void testValuesBelowOneReturnsZero(@ForAll @IntRange(max = 0) int a, @ForAll @IntRange(max = 0) int b){
        int actual = this.grid.uniquePaths(a,b);
        assertEquals(0,actual);
    }
}