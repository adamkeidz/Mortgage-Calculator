# Mortgage Calculator

## Description

This is a simple Mortgage Calculator written in Java. It provides two primary features:

1. **Calculate Monthly Payment**: Given a loan amount, an annual interest rate, and a loan term (in years), the program calculates the monthly payment for the loan.
2. **Estimate Interest Rate**: Given a loan amount, a desired monthly payment, and a loan term (in years), the program estimates the interest rate for the loan.

## Usage 

### Calculate Monthly Payment

```java
double loanAmount = 400000;  // Enter the loan amount here
double annualInterestRate = 4.0;  // Enter the annual interest rate here
int loanTermInYears = 30;  // Enter the loan term in years here

double monthlyPayment = MortgageCalculator.calculateMonthlyPayment(loanAmount, annualInterestRate, loanTermInYears);
System.out.printf("Monthly payment for a RM %.2f loan with an interest rate of %.2f%% over %d years is RM %.2f\n", loanAmount, annualInterestRate, loanTermInYears, monthlyPayment);
```

### Estimate Interest Rate

```java
double loanAmount = 400000;  // Enter the loan amount here
double desiredMonthlyPayment = 1500;  // Enter the desired monthly payment here
int loanTermInYears = 30;  // Enter the loan term in years here

double estimatedInterestRate = MortgageCalculator.estimateInterestRate(loanAmount, desiredMonthlyPayment, loanTermInYears);
System.out.printf("The estimated interest rate for a loan of RM %.2f with a desired monthly payment of RM %.2f over %d years is %.2f%%\n", loanAmount, desiredMonthlyPayment, loanTermInYears, estimatedInterestRate);
```

---
