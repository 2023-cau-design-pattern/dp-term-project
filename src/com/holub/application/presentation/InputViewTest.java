package com.holub.application.presentation;

import static org.junit.jupiter.api.Assertions.*;

import com.holub.application.constant.BeverageType;
import com.holub.application.constant.BreadType;
import com.holub.application.constant.SauceType;
import com.holub.application.constant.ToppingType;
import com.holub.application.presentation.message.ErrorMessage;
import java.util.Arrays;
import java.util.List;
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
        String readBread = inputView.readBread();

        boolean isValidBreadType = false;
        for (BreadType breadType : BreadType.values()) {
            if (breadType.getName().equals(readBread)) {
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
        String readSauce = inputView.readSauce();

        boolean isValidSauceType = false;
        for (SauceType sauceType : SauceType.values()) {
            if (sauceType.getName().equals(readSauce)) {
                isValidSauceType = true;
                break;
            }
        }
        assertTrue(isValidSauceType, ErrorMessage.INVALID_SAUCE_TYPE.getMessage() + readSauce);
    }
    @Test
    public void testReadToppingValidInput() {
        String input = "cheese,ham\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        InputView inputView = new InputView();

        List<String> expectedToppings = Arrays.asList(ToppingType.CHEESE.getName(),
            ToppingType.HAM.getName());

        assertEquals(expectedToppings, inputView.readToppings());
    }
    @Test
    public void testReadBeverageValidInput() {
        String input = "coke\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        InputView inputView = new InputView();
        String readBeverage = inputView.readBeverage();

        boolean isValidBeverageType = false;
        for (BeverageType beverageType : BeverageType.values()) {
            if (beverageType.getName().equals(readBeverage)) {
                isValidBeverageType = true;
                break;
            }
        }
        assertTrue(isValidBeverageType, ErrorMessage.INVALID_BEVERAGE_TYPE.getMessage() + readBeverage);
    }

    @Test
    public void testReadPaymentValidInput() {
        String input = "y\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        InputView inputView = new InputView();
        assertEquals("y", inputView.readPayment());
    }
}
