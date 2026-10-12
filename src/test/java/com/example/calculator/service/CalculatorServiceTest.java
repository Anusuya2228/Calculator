package com.example.calculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceTest {

    @Test
    void shouldAddNumbers() {
        CalculatorService service = new CalculatorService();

        double result = service.calculate(10, 5, "add");

        assertEquals(15.0, result, 0.0001);
    }
}
