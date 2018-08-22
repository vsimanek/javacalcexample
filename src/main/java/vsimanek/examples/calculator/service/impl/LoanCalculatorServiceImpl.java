package vsimanek.examples.calculator.service.impl;

import org.springframework.stereotype.Service;
import vsimanek.examples.calculator.rest.dto.LoanDto;
import vsimanek.examples.calculator.service.LoanCalculatorService;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class LoanCalculatorServiceImpl implements LoanCalculatorService {

    private static int MONTHS_IN_YEAR = 12;

    @Override
    public LoanDto calculateLoan(BigDecimal money, int months, double interestRate) {
        BigDecimal monthlyPayment = monthlyPayment(money, months, interestRate);

        BigDecimal wholePayment = monthlyPayment.multiply(new BigDecimal(months));

        monthlyPayment = monthlyPayment.setScale(0, RoundingMode.FLOOR);
        wholePayment = wholePayment.setScale(2, RoundingMode.FLOOR);

        return new LoanDto(monthlyPayment, wholePayment);
    }

    private BigDecimal monthlyPayment(BigDecimal money, int months, double interestRate) {
        double disc = 1 / (1 + (interestRate / 100) / MONTHS_IN_YEAR);

        return money.multiply(BigDecimal.valueOf((interestRate / 100) / MONTHS_IN_YEAR)).divide(new BigDecimal(1 - Math.pow(disc, months)), RoundingMode.FLOOR);
    }
}
