import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ToDoApp {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nTO-DO LIST:");
            System.out.println("1. Add new task");
            System.out.println("2. All tasks");
            System.out.println("3. Mark READY");
            System.out.println("4. Exit");
            System.out.print("Choice operation's number: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Task: ");
                        String text = scanner.nextLine();
                        tasks.add(new Task(text));
                        break;

                    case 2:
                        System.out.println(" Tasks List: ");
                        if (tasks.isEmpty()) {
                            System.out.println("List is empty.");
                        } else {
                            for (int i = 0; i < tasks.size(); i++) {
                                System.out.println((i + 1) + ". " + tasks.get(i));
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Number to mark ready: ");
                        int index = scanner.nextInt();
                        scanner.nextLine();

                        if (index > 0 && index <= tasks.size()) {
                            tasks.get(index - 1).markAsCompleted();
                            System.out.println("Done! Task marked as completed.");
                        } else {
                            System.out.println("Invalid number!");
                        }
                        break;

                    case 4:
                        System.out.println("Exiting... Goodbye!");
                        isRunning = false;
                        break;

                    default:
                        System.out.println("Please enter a valid number (1-4).");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println(" Error! Please enter only a number!");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}