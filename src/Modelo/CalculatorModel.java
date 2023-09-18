package Modelo;
import java.math.BigInteger;
public class CalculatorModel {
    public long sum(long value, long valueToBeAdded){
        return value + valueToBeAdded;
    }
    public long subtract(long value, long valueToBeSubtracted){
        return value -  valueToBeSubtracted;
    }
    public long multiply(long value, long valueToBeMultiplied){
        return value * valueToBeMultiplied;
    }
    public long divide(long value, long valueToDivideBy){
        if(valueToDivideBy==0) throw new ArithmeticException("Division by 0 is undefined");
        return value / valueToDivideBy;
    }
    public long mod(long value, long modToCalculate){ return value % modToCalculate; }
    public BigInteger calculateFactorial(int n) {//This method uses RECURSION to find the factorial
        if (n < 0) throw new IllegalArgumentException("Factorial not defined for negative numbers");
        if (n > 69) throw new IllegalArgumentException("Factorial can't be larger than 69");
        if(n ==0) return BigInteger.ZERO;

        BigInteger val = BigInteger.valueOf(n);
        if (val.compareTo(BigInteger.ONE) == 0 || val.compareTo(BigInteger.ZERO) == 0) return BigInteger.ONE;
        return val.multiply(val.subtract(BigInteger.ONE)).multiply(calculateFactorial(n - 2));
    }
    public double calculatePercentage ( long value, int percen){
        double percentage = percen / 100d;
        return  (value * percentage);
    }

}
