package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineKittensTest {
    private final int kittensCount;
    public final int result;

    public FelineKittensTest(int kittensCount, int result){
        this.kittensCount = kittensCount;
        this.result = result;
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
