package step_2;

import java.util.Scanner;

/**
 * Calculate the ingredients
 * -------------------------
 * Description
 * Now let's consider a scenario where you need a lot of coffee—perhaps you're hosting a party with many guests! In such
 * cases, it's better to make preparations in advance.
 * In this stage, you will ask the user to enter the desired number of coffee cups. Based on this input, you will calculate
 * the necessary amounts of water, coffee, and milk needed to prepare the specified quantity of coffee.
 * Please note that the coffee machine won't actually make any coffee in this stage; instead, it will simply compute the
 * required ingredients.
 * -------------------------
 * Objectives
 * Let's break down the task into several steps:
 * 1. Read the number of coffee cups from the input.
 * 2. Calculate the amount of each ingredient needed. One cup of coffee requires:
 *    - 200 ml of water
 *    - 50 ml of milk
 *    - 15 g of coffee beans
 * 3.Output the required ingredient amounts back to the user.
 * -------------------------
 * Note: As you work through each stage of the project, please ensure to remove any code from previous stages that is no
 * longer needed. This includes printout messages from earlier steps, as they may not be relevant to the current
 * implementation. Keeping your code clean and focused on the specific objectives of each stage will enhance clarity and
 * improve the overall structure of your project.
 */

public class Main {
    public static int waterPerCup = 200, milkPerCup = 50, beansPerCup = 15;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();
        int totalWater = cups * Main.waterPerCup;
        int totalMilk = cups * Main.milkPerCup;
        int totalBeans = cups * Main.beansPerCup;
        System.out.printf("For %d cups of coffee you will need:%n", cups);
        System.out.printf("%d ml of water%n", totalWater);
        System.out.printf("%d ml of milk%n", totalMilk);
        System.out.printf("%d g of coffee beans%n", totalBeans);
        scanner.close();
    }
}
