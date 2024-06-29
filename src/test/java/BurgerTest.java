import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    @Mock
    private Bun bun;

    private final String reseipt = "(==== Космическая ====)\n" +
            "= filling метеорит =\n" +
            "(==== Космическая ====)\n" +
            "\n" +
            "Price: 9,000000\n";

    @Before
    public void setUp() {
        bun = mock(Bun.class);
        when(bun.getPrice()).thenReturn(100f);

        burger = new Burger();
        burger.setBuns(bun);

        Ingredient ingredient1 = mock(Ingredient.class);
        when(ingredient1.getPrice()).thenReturn(200f);

        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredient2.getPrice()).thenReturn(300f);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
    }

    @Test
    public void getPriceTest() {
        float expectedPrice = 100 * 2 + 200 + 300;
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        Bun bun = Mockito.mock(Bun.class);
        Ingredient ingredient = Mockito.mock(Ingredient.class);

        Mockito.when(bun.getName()).thenReturn("Космическая");
        Mockito.when(ingredient.getName()).thenReturn("метеорит");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);

        Burger burger = Mockito.spy(Burger.class);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.doReturn(9f).when(burger).getPrice();
        assertEquals(reseipt, burger.getReceipt());
    }

    @Test
    public void addIngredientTest() {
        Ingredient ingredient = mock(Ingredient.class);
        when(ingredient.getPrice()).thenReturn(200f);

        burger.addIngredient(ingredient);

        float expectedPrice = (100 * 2 + 200 + 300) + 200;
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredient1 = mock(Ingredient.class);
        when(ingredient1.getPrice()).thenReturn(200f);
        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredient2.getPrice()).thenReturn(300f);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1);

        float expectedPrice = (100 * 2 + 200 + 300) + 300 + 200;
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ingredient1 = mock(Ingredient.class);
        when(ingredient1.getPrice()).thenReturn(200f);
        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredient2.getPrice()).thenReturn(300f);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(0);

        float expectedPrice = (100 * 2 + 200 + 300) + 300;
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
    }

}
