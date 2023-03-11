package com.pezesha.tasktwo;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
    	// --- User inputs ---
        try (Scanner scanner = new Scanner(System.in)) { 
			double loan;
			do{
			    System.out.println("Loan amount: ");
			    loan = scanner.nextDouble();
			    if(loan < 500){
			        System.out.println("Minimum loan amount is £500\n");
			    }
			}while(loan < 500);

			int term;
      do{
			    System.out.println("Loan term in years: ");
			    term = scanner.nextInt();
			    if(term <= 0){
			        System.out.println("Loan term must be at least one year\n");
			    }
			    else if(term > 50){
			        System.out.println("Loan term cannot exceed 50 years\n");
			    }
			}while(term <=0 || term > 50);     

			double rate;
			do{
			    System.out.println("Interest rate per year: ");
			    rate = scanner.nextDouble();
			    if(rate < 0){
			        System.out.println("Interest rate cannot be negative\n");
			    }            
			}while(rate < 0);

			double downPay;
			do{
			    System.out.println("Downpayment: ");
			    downPay = scanner.nextDouble();
			    if(downPay < 0){
			        System.out.println("Downpayment cannot be negative, but can be £0\n");
			    }
			    else if(downPay>=loan){
			        System.out.println("Downpayment cannot equal or exceed your loan amount\n");
			    }
			}while(downPay < 0 || downPay >= loan);
			System.out.println();
			// --- End of user inputs
			
			// --- Call functions ---
			double monthlyPayment = calculateMonthlyPayment(loan, term, rate, downPay);
			double totalInterestAccrued = calculateInterestAccrued(monthlyPayment, loan, downPay, term);
			
			// --- Print Results ---
			System.out.println("Monthly Payments: ");
			System.out.print("£");
			System.out.printf("%.2f", monthlyPayment);
			System.out.println();
			System.out.println("Total Accrued Interest: ");
			System.out.println("£" + (int)Math.round(totalInterestAccrued));
		}
    }	

    public static double calculateMonthlyPayment(double loan, int term, double rate, double downPay )
    {
        double monthlyRate = (rate/100.0) / 12;
        int termsInMonths = term * 12;
        loan -= downPay;
        double monthlyPayment = (monthlyRate * loan)/(1-Math.pow((1+monthlyRate), -termsInMonths));
        return monthlyPayment;
    }
    
    public static double calculateInterestAccrued(double monthlyPayment, double loan, double downPay, int term)
    {
        int termsInMonths = term * 12;
        loan -= downPay;
        double totalCost = monthlyPayment * termsInMonths;
        double totalInterestAccrued = totalCost - loan;
        return totalInterestAccrued;
    } 
}
