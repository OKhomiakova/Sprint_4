package ru.practicum.unit;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.practicum.Account;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountParametrizedTest {

    @Parameterized.Parameters(name = "Тест: {0} {1}")
    public static Object[][] getStringData() {
        return new Object[][] {
                    {"", false},
                    {" ", false},
                    {"   ", false},
                    {"Т ", false}, // 1 символ, 1 пробел
                    {"ТШ", false}, // 2 символа
                    {"Т Ш", true}, // 3 символа
                    {"Ти Ш", true}, // 4 символа
                    {"т ш", true},
                    {"T S", true},
                    {"Тимоти Шаламе", true},
                    {"Тимоти11 Шаламе11", true},
                    {"Тимофей Шаламеевич", true}, // 18 символов
                    {"Тимофей Шаламееевич", true}, // 19 символов
                    {"Тимоффей Шаламееевич", false}, // 20 символов
                    {"Тимоти Янович Шалам", false}, // 19 символов, 2 пробела
                    {"ТимотейШевроле", false},
                    {" Тимоти Шаламе", false},
                    {"Тимоти Шаламе ", false},
                    {" Тимоти Шаламе ", false},
                    {" ТимотиШаламе", false},
                    {"ТимотиШаламе ", false},
                    {null, false},
        };
    }

    private final String testString;
    private final boolean expectedValue;

    public AccountParametrizedTest(String testString, boolean expectedValue) {
        this.testString = testString;
        this.expectedValue = expectedValue;
    }

    @Test
    @DisplayName("Проверка валидности имени")
    public void checkStringValidity() {
        Account name = new Account(testString);
        // Act
        boolean actualValue = name.checkNameToEmboss();
        // Assert
        assertEquals(expectedValue, actualValue);
    }
}

