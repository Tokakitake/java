package homeWork4;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        //Task 1
        System.out.println(UniqueWords.unique.toString());//уникальные слова
        for (String key : UniqueWords.unique) {
            System.out.println(key + ": " + Collections.frequency(UniqueWords.words, key));//подсчитать повторяющиеся
        }

        System.out.println("");

        //Task 2
        Phonebook phonebook = new Phonebook();

        phonebook.add("Иванов", "223344");
        phonebook.add("Иванов", "22334411");
        phonebook.add("Петров", "22334499");
        phonebook.add("Сидоров", "22334488");
        phonebook.add("Иванов", "22334422");

        //получаем номера
        System.out.println(phonebook.get("Иванов"));
        System.out.println(phonebook.get("Петров"));
        System.out.println(phonebook.get("Сидоров"));

        //отсуствие
        System.out.println(phonebook.get("Кузнецов"));

        //записать существующий номер
        phonebook.add("Иванов", "223344");
        System.out.println(phonebook.get("Иванов"));
    }
}
