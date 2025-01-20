package step_5;

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
}
