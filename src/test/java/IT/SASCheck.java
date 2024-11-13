package IT;

import com.javaacademy.burger.*;
import com.javaacademy.burger.dish.Dish;
import com.javaacademy.burger.dish.DishType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

public class SASCheck {

    @Test
    @DisplayName("Проверка с фейковой оплатой")
    public void successOrder() {
        Kitchen kitchen = new Kitchen();
        Waitress waitress = new Waitress();
        waitress.giveOrderToKitchen(DishType.RIBS, kitchen);
        kitchen.cook(DishType.RIBS);

        PayTerminal terminal = Mockito.mock(PayTerminal.class);
        Mockito.when(terminal.pay(DishType.RIBS, Currency.RUB))
                        .thenReturn(new Paycheck(BigDecimal.valueOf(700), Currency.RUB, DishType.RIBS));
        terminal.pay(DishType.BURGER, Currency.RUB);

        Dish expectedDish = new Dish(DishType.RIBS);
        Dish actualDish = kitchen.getCompletedDishes().get(DishType.RIBS).peek();
        Assertions.assertEquals(expectedDish, actualDish);
    }

}
