package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class LionSexTest {

    private final String sex;
    private final Boolean hasManeExpected;

    public LionSexTest(String sex, Boolean hasManeExpected) {
        this.sex = sex;
        this.hasManeExpected = hasManeExpected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getConstructorData() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Ошибка", null}
        });
    }

    @Test
    public void testConstructor_SetsManeCorrectly() throws Exception {
        Feline felineMock = mock(Feline.class);  // Используем мок вместо реального объекта

        if (hasManeExpected != null) {
            Lion lion = new Lion(felineMock, sex);

            assertEquals(hasManeExpected.booleanValue(), lion.doesHaveMane());
        } else {
            try {
                new Lion(felineMock, sex);
                fail("Ожидается исключение при создании Льва с неправильным полом.");
            } catch (Exception ex) {
                assertEquals("Используйте допустимые значения пола животного - самец или самка", ex.getMessage());
            }
        }
    }
}
