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
                default:
                    System.out.println("Такой номер команды не существует. ");
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
        }
    }


    private static void printCombo() {

        System.out.println("Текущее состояние списка предложений:");
        if (dc.menuMap.isEmpty()) {
            System.out.println("пока список пуст.");
        } else {
            for (String mapKey : dc.menuMap.keySet()) {
                System.out.println("Категория: " + mapKey + "  Бдюдо: " + dc.menuMap.get(mapKey));
            }
        }
    }

    private static void generateDishCombo() {
        if (dc.menuMap.isEmpty()) {
            System.out.println("Составьте пожалуйста список предложений.");
        } else {
            System.out.println("Начинаем конструировать обед...");
            System.out.println("Введите количество наборов, которые нужно сгенерировать:");
            int numberOfCombos = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");

            ArrayList<String> tipSpeise = new ArrayList<>();
            boolean isInMenuTip = false;
            while (true) {
                String nextItem = scanner.nextLine();
                if (!nextItem.isEmpty()) {
                    isInMenuTip = dc.menuMap.containsKey(nextItem);
                    if (isInMenuTip) {
                        tipSpeise.add(nextItem);
                    } else {
                        System.out.println("Вы ввели:" + nextItem + "и такой категории нет. \n Введите существующею категорию (см. п. 3)");
                    }
                } else {
                    if (tipSpeise.isEmpty()) {
                        return;
                    }
                    break;
                }
            }
            dc.constructCombo(numberOfCombos, tipSpeise);
        }
    }
}
// todo зависает( после запроса количества комбинаций и при вводе символов выкидывает в главное меню) ,почему не понимаю

    /*private static void generateDishCombo() {

        if (dc.menuMap.isEmpty()) {
            System.out.println("Составьте пожалуйста список предложений.");
        } else {
            System.out.println("Начинаем конструировать обед...");

            int numberOfCombos = 0;
            while (true) {
                System.out.println("Введите количество наборов, которые нужно сгенерировать:");
                try {
                    numberOfCombos = scanner.nextInt();
                    if (numberOfCombos > 0) {
                        break;
                    } else {
                        System.out.println("Значение должно быть больше нуля!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Пожалуйста, введите целое число!");
                    scanner.next();
                }
            }
            scanner.next();

            System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");

            ArrayList<String> tipSpeise = new ArrayList<>();
            boolean isInMenuTip = false;
            while (true) {
                String nextItem = scanner.nextLine();
                if (!nextItem.isEmpty()) {
                    isInMenuTip = dc.menuMap.containsKey(nextItem);
                    if (isInMenuTip) {
                        tipSpeise.add(nextItem);
                    } else {
                        System.out.println("Вы ввели:" + nextItem + "и такой категории нет. \n Введите существующею категорию (см. п. 3)");
                    }
                } else {
                    if (tipSpeise.isEmpty()) {
                        return;
                    }
                    break;
                }
            }
            dc.constructCombo(numberOfCombos, tipSpeise);
        }
    }*/