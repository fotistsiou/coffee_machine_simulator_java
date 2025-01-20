package step_6;

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
}
