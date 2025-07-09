package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Test
    public void testGetKittensReturnKittensCount() throws Exception {

        Feline mockFeline = mock(Feline.class);
        when(mockFeline.getKittens()).thenReturn(3);
        Lion lion = new Lion(mockFeline, "Самка");

        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testGetFood_ReturnsCorrectFoodList() throws Exception {

        Feline felineMock = mock(Feline.class);
        when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion(felineMock, "Самец");

        List<String> actualFood = lion.getFood();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFood);
        verify(felineMock, times(1)).getFood("Хищник");
    }
}


