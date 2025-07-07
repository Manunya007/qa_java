package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatTest {

    @Test
    public void testGetSoundReturnValueForCat(){
        Cat cat = new Cat(new Feline());
        String actual = cat.getSound();
        String expected = "Мяу";
        assertEquals("Метод getSound() должен вернуть 'Мяу'", expected, actual);
    }

    @Test
    public void testGetFoodReturnList() throws Exception {
        Cat cat = new Cat(new Feline());
        String actual = cat.getFood().toString();
        String expected = List.of("Животные", "Птицы", "Рыба").toString();
        assertEquals("Список неверный", expected, actual);
    }
}
