package step_4;

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
}
