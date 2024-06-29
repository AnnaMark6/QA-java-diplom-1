import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[] dataForTest() {
        return new Object[][]{
                {"black bun", 100},
                {"Белая булка", 200},
                {"", 300},
                {null, 400},
                {"12345", 500},
                {"Long string red bun djfgyekudvbJYFUYw;avbbKUGqeirJFvb", 600},
                {"%$*@", 700},
                {"Float min bun", Float.MIN_VALUE},
                {"Float max bun", Float.MAX_VALUE}
        };
    }

    @Test
    public void bunTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}
