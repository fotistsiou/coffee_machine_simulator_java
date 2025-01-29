package step_5;

import java.util.Scanner;

/**
 * Keep track of the supplies
 * --------------------------
 * Description
 * Handling only a single action at a time is quite limited, so let's improve the program to handle multiple actions,
 * one after another. The program should repeatedly ask a user what they want to do. If the user types "buy", "fill" or
 * "take", then the program should behave exactly as it did in the previous stage. But unlike the previous stage, where
 * the state of the coffee machine was displayed before and after each action ("buy", "fill" or "take"), the state of the
 * coffee machine should now be shown only when the user types "remaining". Additionally, if the user wants to switch off
 * the coffee machine, they should type "exit" to stop the program. In total, the program should now five actions: "buy",
 * "fill", "take", "remaining", and "exit".
 * Remember, that:
 * - For a cup of espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
 * - For a latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
 * - And for a cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.
 * --------------------------
 * Objectives
 * Write a program that continuously processes user actions until the "exit" command is given. Additionally, introduce
 * two new options:
 * - "remaining": to display the current state of the coffee machine
 * - "exit": to switch off the coffee machine
 * Remember, the coffee machine can run out of resources. If it doesn't have enough resources to make coffee, the program
 * should output a message that says it can't make a cup of coffee and indicate which resource is missing.
 * And the last improvement to the program in this stage — if the user types "buy" to buy a cup of coffee but then changes
 * their mind, they should be able to type "back" to return into the main menu.
 * --------------------------
 * Note:
 * 1. Your coffee machine should start with the same initial resources: 400 ml of water, 540 ml of milk, 120 g of coffee
 * beans, 9 disposable cups, $550 in cash.
 * 2. The program should loop indefinitely, processing actions until the user types "exit" to switch off the coffee
 * machine.
 */

public class Main {
    static final int waterEspresso = 250, beansEspresso = 16, costEspresso = 4;
    static final int waterLatte = 350, milkLatte = 75, beansLatte = 20, costLatte = 7;
    static final int waterCappuccino = 200, milkCappuccino = 100, beansCappuccino = 12, costCappuccino = 6;
    static int waterStock = 400, milkStock = 540, beansStock = 120, cupsStock = 9, money = 550;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean theEnd = false;
        while (!theEnd) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            switch (scanner.nextLine()) {
                case "buy" -> Main.buy();
                case "fill" -> Main.fill();
                case "take" -> Main.take();
                case "remaining" -> Main.printStock();
                case "exit" -> theEnd = true;
            }
        }
        scanner.close();
    }

    static void printStock() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water%n", Main.waterStock);
        System.out.printf("%d ml of milk%n", Main.milkStock);
        System.out.printf("%d g of coffee beans%n", Main.beansStock);
        System.out.printf("%d disposable cups%n", Main.cupsStock);
        System.out.printf("$%d of money%n", Main.money);
    }

    static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = scanner.nextLine();
        int waterRemove = 0, milkRemove = 0, beansRemove = 0, addMoney = 0;
        switch (choice) {
            case "1" -> {
                waterRemove = waterEspresso;
                beansRemove = beansEspresso;
                addMoney += costEspresso;
            }
            case "2" -> {
                waterRemove = waterLatte;
                milkRemove = milkLatte;
                beansRemove = beansLatte;
                addMoney += costLatte;
            }
            case "3" -> {
                waterRemove = waterCappuccino;
                milkRemove = milkCappuccino;
                beansRemove = beansCappuccino;
                addMoney += costCappuccino;
            }
            case "back" -> {
                return;
            }
        }
        if (Main.waterStock < waterRemove) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (Main.milkStock < milkRemove) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (Main.beansStock < beansRemove) {
            System.out.println("Sorry, not enough beans!");
            return;
        }
        if (Main.cupsStock <= 0) {
            System.out.println("Sorry, not enough cups!");
            return;
        }
        Main.waterStock -= waterRemove;
        Main.milkStock -= milkRemove;
        Main.beansStock -= beansRemove;
        Main.cupsStock--;
        Main.money += addMoney;
        System.out.println("I have enough resources, making you a coffee!");
    }

    static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        Main.waterStock += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        Main.milkStock += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        Main.beansStock += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        Main.cupsStock += scanner.nextInt();
    }

    static void take() {
        System.out.printf("I gave you $%d", Main.money);
        Main.money = 0;
    }
}
