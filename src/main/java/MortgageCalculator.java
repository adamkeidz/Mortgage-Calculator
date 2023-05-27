public class MortgageCalculator {

    public static double calculateMonthlyPayment(double loanAmount, double annualInterestRate, int loanTermInYears) {
        double monthlyInterestRate = annualInterestRate / 100.0 / 12.0;
        int loanTermInMonths = loanTermInYears * 12;
        double monthlyPayment;

        if (monthlyInterestRate == 0) {
            monthlyPayment = loanAmount / loanTermInMonths;
        } else {
            monthlyPayment = loanAmount * (monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -loanTermInMonths)));
        }

        return monthlyPayment;
    }


    public static double estimateInterestRate(double loanAmount, double desiredMonthlyPayment, int loanTermInYears) {
        double low = 0.0;
        double high = 10.0; // Setting maximum boundary to a more realistic number
        double mid = 0.0;

        while (high - low > 0.0001) {
            mid = (high + low) / 2;
            double calculatedMonthlyPayment = calculateMonthlyPayment(loanAmount, mid, loanTermInYears);
            if (calculatedMonthlyPayment > desiredMonthlyPayment) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return (high + low) / 2;
    }


    public static void main(String[] args) {
        double loanAmountBasic = 400000;
        double annualInterestRateBasic = 4.0;
        int loanTermInYearsBasic = 30;

        double monthlyPaymentBasic = calculateMonthlyPayment(loanAmountBasic, annualInterestRateBasic, loanTermInYearsBasic);
        System.out.printf("Monthly payment for a RM %.2f loan with an interest rate of %.2f%% over %d years is RM %.2f\n", loanAmountBasic, annualInterestRateBasic, loanTermInYearsBasic, monthlyPaymentBasic);

        double loanAmountAdvanced = 400000;
        double desiredMonthlyPaymentAdvanced = 1500;
        int loanTermInYearsAdvanced = 30;

        double estimatedInterestRateAdvanced = estimateInterestRate(loanAmountAdvanced, desiredMonthlyPaymentAdvanced, loanTermInYearsAdvanced);
        System.out.printf("The estimated interest rate for a loan of RM %.2f with a desired monthly payment of RM %.2f over %d years is %.2f%%\n", loanAmountAdvanced, desiredMonthlyPaymentAdvanced, loanTermInYearsAdvanced, estimatedInterestRateAdvanced);
    }
}
