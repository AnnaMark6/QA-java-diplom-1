import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    public final IngredientType type;
    public final String name;
    public final float  price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][] {
                {SAUCE,"hot sauce", 100},
                {SAUCE,"горький соус", 200},
                {SAUCE,null, 300},
                {SAUCE,"", 400},
                {FILLING,"cutlet", 100},
                {FILLING,"динозавр", 200},
                {FILLING,null, 300},
                {FILLING,"", 400},
                {null,"", 0}
        };
    }

    @Test
    public void ingredientTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), 0);
        assertEquals(type, ingredient.getType());
    }
}


