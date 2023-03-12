package com.pezesha.tasktwo;

import java.util.HashMap;
import java.util.Map;


/**
 * Pezesha Loan Amortization Loan Program.
 * @author Duke Muge
 * @version 17.0
 * @since 2023
 */
public class LoanCalculator {
    public enum Frequency{
        WEEKLY,MONTHLY,BIWEEKLY
    }

    /**
     * generates Map pf string of loan-parameters and their values
     *
     * @param loan- principal amount
     * @param n-  loan term (in months)
     * @param  rateInYear - rate per annum
     * @param  f- Repayment frequency
     * @return  map of String and Double
     */

    public static Map<String,Double> calculateTheLoanParameters(double loan, double n, double rateInYear, Frequency f )
    {
        Map<String,Double> loanParameters = new HashMap<>();
        System.out.println("-------------------------------");

        //calculate monthly  payment
        double monthlyRate = (rateInYear/100.0) / 12;
        double monthlyPayment = loan* ((monthlyRate * Math.pow(1 + monthlyRate,n))/(Math.pow(1 + monthlyRate,n)-1));
        System.out.println("The monthly payment  is  " + monthlyPayment);
        loanParameters.put("monthly_payment",monthlyPayment);

        //total amount paid
        double totalAmountPaid = monthlyPayment * n ;
        System.out.println("The total amount paid is " + totalAmountPaid);
        loanParameters.put("total_amount_paid",totalAmountPaid);

        //the total Interested paid  = totalAmount - Loan)
        double totalInterestPaid   =  (totalAmountPaid - loan);
        System.out.println("The total interest paid is "+ totalInterestPaid);
        loanParameters.put("total_interest_paid",totalInterestPaid);

        System.out.println("----------------------------------------------------------------------");
        /*
         * we create o for loop to make  our table displaying.
         * Principle,Interest  and Balance for a given period
         */
        System.out.println("TABLE DISPLAYING  PRINCIPLE ,INTEREST,BALANCE");
        System.out.println("#\tprincipal\tInterest\tBalance");
        for (int payment = 1; payment <= n; payment = payment + 1) {
            double interestPayment;
            double principlePayment;
            interestPayment = monthlyRate * loan ;
            principlePayment = monthlyPayment  - interestPayment;
            loan = loan -principlePayment;
            System.out.format("%d \t  %.2f \t %.2f  \t %.2f  \t %n" ,payment,principlePayment,interestPayment,loan);

        }

        System.out.println("-------------------------------------------------------------------");

 return loanParameters;
    }

    public static void main(String[] args) {
        System.out.println(LoanCalculator.calculateTheLoanParameters(20000,60,5,Frequency.MONTHLY));


    }
}
