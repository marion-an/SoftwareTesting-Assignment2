package zest;

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {

        if(a < Integer.MIN_VALUE || a > Integer.MAX_VALUE){
            throw new RuntimeException("the input value a is out of the 32 bit range");
        } else if (b < Integer.MIN_VALUE || b > Integer.MAX_VALUE) {
            throw new RuntimeException("the input value b is out of the 32 bit range");
        }

        while (b != 0) {
            int carry = (a & b) << 1;  // Carry now contains common set bits of a and b
            a = a ^ b;  // Sum of bits of a and b where at least one of the bits is not set
            b = carry;  // Carry is shifted by one so that adding it to a gives the required sum
        }

        if(a < Integer.MIN_VALUE || a > Integer.MAX_VALUE) {
            throw new RuntimeException("the result value is out of the 32 bit range");
        }
        return a;
    }
}
