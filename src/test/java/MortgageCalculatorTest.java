import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MortgageCalculatorTest {

    @Test
    public void testCalculateMonthlyPayment() {
        double loanAmount = 400000;
        double annualInterestRate = 4.0;
        int loanTermInYears = 30;

        double expectedMonthlyPayment = 1909.66;

        double actualMonthlyPayment = MortgageCalculator.calculateMonthlyPayment(loanAmount, annualInterestRate, loanTermInYears);

        Assertions.assertEquals(expectedMonthlyPayment, actualMonthlyPayment, 0.01, "Monthly payment calculated incorrectly");
    }

    @Test
    public void testCalculateMonthlyPaymentZeroInterest() {
        double loanAmount = 400000;
        double annualInterestRate = 0;
        int loanTermInYears = 30;

        // If there's no interest, the monthly payment should just be the loan amount divided by the number of months
        double expectedMonthlyPayment = loanAmount / (loanTermInYears * 12);

        double actualMonthlyPayment = MortgageCalculator.calculateMonthlyPayment(loanAmount, annualInterestRate, loanTermInYears);

        Assertions.assertEquals(expectedMonthlyPayment, actualMonthlyPayment, 0.01, "Monthly payment calculated incorrectly for zero interest rate");
    }

    @Test
    public void testEstimateInterestRate() {
        double loanAmount = 400000;
        double desiredMonthlyPayment = 1909.66;
        int loanTermInYears = 30;


        double expectedInterestRate = 4.0;

        double actualInterestRate = MortgageCalculator.estimateInterestRate(loanAmount, desiredMonthlyPayment, loanTermInYears);

        Assertions.assertEquals(expectedInterestRate, actualInterestRate, 0.1, "Interest rate estimated incorrectly");
    }

}
