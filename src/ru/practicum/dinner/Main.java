package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    //generateDishCombo();
                    break;
                case "3":
                    printCombo ();
                    break;
                case "4":
                    System.out.println("Программа завершена. \nУспехов!!!");
                    scanner.close();
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Показать меню.");
        System.out.println("4 - Выход");
    }

    private static void addNewDish() {
        String dishType = "";
        boolean nextSchrit = true;

        while (true) {
            System.out.println("Введите тип блюда  (или 'done' для завершения ввода элементов) :");
            TypesOfDishes typesOfDishes;
            for (TypesOfDishes key :
                    TypesOfDishes.values()) {
                System.out.println(key.ordinal() + 1 + " Название группы: " + key);
            }
            try {
                dishType = scanner.nextLine();
                if (dishType.equalsIgnoreCase("done")) {
                    nextSchrit = false;
                    break;
                }
                TypesOfDishes.valueOf(dishType);

            } catch (IllegalArgumentException e) {
                System.out.println(e + "Такой категории нет. Выбирите категорию из списка ");
                continue;
            }

           if (nextSchrit) {
               System.out.println("Введите название блюда:");
               String dishName = scanner.nextLine();

               if (dc.menuMap.containsKey(dishType)) {
                   dc.menuMap.get(dishType).add(dishName);
               } else {
                   ArrayList<String> list = dc.menuMap.getOrDefault(dishType, new ArrayList<>());
                   list.add(dishName);
                   dc.menuMap.put(dishType, list);
               }
           }
        }   // добавьте новое блюдо
    }


/*
    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {

        }

        // сгенерируйте комбинации блюд и выведите на экран

    }*/

    private static void printCombo () {

        System.out.println("Текущее состояние HashMap:");
        for (String mapKey : dc.menuMap.keySet()) {
            System.out.println("Ключ: " + mapKey + ", Значения: " + dc.menuMap.get(mapKey));
        }
    }
}
