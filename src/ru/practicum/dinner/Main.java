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
                    generateDishCombo();
                    break;
                case "3":
                    printCombo();
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

        System.out.println("Введите тип блюда:");
        String selectedType = scanner.nextLine();

        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        if (dc.menuMap.containsKey(selectedType)) {
            dc.menuMap.get(selectedType).add(dishName);
        } else {
            ArrayList<String> list = new ArrayList<>();
            list.add(dishName);
            dc.menuMap.put(selectedType, list);
            System.out.println("vv");
        }
    }


    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        ArrayList <String> tipSpeise = new ArrayList<>();
        while (true) {
            String nextItem = scanner.nextLine();
            //реализуйте ввод типов блюд
            if (!nextItem.isEmpty()) {
                tipSpeise.add(nextItem);
            } else {
                break;
            }
        }
          dc.constructCombo(numberOfCombos,tipSpeise);
    }

    private static void printCombo() {

        System.out.println("Текущее состояние списка предложений:");
        for (String mapKey : dc.menuMap.keySet()) {
            System.out.println("Категория: " + mapKey + "  Бдюдо: " + dc.menuMap.get(mapKey));
        }
    }

}