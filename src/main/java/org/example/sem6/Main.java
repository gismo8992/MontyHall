package org.example;
/*
В рамках выполнения задачи необходимо:
● Создать свой Java Gradle проект;
● Добавить зависимость Guava (популярная библиотека от Google, содержащая набор
утилитарных механизмов).
● Воспользоваться утилитарным классом Lists:
○ Развернуть список элементов
○ Получить лист Character из строки
○ Разделить лист на группы по 2 элемента
● Воспользоваться утилитарным классом Sets
○ Получить итоговый Set из двух коллекций
○ Получить итоговый Set из общих элементов двух коллекций
○ Получить итоговый Set из непересекающихся элементов двух коллекций
 */

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //List
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 11, 10));
        System.out.println("Развернуть лист: " + Lists.reverse(list1));
        System.out.println("Строка преобразованная в список: " + Lists.charactersOf("afrefqfr"));
        System.out.println("Разделить лист на группы по 2 элемента: " + Lists.partition(list1, 2));

        //Sets
        List<Integer> list2 = new ArrayList<>(Arrays.asList(10, 10, 11, 12, 13, 14, 15, 16));
        System.out.println("Объединяет 2 коллекции: " + Sets.union(Set.copyOf(list1), Set.copyOf(list2)));
        System.out.println("Объединяет 2 коллекции по общим элементам (пересекающимся): " + Sets.intersection(Set.copyOf(list1), Set.copyOf(list2)));
        System.out.println("Объединяет 2 коллекции по уникальным элементам: " + Sets.symmetricDifference(Set.copyOf(list1), Set.copyOf(list2)));
    }
}
