import javax.swing.*;

public class Part2 {

    public static void main(String[] args) {
        while (true) {
            // Buttons that allow user add tasks, show a report or leave the application
            String[] options = {"Add Tasks", "Show Report", "Quit"};
            int mainChoice = JOptionPane.showOptionDialog(null, "Welcome to EasyKanban! Choose an option:", "Login Feature", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (mainChoice) {
                case 0:
                    addTask();
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Coming soon...");
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
        int[] tasks;
        tasks = new int[]{(numberOfTasks)};
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
            String printTaskDetails = "Task Status: " + taskStatus + "\n" + "Developers Details: " + developerDetails + "\n" + "Task Number: " + (i+1) + "\n" + "Task Name: "+ taskName + "\n" + "Task Description: " + taskDescription + "\n" + "Task ID: " + createTaskId + "\n" + "Task Duration: " + taskDuration;
            JOptionPane.showMessageDialog(null, printTaskDetails);
            totalHours += taskDuration;


            // Display message when done
            JOptionPane.showMessageDialog(null, "Task successfully added!");
        }
        //Displaying the total amount of hours
        JOptionPane.showMessageDialog(null,"Total amount of hours for all task:"+ totalHours);
    }
//checking if the task description that was entered was lower than 50
    private static boolean isTaskDescriptionValid(String taskDescription) {
        return taskDescription.length() <= 50;
    }
    //Adding the number of hours of all tasks entered
        private static int returnTotalHours(int[] tasks) {
            int totalHours = 0;
            for (int hours : tasks) {
                totalHours += hours;
            }
            return totalHours;
        }
    }



