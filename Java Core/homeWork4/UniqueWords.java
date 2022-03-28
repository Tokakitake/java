package homeWork4;

import java.util.*;

public class UniqueWords {
    static List<String> words = Arrays.asList(
            "Лапша", "Рис", "Брекеты", "Конфета", "Ирис",
            "Машина", "Кот", "Собака", "Лапша", "Лапша",
            "Собака", "Брекеты", "Конфета", "Рис", "Машина",
            "Рис", "Ирис", "Собака", "Лапша", "Ирис"
    );

    static Set<String> unique = new HashSet<>(words);

}
