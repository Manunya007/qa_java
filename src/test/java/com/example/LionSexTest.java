package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class LionSexTest {
    private final String sex;
    private final Boolean hasManeExpected;
    private Feline feline;

    public LionSexTest(String sex, Boolean hasManeExpected) {
        this.sex = sex;
        this.hasManeExpected = hasManeExpected;
    }

    @Parameterized.Parameters
    public static Object[][] getConstructor() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Ошибка", null}
        };
    }

    @Test
    public void testGetConstructorMaleOrFemale() throws Exception {
        if (this.hasManeExpected != null) {
            // Если ожидание имеет значение (не равно null)
            Lion lion = new Lion(this.feline, this.sex);
            assertEquals(hasManeExpected.booleanValue(), lion.doesHaveMane());
        } else {
            // Если ожидание равняется null, значит ожидается исключение
            try {
                new Lion(this.feline, this.sex);
                fail("Ожидается исключение при создании Льва с неправильным полом.");
            } catch (Exception ex) {
                assertEquals("Используйте допустимые значения пола животного - самец или самка", ex.getMessage());
            }
        }
    }
}
