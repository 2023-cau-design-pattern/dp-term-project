package application;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.holub.application.sandwich.SandwichFactory;
import com.holub.application.sandwich.Sandwich;
import com.holub.application.constant.BreadType;
import com.holub.application.constant.ToppingType;
import com.holub.application.constant.SauceType;
import com.holub.application.constant.BeverageType;

public class SandwichTest {

    @Test
    public void testCreateSandwich() {
        BreadType breadType = BreadType.HONEY_OAT;
        ToppingType[] toppings = {ToppingType.CHEESE, ToppingType.HAM};
        SauceType[] sauces = {SauceType.MUSTARD};
        BeverageType[] beverages = {BeverageType.COFFEE};

        Sandwich sandwich = SandwichFactory.createSandwich(breadType, toppings, sauces, beverages);

        assertNotNull(sandwich);
        // Verify that the sandwich description contains the expected elements
        String description = sandwich.getDescription();
        assertTrue(description.contains("Honey Oat Bread Sandwich"));
        assertTrue(description.contains("cheese"));
        assertTrue(description.contains("ham"));
        assertTrue(description.contains("mustard"));
        assertTrue(description.contains("coffee"));
    }
}
