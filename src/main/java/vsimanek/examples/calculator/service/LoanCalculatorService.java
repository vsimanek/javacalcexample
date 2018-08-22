package vsimanek.examples.calculator.service;

import vsimanek.examples.calculator.rest.dto.LoanDto;

import java.math.BigDecimal;

public interface LoanCalculatorService {

    /**
     * Method that calculate monthly and overall fee for bank loan with given interest.
     *
     * @param money amount of money that user wants to loan.
     * @param months amount of month that user wants to repaying.
     * @return object with monthly and overall fee in it.
     */
    LoanDto calculateLoan(BigDecimal money, int months, double interestRate);
}
