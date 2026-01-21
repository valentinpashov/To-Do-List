import java.util.ArrayList;
import java.util.Scanner;

public class ToDoApp {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTO-DO LIST:");
            System.out.println("1. Add new task");
            System.out.println("2. All tasks");
            System.out.println("3. Mark READY");
            System.out.println("4. Exit");
            System.out.print("Choice operation's number: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Чистим буфера

            if (choice == 1) {
                System.out.print("Task: ");
                String text = scanner.nextLine();
                tasks.add(new Task(text));
            } else if (choice == 2) {
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }
            } else if (choice == 3) {
                System.out.print("Task's number : ");
                int index = scanner.nextInt();
                if (index > 0 && index <= tasks.size()) {
                    tasks.get(index - 1).markAsCompleted();
                }
            } else if (choice == 4) {
                break;
            }
        }
    }
}