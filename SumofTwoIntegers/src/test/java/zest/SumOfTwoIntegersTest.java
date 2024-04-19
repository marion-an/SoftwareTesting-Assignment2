package zest;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Report;
import net.jqwik.api.Reporting;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.Size;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfTwoIntegersTest {

    SumOfTwoIntegers calulator = new SumOfTwoIntegers();

    @Test
    public void testBothPositiveSecondBiggerReturnResult(){
        int actual = this.calulator.getSum(2,5);
        assertEquals(7,actual);
    }

    @Test
    public void testBothPositiveSecondSmallerReturnResult(){
        int actual = this.calulator.getSum(6,1);
        assertEquals(7,actual);
    }

    @Test
    public void testSecondValueZeroReturnResult(){
        int actual = this.calulator.getSum(2,0);
        assertEquals(2,actual);
    }

    @Test
    public void testSecondNegativeBiggerReturnNegativeResult(){
        int actual = this.calulator.getSum(2,-5);
        assertEquals(-3,actual);
    }

    @Test
    public void testSecondNegativeSmallerReturnPositiveResult(){
        int actual = this.calulator.getSum(10,-2);
        assertEquals(8,actual);
    }

    @Test
    public void testBothValuesZeroReturnZero(){
        int actual = this.calulator.getSum(0,0);
        assertEquals(0,actual);
    }

    @Test
    public void testFirstNegativeSecondPositiveReturnNegativeResult(){
        int actual = this.calulator.getSum(-20,5);
        assertEquals(-15,actual);
    }

    @Test
    public void testBothNegativeSecondBiggerReturnNegativeResult(){
        int actual = this.calulator.getSum(-2,-5);
        assertEquals(-7,actual);
    }

    @Test
    public void testBothNegativeSecondSmallerReturnNegativeResult(){
        int actual = this.calulator.getSum(-20,3);
        assertEquals(-17,actual);
    }

    @Test
    public void testFirstZeroSecondPositiveReturnPositiveResult(){
        int actual = this.calulator.getSum(0,-5);
        assertEquals(-5,actual);
    }

    @Test
    public void testNullValuesThrowsException(){
        Integer a = null;
        Exception e = assertThrows(NullPointerException.class, () ->{this.calulator.getSum(a,2);});
    }

    @Test
    public void testCorrectIfNoNull(){
        int actual = this.calulator.getSum(5,-10);
        assertEquals(-5,actual);
    }

    @Property (tries = 1000)
    public void testPositiveValuesPositiveResult(@ForAll @IntRange(min=0, max = 5000) int a, @ForAll @IntRange(min = 0,max = 5000) int b){
        int expected = a + b;
        int actual = this.calulator.getSum(a,b);
        assertTrue(actual >= 0);
        assertEquals(expected,actual);
    }

    @Property (tries = 1000)
    public void testNegativeValuesNegativeResult(@ForAll @IntRange(max = 0) int a, @ForAll @IntRange(max = 0) int b){
        int expected = a + b;
        int actual = this.calulator.getSum(a,b);
        assertTrue(actual <= 0);
        assertEquals(expected,actual);
    }


}
