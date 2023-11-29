package com.holub.application;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.holub.application.constant.BeverageType;
import com.holub.application.constant.BreadType;
import com.holub.application.constant.SauceType;
import com.holub.application.constant.ToppingType;
import com.holub.application.presentation.ConsoleController;
import com.holub.application.presentation.Order;
import com.holub.application.service.OrderService;
import com.holub.application.service.PriceManager;
import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SandwichMachineTest {
    private PriceManager priceManager;
    private OrderService orderService = OrderService.getInstance();
    private ConsoleController consoleController;

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        priceManager = mock(PriceManager.class);

        Field instance = PriceManager.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, priceManager);

        consoleController = mock(ConsoleController.class);
    }

    @Test
    public void testRun() {
        when(priceManager.getPrice(anyString())).thenReturn(1.00);
        when(consoleController.readOrder()).thenReturn(new Order(
            BreadType.OAT,
            new SauceType[]{SauceType.MUSTARD},
            new ToppingType[]{ToppingType.CHEESE, ToppingType.HAM},
            new BeverageType[]{BeverageType.COFFEE}
        ));

        SandwichMachine sandwichMachine = new SandwichMachine();

        sandwichMachine.run(consoleController);

        verify(consoleController).readOrder();

        String result = orderService.selectOrderBy("totalPrice");
        assertTrue(result.contains("Oat Bread Sandwich"));
    }
}
