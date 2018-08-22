package vsimanek.examples.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vsimanek.examples.calculator.rest.dto.LoanDto;
import vsimanek.examples.calculator.service.LoanCalculatorService;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorApplicationTest {

    @Autowired
    private LoanCalculatorService loanCalculatorService;

    @Test
    public void loanCalculationCalculatorTest() {
        BigDecimal money = new BigDecimal(100000);
        int months = 96;
        double interestRate = 6.9;

        LoanDto loan = loanCalculatorService.calculateLoan(money, months, interestRate);

        assertThat(loan.getMonthFee().intValue()).isEqualTo(1358);
        assertThat(loan.getOverallFee().doubleValue()).isEqualTo(130406.45);

        months = 66;

        loan = loanCalculatorService.calculateLoan(money, months, interestRate);

        assertThat(loan.getMonthFee().intValue()).isEqualTo(1825);
        assertThat(loan.getOverallFee().doubleValue()).isEqualTo(120456.11);
    }

}