package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountPolicyTest {

    @Test
    void noDiscountReturnsSamePrice() {
        DiscountPolicy policy = new NoDiscount();
        assertEquals(100.0, policy.apply(100.0), 1e-9);
    }

    @Test
    void percentDiscountAppliesCorrectly() {
        DiscountPolicy policy = new PercentDiscount(20);
        assertEquals(80.0, policy.apply(100.0), 1e-9);
    }

    @Test
    void percentDiscountRejectsInvalidPercent() {
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(-1));
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(101));
    }

    @Test
    void priceCalculatorUsesInjectedPolicy() {
        PriceCalculator calculator = new PriceCalculator(new PercentDiscount(10));
        assertEquals(90.0, calculator.calculate(100.0), 1e-9);
    }

    @Test
    void canReplacePolicy() {
        PriceCalculator withDiscount = new PriceCalculator(new PercentDiscount(50));
        PriceCalculator withoutDiscount = new PriceCalculator(new NoDiscount());

        assertEquals(50.0, withDiscount.calculate(100.0), 1e-9);
        assertEquals(100.0, withoutDiscount.calculate(100.0), 1e-9);
    }
}