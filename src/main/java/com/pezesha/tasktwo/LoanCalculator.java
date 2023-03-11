package com.pezesha.tasktwo;

import java.util.Scanner;

public class LoanCalculator {
    /*
     A- periodic payment
     P -principle amount/Loan Balance/starting amount
     n -> number of payments
     I -> interest rate
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Loan Amount");
        double p = input.nextDouble();

        System.out.println("Enter no years");
        double years = input.nextDouble();

         //APR -> Annual percentage for Loan
        System.out.println("Enter the APR for the Loan");
        double APR = input.nextDouble();

        //calculate the interest i -> per monthly  installments
        //Assumption is that we are paying monthly percentage(i)
        double i  = APR/1200 ;

        double n = years * 12;

        //mothly payment
        double A = p * ((i * Math.pow(1 + i,n))/(Math.pow(1 + i,n)-1));
// display table showing
        double interestPayment,principlePayment;
        System.out.println("#\tprincipal\tInterest\tBalance");
        for (int payment = 1; payment <= n; payment = payment + 1) {
            interestPayment = i * p ;
            principlePayment = A  - interestPayment;
            p = p -principlePayment;
            System.out.format("%d \t  %.2f \t %.2f  \t %.2f  \t %n" ,payment,principlePayment,interestPayment,p);

        }

        input.close();





    }
}
