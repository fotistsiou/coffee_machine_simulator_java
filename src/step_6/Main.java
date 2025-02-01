package step_6;

import java.util.Scanner;

/**
 * Brush up your code
 * ------------------
 * Description
 * In this stage, let's improve the design of our program by organizing it into classes that represent different parts
 * of the coffee machine. For instance, we can create one class for the coffee machine itself and another class to
 * represent each type of coffee with its ingredients and cost. This approach helps structure the code better, allowing
 * for easier reuse and extension. Each class should have methods that handle specific tasks, working together to process
 * the user input and manage the coffee machine's operations.
 * Your program should handle the user's input through methods in these classes. Every time the user inputs something,
 * it will be processed by these methods to update the state of the machine. This setup simulates how real-world machines
 * operate, where each part has a defined role.
 * As the coffee machine operates, it will keep track of its resources, including water, milk, coffee beans, disposable
 * cups, and the cash collected. Each action taken by the user should be processed in the context of the machine's current
 * state, which reflects the available resources.
 * Additionally, we'll introduce a new action: cleaning. The coffee machine will monitor how many coffees have been made.
 * After producing 10 cups, it will require cleaning. During this action, the machine will not be able to make any more
 * coffee until it is cleaned by the user typing "clean". After cleaning, the machine resumes its normal operations.
 * Remember, that:
 * - For a cup of espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
 * - For a latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
 * - And for a cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.
 * ------------------
 * Objective
 * Your final task is to refactor the program to ensure you can interact with the coffee machine through methods in the
 * classes you created. Implement the cleaning action, where the machine requires cleaning after 10 cups of coffee are
 * made. Once cleaned, the machine can make coffee again.
 * ------------------
 * Note: Your coffee machine should start with the same initial resources: 400 ml of water, 540 ml of milk, 120 g of
 * coffee beans, 9 disposable cups, $550 in cash.
 */

public class Main {
    static int prodCups = 0;
    static Scanner scanner = new Scanner(System.in);
    static CoffeeStock coffeeStock = new CoffeeStock(400, 540, 120, 9, 550);

    public static void main(String[] args) {
        boolean theEnd = false;
        while (!theEnd) {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
            switch (scanner.nextLine()) {
                case "buy" -> Main.buy();
                case "fill" -> Main.fill();
                case "take" -> Main.take();
                case "remaining" -> Main.printStock();
                case "clean" -> Main.clean();
                case "exit" -> theEnd = true;
            }
        }
        scanner.close();
    }

    static void printStock() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water%n", Main.coffeeStock.getWater());
        System.out.printf("%d ml of milk%n", Main.coffeeStock.getMilk());
        System.out.printf("%d g of coffee beans%n", Main.coffeeStock.getBeans());
        System.out.printf("%d disposable cups%n", Main.coffeeStock.getCups());
        System.out.printf("$%d of money%n", Main.coffeeStock.getMoney());
    }

    static void buy() {
        if (Main.prodCups >= 10) {
            System.out.println("I need cleaning!");
            return;
        }
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = scanner.nextLine();
        int waterRemove = 0, milkRemove = 0, beansRemove = 0, moneyAdd = 0;
        int stockWater = Main.coffeeStock.getWater(), stockMilk = Main.coffeeStock.getMilk(), stockBeans = Main.coffeeStock.getBeans(), stockCups = Main.coffeeStock.getCups(), stockMoney = Main.coffeeStock.getMoney();
        switch (choice) {
            case "1" -> {
                CoffeeEspresso coffee = new CoffeeEspresso();
                waterRemove = coffee.getWater();
                beansRemove = coffee.getBeans();
                moneyAdd = coffee.getCost();
                Main.prodCups++;
            }
            case "2" -> {
                CoffeeLatte coffee = new CoffeeLatte();
                waterRemove = coffee.getWater();
                milkRemove = coffee.getMilk();
                beansRemove = coffee.getBeans();
                moneyAdd = coffee.getCost();
                Main.prodCups++;
            }
            case "3" -> {
                CoffeeCappuccino coffee = new CoffeeCappuccino();
                waterRemove = coffee.getWater();
                milkRemove = coffee.getMilk();
                beansRemove = coffee.getBeans();
                moneyAdd = coffee.getCost();
                Main.prodCups++;
            }
            case "back" -> {
                return;
            }
        }
        if (stockWater < waterRemove) {
            System.out.println("Sorry, not enough water!");
            return;
        } else {
            Main.coffeeStock.setWater(stockWater - waterRemove);
        }
        if (stockMilk < milkRemove) {
            System.out.println("Sorry, not enough milk!");
            return;
        } else {
            Main.coffeeStock.setMilk(stockMilk - milkRemove);
        }
        if (stockBeans < beansRemove) {
            System.out.println("Sorry, not enough beans!");
            return;
        } else {
            Main.coffeeStock.setBeans(stockBeans - beansRemove);
        }
        if (stockCups <= 0) {
            System.out.println("Sorry, not enough cups!");
            return;
        } else {
            Main.coffeeStock.setCups(stockCups - 1);
        }
        Main.coffeeStock.setMoney(Main.coffeeStock.getMoney() + moneyAdd);
        System.out.println("I have enough resources, making you a coffee!");
    }

    static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        Main.coffeeStock.setWater(scanner.nextInt() + Main.coffeeStock.getWater());
        System.out.println("Write how many ml of milk you want to add:");
        Main.coffeeStock.setMilk(scanner.nextInt() + Main.coffeeStock.getMilk());
        System.out.println("Write how many grams of coffee beans you want to add:");
        Main.coffeeStock.setBeans(scanner.nextInt() + Main.coffeeStock.getBeans());
        System.out.println("Write how many disposable cups you want to add:");
        Main.coffeeStock.setCups(scanner.nextInt() + Main.coffeeStock.getCups());
        scanner.nextLine();
    }

    static void take() {
        System.out.printf("I gave you $%d", Main.coffeeStock.getMoney());
        Main.coffeeStock.setMoney(0);
    }

    static void clean() {
        Main.prodCups = 0;
        System.out.println("I have been cleaned!");
    }
}
