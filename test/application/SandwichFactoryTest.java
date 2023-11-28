package application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.holub.application.sandwich.SandwichFactory;
import com.holub.application.sandwich.Sandwich;
import com.holub.application.service.PriceManager;
import com.holub.application.constant.BreadType;
import com.holub.application.constant.ToppingType;
import com.holub.application.constant.SauceType;
import com.holub.application.constant.BeverageType;

import java.lang.reflect.Field;

public class SandwichFactoryTest {

    private PriceManager priceManager;

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        // Mock the PriceManager
        priceManager = mock(PriceManager.class);
        
        // Inject the mocked PriceManager into the PriceManager singleton
        Field instance = PriceManager.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, priceManager);
    }

    @Test
    public void testSandwichCost() {
        // Mock price returns for each item
        when(priceManager.getPrice(anyString())).thenReturn(1.00);

        // Create a sandwich with specific parameters
        Sandwich sandwich = SandwichFactory.createSandwich(
            BreadType.HONEY_OAT, 
            new ToppingType[]{ToppingType.CHEESE, ToppingType.HAM}, 
            new SauceType[]{SauceType.MUSTARD}, 
            new BeverageType[]{BeverageType.COFFEE});

        // Verify the cost calculation
        double cost = sandwich.getCost();
        // Adjust the expected cost based on the number of items and their mocked prices
        assertEquals(5.00, cost); // Example: adjust as necessary
    }
}
