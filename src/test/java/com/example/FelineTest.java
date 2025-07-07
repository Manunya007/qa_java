package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTest {
    private final int kittensCount;
    public final int result;

    public FelineTest (int kittensCount, int result){
        this.kittensCount = kittensCount;
        this.result = result;
    }

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
    @Parameterized.Parameters
    public static Object[][] getKittensReturnKittensCount(){
        return new Object [][] {
                {1, 1},
                {4, 4},
                {25, 25}
        };
    }
    @Test
    public void testGetKittensReturnKittensCountResult() {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittensCount);
        assertEquals(result, actual);
    }
}
