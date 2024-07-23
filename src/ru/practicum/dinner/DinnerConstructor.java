package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap <String, ArrayList<String>> menuMap = new HashMap<>();

    void constructCombo(int countCombi, ArrayList<String> comboDiesh) {
        Random random = new Random();
        ArrayList<String> menu = new ArrayList<>();
        for (int i = 0; i < countCombi; i++) {
            System.out.println("Комбинация: " + (i + 1));

            for (String dishType : comboDiesh) {
                ArrayList<String>  combo = menuMap.get(dishType);
                String randomMenu = combo.get(random.nextInt(combo.size()));
                menu.add(randomMenu);
            }
            System.out.println(menu);
            menu.clear();
        }
    }
}
