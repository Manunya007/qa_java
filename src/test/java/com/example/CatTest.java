package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.asm.util.CheckClassAdapter.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class CatTest {

    @Test
    public void testGetSoundReturnsMeow() {
        Feline felineMock = mock(Feline.class);
        Cat cat = new Cat(felineMock);

        String sound = cat.getSound();

        assertEquals("Мяу", sound);
    }


    @Test
    public void testGetFood_CallsEatMeatOnPredator() throws Exception {
        Feline felineMock = mock(Feline.class);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(felineMock);
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
    }
}
