import org.example.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class CalculatorTest {
    //Calculator calculator = new Calculator();

    @BeforeAll  // tato metoda se spustí jednou na začátku testování
    static void beforeAllTests() {
        System.out.println("Začátek testování");
    }

    @AfterAll  // tato metoda se spustí jednou na konci testování
    static void afterAllTests() {
        System.out.println("Konec testování");
    }

    @BeforeEach  // tato metoda se spustí před každým testem
    void init() {
        System.out.println("Začátek testu");
    }

    @AfterEach  // tato metoda se spustí za každým testem
    void afterEachTest() {
        System.out.println("Konec testu");
    }

    @Test
    @DisplayName("Test sčítání")
    void testAdd() {
        // Given -> initialize test
        Calculator calculator = new Calculator();

        // When
        int result = calculator.add(2, 3);

        // Then
        Assertions.assertEquals(5, result);
        Assertions.assertEquals(6, calculator.add(0, 6));
        Assertions.assertEquals(8, calculator.add(8, 0));
        Assertions.assertEquals(0, calculator.add(-5, 5));
        Assertions.assertEquals(-21, calculator.add(-15, -6));
        Assertions.assertEquals(0, calculator.add(0, 0));
    }

    @Test
    @DisplayName("Test násobení")
    void testMultiply() {
        // Given -> initialize test
        Calculator calculator = new Calculator();

        // When
        int result = calculator.multiply(2, 3);

        // Then
        Assertions.assertEquals(6, result);
        Assertions.assertEquals(0, calculator.multiply(0, 5));
        Assertions.assertEquals(0, calculator.multiply(9, 0));
        Assertions.assertEquals(-30, calculator.multiply(-6, 5));
        Assertions.assertEquals(-14, calculator.multiply(7, -2));
        Assertions.assertEquals(6, calculator.multiply(-3, -2));
    }

    @Test
    @DisplayName("Test vytvoření objektu")
    void testNotNull() {
        // Given
        Calculator calculator = new Calculator();
        String text = "Text";

        // Then
        Assertions.assertNotNull(calculator);
        Assertions.assertNotNull(text);
    }

    @Test
    @DisplayName("Test prázdného objektu")
    void testNull() {
        // Given
        Calculator calculator = null;
        String text = null;

        // Then
        Assertions.assertNull(calculator);
        Assertions.assertNull(text);
    }

    @Test
    @DisplayName("Test prázdného výsledku")
    void testNull2() {
        // Given
        Calculator calculator = new Calculator();
        int result = calculator.add(2,3);
        calculator.delete_result();

        // Then
        Assertions.assertNull(calculator.get_result());
    }

    @Test
    @DisplayName("Test na true/false")
    void testTrue() {
        // Given
        Calculator calculator = new Calculator();

        // When
        boolean result = calculator.add(1,2) > 0;
        boolean even = calculator.is_even(18);

        // Then
        Assertions.assertTrue(result);
        Assertions.assertTrue(even);
        Assertions.assertFalse(calculator.is_even(5));
    }

    @Test
    @DisplayName("Test polí")
    void testArrayEquals() {
        Calculator calculator = new Calculator();
        List<Integer> result_list = calculator.prime_factorization(12);
        int[] result = result_list.stream().mapToInt(Integer::intValue).toArray();

        Assertions.assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3});
        Assertions.assertArrayEquals(new int[]{2,2,3}, result);
    }


    @Test
    @DisplayName("Throw")
    void testException() {
        Calculator calculator = new Calculator();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        }, "divider can't be null");
        Assertions.assertThrows(IllegalArgumentException.class, () -> { calculator.prime_factorization(-12); });
    }

    @ParameterizedTest
    @ValueSource(strings = {"Testing", "JUnit", "SDA", "Ahoj"})
    @DisplayName("Parametrized test not null")
    void parametrizedTestNotNull(String word) {
        Assertions.assertNotNull(word);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 4, 16, 100, -6, -28})
    @DisplayName("Parametrized test for is even")
    void parametrizedTestIsEven(int number) {
        Calculator calculator = new Calculator();
        Assertions.assertTrue(calculator.is_even(number));
    }


    @ParameterizedTest
    @CsvSource({"1,false", "2,true", "0,true", "-4,true"})
    @DisplayName("Parametrized test for is even 2")
    void parametrizedTestIsEven2(String input, String expected) {
        Calculator calculator = new Calculator();
        boolean result = calculator.is_even(Integer.parseInt(input));
        Assertions.assertEquals(Boolean.valueOf(expected), result);
    }

    @ParameterizedTest
    @CsvSource({"0,0,0", "1,0,1", "1,-1,0", "3,4,7", "-5,8,3", "-6,-8,-14"})
    @DisplayName("Parametrized test for add")
    void parametrizedTestAdd(String num1, String num2, String expected) {
        Calculator calculator = new Calculator();
        int result = calculator.add(Integer.parseInt(num1), Integer.parseInt(num2));
        Assertions.assertEquals(Integer.parseInt(expected), result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    @DisplayName("Parametrized test for multiply")
    void parametrizedTestMultiply(String num1, String num2, String expected) {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(Integer.parseInt(num1), Integer.parseInt(num2));
        Assertions.assertEquals(Integer.parseInt(expected), result);
    }

}
