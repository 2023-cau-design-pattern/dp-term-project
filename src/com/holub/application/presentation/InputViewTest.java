package com.holub.application.presentation;

import static org.junit.jupiter.api.Assertions.*;

import com.holub.application.constant.BeverageType;
import com.holub.application.constant.BreadType;
import com.holub.application.constant.SauceType;
import com.holub.application.constant.ToppingType;
import com.holub.application.presentation.message.ErrorMessage;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class InputViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreamsAndScanner() {
        System.setOut(new PrintStream(outContent));
        Console.close();
    }

    @AfterEach
    public void restoreStreamsAndScanner() {
        System.setOut(originalOut);
        Console.close();
    }
    @Test
    public void testReadBreadWithSpecificInput() {
        String input = "wheat\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        InputView inputView = new InputView();
        BreadType readBread = inputView.readBread();

        boolean isValidBreadType = false;
        for (BreadType breadType : BreadType.values()) {
            if (breadType.equals(readBread)) {
                isValidBreadType = true;
                break;
            }
        }
        assertTrue(isValidBreadType, ErrorMessage.INVALID_BREAD_TYPE.getMessage() + readBread);
    }

    @Test
    public void testReadSauceValidInput() {
        String input = "chili\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        InputView inputView = new InputView();
        SauceType[] readSauces = inputView.readSauce();

        boolean isValidSauceType = false;
        for (SauceType readSauce : readSauces) {
            for (SauceType sauceType : SauceType.values()) {
                if (sauceType.equals(readSauce)) {
                    isValidSauceType = true;
                    break;
                }
            }
            if (!isValidSauceType) {
                break;
            }
        }
        assertTrue(isValidSauceType, ErrorMessage.INVALID_SAUCE_TYPE.getMessage() + Arrays.toString(readSauces));
    }
    @Test
    public void testReadToppingsValidInput() {
        String input = "cheese,ham\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        InputView inputView = new InputView();
        ToppingType[] readToppings = inputView.readToppings();

        boolean isValidToppingType = false;
        for (ToppingType readTopping : readToppings) {
            for (ToppingType toppingType : ToppingType.values()) {
                if (toppingType.equals(readTopping)) {
                    isValidToppingType = true;
                    break;
                }
            }
            if (!isValidToppingType) {
                break;
            }
        }

        assertTrue(isValidToppingType, ErrorMessage.INVALID_TOPPINGS_TYPE.getMessage() + Arrays.toString(readToppings));
    }
    @Test
    public void testReadBeverageValidInput() {
        String input = "coke\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        InputView inputView = new InputView();
        BeverageType[] readBeverages = inputView.readBeverage();

        boolean isValidBeverageType = false;
        for (BeverageType readBeverage : readBeverages) {
            for (BeverageType beverageType : BeverageType.values()) {
                if (beverageType.equals(readBeverage)) {
                    isValidBeverageType = true;
                    break;
                }
            }
            if (!isValidBeverageType) {
                break;
            }
        }
        assertTrue(isValidBeverageType, ErrorMessage.INVALID_BEVERAGE_TYPE.getMessage() + readBeverages);
    }

    @Test
    public void testReadPaymentValidInput() {
        String input = "y\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        InputView inputView = new InputView();
        assertEquals("y", inputView.readPayment());
    }
}
