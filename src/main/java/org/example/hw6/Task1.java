package org.example.hw6;

import java.util.HashMap;
import java.util.Random;

/*
В качестве задачи предлагаю вам реализовать код для
демонстрации парадокса Монти Холла (Парадокс Монти Холла
— Википедия ) и наглядно убедиться в верности парадокса
(запустить игру в цикле на 1000 и вывести итоговый счет).
Необходимо:
● Создать свой Java Maven или Gradle проект;
● Самостоятельно реализовать прикладную задачу;
● Сохранить результат в HashMap<шаг теста, результат>
● Вывести на экран статистику по победам и поражениям
 */
public class Task1 {
    public static void main(String[] args) {
        int trials = 1000;
        HashMap<Integer, String> results = new HashMap<>();
        int winsSwitch = 0; // учет побед (при смене первоначального выбора)
        int winsStay = 0; // учет побед (выбор не меняется)
        for (int i = 1; i <= trials; i++) {
            String resultStay = playGame(false);
            String resultSwitch = playGame(true);

            if (resultStay.equals("win")) {
                winsStay++;
            }
            if (resultSwitch.equals("win")) {
                winsSwitch++;
            }

            results.put(i, "Stay: " + resultStay + ", Switch: " + resultSwitch);
        }
        System.out.println("Results of the Monty Hall game:");
        for (int i = 1; i <= trials; i++) {
            System.out.println("Attemp " + i + ": " + results.get(i));
        }
        System.out.println("\nStatistics:");
        System.out.println("Wins by staying: " + winsStay);
        System.out.println("Wins by switching: " + winsSwitch);
        System.out.println("Total attemps: " + trials);
        System.out.println("Total wins: " + (winsStay + winsSwitch));
    }

    /**
     * Метод реализует логику одной игры, где определяется, выиграл ли игрок, в зависимости от того,
     * остался ли он при своем первоначальном выборе или сменил его.
     * @param switchChoice определяет, произошла ли смена первоначального выбора
     * @return
     */
    private static String playGame(boolean switchChoice) {
        Random random = new Random();

        // 1. Случайно размещаем машину и козы
        int carDoor = random.nextInt(3); // размещаем машину
        int playerChoice = random.nextInt(3); // игрок выбирает дверь
        // 2. Монти открывает одну из оставшихся дверей
        int montyOpens;
        do {
            montyOpens = random.nextInt(3);
        } while (montyOpens == carDoor || montyOpens == playerChoice); // исключаем дверь, выбранную игроком и дверь с машиной

        // 3. игрок решает: остаться или сменить выбор
        if (switchChoice) {
            // игрок меняет выбор
            playerChoice = 3 - playerChoice - montyOpens; // Смена выбора
        }
        // 4. проверяем, выиграл ли игрок
        if (playerChoice == carDoor) return "win";
        return "lose";
    }
}
