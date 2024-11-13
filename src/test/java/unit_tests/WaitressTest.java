package unit_tests;

import com.javaacademy.burger.Kitchen;
import com.javaacademy.burger.Waitress;
import com.javaacademy.burger.dish.DishType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WaitressTest {

    @Test
    @DisplayName("Успешное принятие заказа на бургер")
    public void successOrder() {
        Kitchen mockKitchen = Mockito.mock(Kitchen.class);
        Waitress waitress = new Waitress();
        Assertions.assertTrue(waitress.giveOrderToKitchen(DishType.BURGER, mockKitchen));
    }

    @Test
    @DisplayName("Неуспешное принятие заказа на фуагра")
    public void failureOrder() {
        Kitchen mockKitchen = Mockito.mock(Kitchen.class);
        Waitress waitress = new Waitress();
        Assertions.assertFalse(waitress.giveOrderToKitchen(DishType.FUAGRA, mockKitchen));
    }
}
