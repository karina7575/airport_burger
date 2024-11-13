import com.javaacademy.burger.Kitchen;
import com.javaacademy.burger.dish.Dish;
import com.javaacademy.burger.dish.DishType;
import com.javaacademy.burger.exception.KitchenHasNoGasException;
import com.javaacademy.burger.exception.UnsupportedDishTypeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class KitchenTest {

    @Test
    @DisplayName("Приготовление бургера")
    public void cookSuccess() {
        Kitchen kitchen = new Kitchen();
        kitchen.cook(DishType.BURGER);
        Dish expected = new Dish(DishType.BURGER);
        Dish actual = kitchen.getCompletedDishes().get(DishType.BURGER).peek();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка исключения при отсутствии газа")
    public void cookFailure() {
        Kitchen kitchen = new Kitchen();
        kitchen.setHasGas(false);
        Assertions.assertThrows(KitchenHasNoGasException.class, () -> kitchen.cook(DishType.BURGER));
    }

    @Test
    @DisplayName("Проверка исключения при запросе фуагра")
    public void cookFuagraFailure() {
        Kitchen kitchen = new Kitchen();
        Assertions.assertThrows(UnsupportedDishTypeException.class, () -> kitchen.cook(DishType.FUAGRA));
    }

}
