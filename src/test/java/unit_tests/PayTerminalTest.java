package unit_tests;

import com.javaacademy.burger.Currency;
import com.javaacademy.burger.PayTerminal;
import com.javaacademy.burger.Paycheck;
import com.javaacademy.burger.dish.DishType;
import com.javaacademy.burger.exception.NotAcceptedCurrencyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PayTerminalTest {

    @Test
    @DisplayName("Проверка успешной оплаты бургера рублями")
    public void paySuccess() {
        PayTerminal terminal = new PayTerminal();
        Paycheck expected = new Paycheck(DishType.BURGER.getPrice(), Currency.RUB, DishType.BURGER);
        Paycheck actual = terminal.pay(DishType.BURGER, Currency.RUB);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка невозможности оплаты мозамбийскими долларами")
    public void payFailure() {
        PayTerminal terminal = new PayTerminal();
        Assertions.assertThrows(NotAcceptedCurrencyException.class, () -> terminal.pay(DishType.BURGER, Currency.MOZAMBICAN_DOLLARS));
    }
}
