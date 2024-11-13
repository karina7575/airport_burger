package IT;

import com.javaacademy.burger.*;
import com.javaacademy.burger.dish.Dish;
import com.javaacademy.burger.dish.DishType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class OrderIT {
    @Test
    @DisplayName("Проверка чека после заказа")
    public void successOrderCheck() {
        Kitchen kitchen = new Kitchen();
        Waitress waitress = new Waitress();
        PayTerminal terminal = new PayTerminal();
        waitress.giveOrderToKitchen(DishType.BURGER, kitchen);
        kitchen.cook(DishType.BURGER);
        Paycheck expectedCheck = new Paycheck(DishType.BURGER.getPrice(), Currency.RUB, DishType.BURGER);
        Paycheck actualCheck = terminal.pay(DishType.BURGER, Currency.RUB);
        Assertions.assertEquals(expectedCheck, actualCheck);
    }

    @Test
    @DisplayName("Проверка блюда после заказа")
    public void successOrderDish() {
        Kitchen kitchen = new Kitchen();
        Waitress waitress = new Waitress();
        waitress.giveOrderToKitchen(DishType.BURGER, kitchen);
        kitchen.cook(DishType.BURGER);
        Dish expectedDish = new Dish(DishType.BURGER);
        Dish actualDish = kitchen.getCompletedDishes().get(DishType.BURGER).peek();
        Assertions.assertEquals(expectedDish, actualDish);
    }
}
