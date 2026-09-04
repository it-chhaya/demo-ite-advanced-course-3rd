package co.istad.chanchhaya.ecommerce.domain.valueobject;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record Money(
        // ទឹកលុយ
        BigDecimal amount
) {
    // ផ្ទៀងផ្ទាត់ទឹកលុយធំជាងសូន្យ
    public boolean isGreaterThanZero() {
        return amount.compareTo(BigDecimal.ZERO) > 0;
    }

    // ផ្ទៀងផ្ទាត់ទឹកលុយធំជាងទឹកលុយដែលបានបញ្ចូល
    public boolean isGreaterThan(Money money) {
        return amount.compareTo(money.amount) > 0;
    }

    // បន្ថែមទឹកលុយ
    public Money add(Money money) {
        return new Money(setScale(this.amount.add(money.amount)));
    }

    // ដកទឹកលុយ
    public Money subtract(Money money) {
        return new Money(setScale(this.amount.subtract(money.amount)));
    }

    // គុណទឹកលុយគិតទៅលើចំនួនដង
    public Money multiply(int multiplier) {
        return new Money(setScale(this.amount.multiply(BigDecimal.valueOf(multiplier))));
    }

    private BigDecimal setScale(BigDecimal inputAmount) {
        return inputAmount.setScale(2, RoundingMode.HALF_EVEN);
    }
}
