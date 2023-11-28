package com.holub.application.presentation.validator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class InputValidatorTest {

    private InputValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new InputValidator();
    }

    @Test
    public void testValidBreadType() {
        assertDoesNotThrow(() -> validator.validateBreadType("oat"));
        assertDoesNotThrow(() -> validator.validateBreadType("wheat"));
        assertDoesNotThrow(() -> validator.validateBreadType("white"));
    }

    @Test
    public void testInvalidBreadType() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateBreadType("InvalidBread"));
        assertThrows(IllegalArgumentException.class, () -> validator.validateBreadType("rye"));
    }

    @Test
    public void testValidPaymentMethod() {
        assertDoesNotThrow(() -> validator.validatePaymentMethod("y"));
        assertDoesNotThrow(() -> validator.validatePaymentMethod("n"));
    }

    @Test
    public void testInvalidPaymentMethod() {
        assertThrows(IllegalArgumentException.class, () -> validator.validatePaymentMethod("InvalidMethod"));
        assertThrows(IllegalArgumentException.class, () -> validator.validatePaymentMethod("p"));
    }

    @Test
    public void testValidSauceType() {
        assertDoesNotThrow(() -> validator.validateSauceType("chili"));
        assertDoesNotThrow(() -> validator.validateSauceType("mustard"));
        assertDoesNotThrow(() -> validator.validateSauceType("ranch"));
    }

    @Test
    public void testInvalidSauceType() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateSauceType("InvalidSauce"));
        assertThrows(IllegalArgumentException.class, () -> validator.validateSauceType("ketchup"));
    }

    @Test
    public void testValidToppingsType() {
        assertDoesNotThrow(() -> validator.validateToppingsType("cheese,tomato"));
        assertDoesNotThrow(() -> validator.validateToppingsType("ham"));
    }

    @Test
    public void testInvalidToppingsType() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateToppingsType("InvalidTopping"));
        assertThrows(IllegalArgumentException.class, () -> validator.validateToppingsType("bacon"));
    }

    @Test
    public void testValidBeverageType() {
        assertDoesNotThrow(() -> validator.validateBeverageType("coffee"));
        assertDoesNotThrow(() -> validator.validateBeverageType("coke"));
        assertDoesNotThrow(() -> validator.validateBeverageType("tea"));
    }

    @Test
    public void testInvalidBeverageType() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateBeverageType("InvalidBeverage"));
        assertThrows(IllegalArgumentException.class, () -> validator.validateBeverageType("water"));
    }
}