package com.test.thread;
import java.math.BigInteger;

public class ComplexCalculation {
	
	public static void main(String[] args) {
		ComplexCalculation c = new ComplexCalculation();
		System.out.println(c.calculateResult(BigInteger.valueOf(333333), BigInteger.valueOf(3), BigInteger.valueOf(33333345), BigInteger.valueOf(5)));
		
	}
	
    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        BigInteger result;
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */
        
        PowerCalculatingThread p1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread p2 = new PowerCalculatingThread(base2, power2);
        p1.start();
        p2.start();

        BigInteger  result1 = p1.getResult() ;
        BigInteger  result2 = p2.getResult();
        
        return result = result1.add(result2);
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;
    
        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }
    
        @Override
        public void run() {
           /*
           Implement the calculation of result = base ^ power           
           */
        	 //BigInteger result = BigInteger.ONE;
        	  while (power.signum() > 0) {
        	    if (power.testBit(0)) result = result.multiply(base);
        	    base = base.multiply(base);
        	    power = power.shiftRight(1);
        	  }
        }
    
        public BigInteger getResult() { return result; }
    }
}