package com.pezesha.tasktwo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }



    @Test
    void  testEquality(){
        Map<String,Double> param = LoanCalculator.calculateTheLoanParameters(20000,60,5, LoanCalculator.Frequency.MONTHLY);
//        assertEquals(param,new Dollar(5));
//        assertEquals(param.get(1),_);

    }
}
