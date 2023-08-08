import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MessageProcessor {
    public static void main(String[] args) {
        int maxSize = 250;
        Queue messageQueue = new Queue(maxSize);
        Stack messageStack = new Stack(maxSize);
        List<String> sentMessages = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Input message");
            System.out.println("2. Send message");
            System.out.println("3. Received message / View message");
            System.out.println("4. View all sent messages");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        scanner.nextLine();
                        System.out.print("Enter the message (less than 250 characters): ");
                        String sentMessage = scanner.nextLine();
                        for (char c : sentMessage.toCharArray()) {
                            messageQueue.enqueue(c);
                        }
                        break;
                    case 2:
                        StringBuilder sentMessageBuilder = new StringBuilder();
                        while (!messageQueue.isEmpty()) {
                            char message = messageQueue.dequeue();
                            messageStack.push(message);
                            sentMessageBuilder.append(message);
                        }
                        sentMessages.add(sentMessageBuilder.toString());
                        System.out.println("Message sent!");
                        break;
                    case 3:
                        if (!sentMessages.isEmpty()) {
                            System.out.println("Received message / View message: " + sentMessages.get(sentMessages.size() - 1));
                        } else {
                            System.out.println("You haven't sent any message yet.");
                        }
                        break;

                    case 4:
                        if (!sentMessages.isEmpty()) {
                            System.out.println("All sent messages:");
                            for (String message : sentMessages) {
                                System.out.println(message);
                            }
                        } else {
                            System.out.println("You haven't sent any message yet.");
                        }
                        break;
                    case 5:
                        System.out.println("Exiting the program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again!");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } while (choice != 5);
    }
}
