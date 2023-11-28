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
        priceManager = mock(PriceManager.class);
        
        Field instance = PriceManager.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, priceManager);
    }

    @Test
    public void testSandwichCost() {
        when(priceManager.getPrice(anyString())).thenReturn(1.00);

        Sandwich sandwich = SandwichFactory.createSandwich(
            BreadType.HONEY_OAT, 
            new ToppingType[]{ToppingType.CHEESE, ToppingType.HAM}, 
            new SauceType[]{SauceType.MUSTARD}, 
            new BeverageType[]{BeverageType.COFFEE});

        double cost = sandwich.getCost();
        assertEquals(5.00, cost);
    }
}
