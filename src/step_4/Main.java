package step_4;

import java.util.Scanner;

/**
 * Add functions to your machine
 * -----------------------------
 * Description
 * Now, let's simulate an actual coffee machine! This coffee machine will have a limited supply of water, milk, coffee
 * beans, and disposable cups. Additionally, it will track how much money it earns from selling coffee.
 * The coffee machine will have three main functions:
 * 1. It can sell different types of coffee: espresso, latte, and cappuccino. Of course, each variety would require a
 * different amount of supplies, however, in any case, would need only one disposable cup for a drink.
 * 2. A special worker should be able to replenish the machine's supplies.
 * 3. Another special worker should be able to collect the money earned by the machine.
 * -----------------------------
 * Objectives
 * Write a program that offers three actions: buying coffee, refilling supplies, or taking its money out. Note that the
 * program is supposed to perform only one of the mentioned actions at a time for each input. It should update the coffee
 * machine's state accordingly i.e. calculate the amounts of remaining ingredients and the total money collected; and
 * display them before and after each action.
 * 1. First, your program reads one option from the standard input, which can be "buy", "fill", "take". If a user wants
 * to buy some coffee, the input is "buy". If a special worker thinks that it is time to fill out all the supplies for
 * the coffee machine, the input line will be "fill". If another special worker decides that it is time to take out the
 * money from the coffee machine, you'll get the input "take".
 * 2.If the user writes "buy" then they must choose one of three types of coffee that the coffee machine can make:
 * espresso, latte, or cappuccino.
 *   - For a cup of espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
 *   - For a latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
 *   - And for a cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.
 * 3. If the user writes "fill", the program should ask them how much water, milk, coffee beans, and how many disposable
 * cups they want to add into the coffee machine.
 * 4. If the user writes "take" the program should give all the money that it earned from selling coffee.
 * In summary, your program should display the coffee machine's current state, process one user action, and then display
 * the updated state. Aim to implement each action using separate functions.
 * -----------------------------
 * Note:
 * 1. When the user writes "buy", they will be prompted to choose a coffee type by entering a number: 1 for espresso, 2
 * for latte, 3 for cappuccino.
 * 2. Initially, the coffee machine has $550, 400 ml of water, 540 ml of milk, 120 g of coffee beans, and 9 disposable cups.
 */

public class Main {
    static final int waterEspresso = 250, beansEspresso = 16, costEspresso = 4;
    static final int waterLatte = 350, milkLatte = 75, beansLatte = 20, costLatte = 7;
    static final int waterCappuccino = 200, milkCappuccino = 100, beansCappuccino = 12, costCappuccino = 6;
    static int waterStock = 400, milkStock = 540, beansStock = 120, cupsStock = 9, money = 550;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main.printStock();
        System.out.println("Write action (buy, fill, take):");
        switch (scanner.nextLine()) {
            case "buy" -> Main.buy();
            case "fill" -> Main.fill();
            case "take" -> Main.take();
        }
        Main.printStock();
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
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int choice = scanner.nextInt();
        int waterRemove = 0, milkRemove = 0, beansRemove = 0, addMoney = 0;
        switch (choice) {
            case 1 -> {
                waterRemove = waterEspresso;
                beansRemove = beansEspresso;
                addMoney += costEspresso;
            }
            case 2 -> {
                waterRemove = waterLatte;
                milkRemove = milkLatte;
                beansRemove = beansLatte;
                addMoney += costLatte;
            }
            case 3 -> {
                waterRemove = waterCappuccino;
                milkRemove = milkCappuccino;
                beansRemove = beansCappuccino;
                addMoney += costCappuccino;
            }
        }
        Main.waterStock -= waterRemove;
        Main.milkStock -= milkRemove;
        Main.beansStock -= beansRemove;
        Main.cupsStock--;
        Main.money += addMoney;
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
