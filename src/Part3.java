import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Part3 {
    // Arrays to store task details
    private static ArrayList<String> developers = new ArrayList<>();
    private static ArrayList<String> taskNames = new ArrayList<>();
    private static ArrayList<String> taskIDs = new ArrayList<>();
    private static ArrayList<Integer> taskDurations = new ArrayList<>();
    private static ArrayList<String> taskStatuses = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            // Buttons that allow user to add tasks, show a report or leave the application
            String[] options = {"Add Tasks", "Show Report", "Quit"};
            int mainChoice = JOptionPane.showOptionDialog(null, "Welcome to EasyKanban! Choose an option:", "Login Feature", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (mainChoice) {
                case 0:
                    addTask();
                    break;
                case 1:
                    showReport();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "See you Later.");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        }
    }

    private static void addTask() {
        // Get task details from user
        int numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you wish to enter?"));
        int totalHours = 0;
        for (int i = 0; i < numberOfTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter Task name:");
            String taskDescription = JOptionPane.showInputDialog("Enter description (less than 50 characters):");
            if (!isTaskDescriptionValid(taskDescription)) {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
                i--;
                continue;
            }
            String developerDetails = JOptionPane.showInputDialog("Enter Developer details:");
            String taskDurationString = JOptionPane.showInputDialog("Enter Task Duration in hours:");

            // Checking if what the user inserted is a valid number
            int taskDuration;
            try {
                taskDuration = Integer.parseInt(taskDurationString);
                if (taskDuration < 0) {
                    throw new IllegalArgumentException("Task duration cannot be negative or 0.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid duration. Please enter the number of hours the task will take.");
                return;
            }

            // Creating options of buttons that can be press to determine which of the three strings it is.
            String[] buttons = {"To Do", "Done", "Doing"};
            int choice = JOptionPane.showOptionDialog(null, "What is the status of your task?", "Task Status", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, buttons, buttons[0]);
            String taskStatus = buttons[choice];
            String createTaskId = taskName.substring(0, Math.min(taskName.length(), 2)).toUpperCase() + ":" + numberOfTasks + ":" + developerDetails.substring(Math.max(developerDetails.length() - 3, 0)).toUpperCase();
            String printTaskDetails = "Task Status: " + taskStatus + "\n" + "Developers Details: " + developerDetails + "\n" + "Task Number: " + (i + 1) + "\n" + "Task Name: " + taskName + "\n" + "Task Description: " + taskDescription + "\n" + "Task ID: " + createTaskId + "\n" + "Task Duration: " + taskDuration;
            JOptionPane.showMessageDialog(null, printTaskDetails);

            // Add task details to arrays
            developers.add(developerDetails);
            taskNames.add(taskName);
            taskIDs.add(createTaskId);
            taskDurations.add(taskDuration);
            taskStatuses.add(taskStatus);

            totalHours += taskDuration;

            // Display message when done
            JOptionPane.showMessageDialog(null, "Task successfully added!");
        }
        // Displaying the total amount of hours
        JOptionPane.showMessageDialog(null, "Total amount of hours for all tasks: " + totalHours);
    }

    // Checking if the task description that was entered was lower than 50
    private static boolean isTaskDescriptionValid(String taskDescription) {
        return taskDescription.length() <= 50;
    }
    // options to choose what to do with the task reports
    private static void showReport() {
        String[] reportOptions = {"Tasks with Status 'Done'", "Longest Duration Task", "Search by Task Name", "Search by Developer", "Delete Task", "Display All Tasks"};
        int reportChoice = JOptionPane.showOptionDialog(null, "Choose a report option:", "Report Feature", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, reportOptions, reportOptions[0]);

        switch (reportChoice) {
            case 0:
                showTasksWithStatusDone();
                break;
            case 1:
                showLongestDurationTask();
                break;
            case 2:
                searchTaskByName();
                break;
            case 3:
                searchTasksByDeveloper();
                break;
            case 4:
                deleteTaskByName();
                break;
            case 5:
                displayAllTasks();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
        }
    }

    private static void showTasksWithStatusDone() {
        StringBuilder result = new StringBuilder("Tasks with Status 'Done':\n");
        for (int i = 0; i < taskStatuses.size(); i++) {
            if ("Done".equals(taskStatuses.get(i))) {
                result.append("Developer: ").append(developers.get(i))
                        .append(", Task Name: ").append(taskNames.get(i))
                        .append(", Task Duration: ").append(taskDurations.get(i))
                        .append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }

    private static void showLongestDurationTask() {
        if (taskDurations.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }
        int maxDurationIndex = 0;
        for (int i = 1; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > taskDurations.get(maxDurationIndex)) {
                maxDurationIndex = i;
            }
        }
        String result = "Task with Longest Duration:\n" +
                "Developer: " + developers.get(maxDurationIndex) +
                ", Task Name: " + taskNames.get(maxDurationIndex) +
                ", Task Duration: " + taskDurations.get(maxDurationIndex);
        JOptionPane.showMessageDialog(null, result);
    }

    private static void searchTaskByName() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name to search:");
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                String result = "Task Details:\n" +
                        "Task Name: " + taskNames.get(i) +
                        ", Developer: " + developers.get(i) +
                        ", Task Status: " + taskStatuses.get(i);
                JOptionPane.showMessageDialog(null, result);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found.");
    }

    private static void searchTasksByDeveloper() {
        String developerName = JOptionPane.showInputDialog("Enter Developer Name to search:");
        StringBuilder result = new StringBuilder("Tasks for Developer " + developerName + ":\n");
        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i).equalsIgnoreCase(developerName)) {
                result.append("Task Name: ").append(taskNames.get(i))
                        .append(", Task Status: ").append(taskStatuses.get(i))
                        .append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }

    private static void deleteTaskByName() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name to delete:");
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                developers.remove(i);
                taskNames.remove(i);
                taskIDs.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);
                JOptionPane.showMessageDialog(null, "Task deleted successfully.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found.");
    }

    private static void displayAllTasks() {
        StringBuilder result = new StringBuilder("All Captured Tasks:\n");
        for (int i = 0; i < taskNames.size(); i++) {
            result.append("Task ID: ").append(taskIDs.get(i))
                    .append(", Task Name: ").append(taskNames.get(i))
                    .append(", Developer: ").append(developers.get(i))
                    .append(", Task Duration: ").append(taskDurations.get(i))
                    .append(", Task Status: ").append(taskStatuses.get(i))
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }
}