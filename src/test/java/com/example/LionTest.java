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
        when(mockFeline.getKittens()).thenReturn(3); // Мокаем количество детенышей
        Lion lion = new Lion(mockFeline, "Самка");

        assertEquals(3, lion.getKittens());
    }

    @Mock
    Feline feline;
    @Test
    public void testGetFoodReturnList() throws Exception {
        // Настраиваем подставной объект Feline
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба")); // Здесь вызываем eatMeat()

        // Создаем объект Lion с подставным Feline
        Lion lion = new Lion(feline, "Самец");

        // Проверяем результат
        List<String> foods = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), foods);

        // Проверяем, что метод eatMeat() был вызван
        verify(feline).eatMeat();
    }
}


