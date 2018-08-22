package vsimanek.examples.calculator.rest.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class LoanDto {

    @NotNull
    private BigDecimal monthFee;
    @NotNull
    private BigDecimal overallFee;

    public LoanDto(BigDecimal monthFee, BigDecimal overallFee) {
        this.monthFee = monthFee;
        this.overallFee = overallFee;
    }

    public BigDecimal getMonthFee() {
        return monthFee;
    }

    public void setMonthFee(BigDecimal monthFee) {
        this.monthFee = monthFee;
    }

    public BigDecimal getOverallFee() {
        return overallFee;
    }

    public void setOverallFee(BigDecimal overallFee) {
        this.overallFee = overallFee;
    }
}
