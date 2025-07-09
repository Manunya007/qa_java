package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void testEatMeatReturnListFood() throws Exception {
        Feline feline = new Feline();
        String actual = feline.eatMeat().toString();
        String expected = List.of("Животные", "Птицы", "Рыба").toString();
        assertEquals("Список неверный", expected, actual);
    }

    @Test
    public void testGetFamilyReturnFeline() {
        Feline feline = new Feline();
        String actual = feline.getFamily();
        String expected = "Кошачьи";
        assertEquals("Метод должен вернуть 'Кошачьи'", expected, actual);
    }

    @Test
    public void testGetKittensReturnKittensCountOne(){
        Feline feline = new Feline();
        int actual = feline.getKittens();
        int expected = 1;
        assertEquals("Метод должен вернуть 1", expected, actual);
    }
}
