package co.istad.chanchhaya.ecommerce.domain.valueobject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    // ទឹកលុយ
    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public static final Money ZERO = new Money(BigDecimal.ZERO);

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


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Money money)) return false;
        return Objects.equals(setScale(amount), setScale(money.amount));
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(setScale(amount));
    }
}
