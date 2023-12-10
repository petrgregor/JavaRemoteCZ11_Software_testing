import org.assertj.core.api.Assertions;
import org.example.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTestAssertJ {

    @Test
    @DisplayName("Test součtu pomocí AssertJ")
    void testAdd() {
        Calculator calculator = new Calculator();

        int result = calculator.add(5, 7);

        Assertions.assertThat(result)
                .isEqualTo(12)
                .isNotEqualTo(13)
                .isLessThan(20)
                .isGreaterThan(0)
                .isBetween(10, 15);

        Assertions.assertThat(calculator.add(-5, -9))
                .isEqualTo(-14)
                .isLessThan(0);

    }

}
