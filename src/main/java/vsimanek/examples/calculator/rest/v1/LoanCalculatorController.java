package vsimanek.examples.calculator.rest.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vsimanek.examples.calculator.rest.dto.LoanDto;
import vsimanek.examples.calculator.service.LoanCalculatorService;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@RestController
@Validated
@RequestMapping("/v1")
public class LoanCalculatorController {

    @Autowired
    private LoanCalculatorService loanCalculatorService;

    @GetMapping(path = "/loan")
    public LoanDto calculateLoan(@NotNull @Min(value = 20000) @Max(value = 800000) @RequestParam(value = "money") BigDecimal money,
                                 @NotNull @Min(value = 24) @Max(value = 96) @RequestParam(value = "months") int months,
                                 @NotNull @RequestParam(value = "interest") double interestRate) {
        return loanCalculatorService.calculateLoan(money, months, interestRate);
    }
}
