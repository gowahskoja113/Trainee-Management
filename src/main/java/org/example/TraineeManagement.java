package org.example;

import java.util.Scanner;

import static org.example.TraineeForm.indexOfId;

public class TraineeManagement {
    private TraineeForm traineeForm;
    private Scanner scanner;
    public static Trainee[] listOfTrainees = new Trainee[100];
    public static byte count = 0;
    private static final String ADD = "1";
    private static final String SHOW = "2";
    private static final String FINDBYID = "3";
    private static final String FINDBYNAME = "4";
    private static final String UPDATE = "5";
    private static final String EXIT = "6";

    public TraineeManagement(){
        this.scanner = new Scanner(System.in);
        this.traineeForm = new TraineeForm(scanner);
    }

    private void updateTrainee() {
        String id = traineeForm.inputString("Enter ID of the trainee to update: ");
        int index = indexOfId(id);
        if (index == -1) {
            System.out.println("Can not find this id");
        } else {
            Trainee newTrainees = listOfTrainees[index];
            //update name
            System.out.println("Old name: " + newTrainees.getName());
            String newName = traineeForm.inputString("Enter new name: ");
            newTrainees.setName(newName);
            //update gender
            System.out.println("Old gender: " + newTrainees.getGender());
            String newGender = traineeForm.inputGender();
            newTrainees.setGender(newGender);
            //update age
            System.out.println("Old age: " +newTrainees.getAge());
            byte newAge = traineeForm.inputAge("Enter new age: ");
            newTrainees.setAge(newAge);
        }
    }

    private void findByName() {
        String name = traineeForm.inputString("Enter name to find: ").trim();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            Trainee trainee = listOfTrainees[i];
            if (trainee != null && !TraineeForm.isNullOrEmpty(trainee.getName()) && trainee.getName().trim().equalsIgnoreCase(name)) {
                found = true;
                System.out.println(trainee);
            }
        }
        if (!found) {
            System.out.println("No trainee found with name: " + name);
        }
    }

    private void findById() {
        String id = traineeForm.inputString("Enter ID to find: ");
        int index = indexOfId(id);
        if (index != -1) {
            System.out.println("Trainee found: " + listOfTrainees[index]);
        } else {
            System.out.println("Trainee with ID " + id + " not found.");
        }
    }

    private void showAllTrainees() {
        if (count == 0){
            System.out.println("The list is empty!");
            return;
        }else{
            System.out.println("ID       | Name                 | Gender | Age");
            System.out.println("----------------------------------------------");
            for (int i = 0; i < count; i++) {
            System.out.println(listOfTrainees[i]);
            }
        }
    }

    private void addTrainee() {
        Trainee trainee = traineeForm.getTrainee();
        if (count > listOfTrainees.length - 1) {
            System.out.println("Cannot add more trainees, list is full.");
        } else {
            listOfTrainees[count] = trainee;
            count++;
            System.out.println("Trainee added successfully.");
        }
    }

    private void runMenu(){
        while (true) {
            System.out.println("1. Add Trainee");
            System.out.println("2. Show All Trainees");
            System.out.println("3. Find Trainee by ID");
            System.out.println("4. Find Trainee by Name");
            System.out.println("5. Update Trainee");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            String choice = traineeForm.inputString("Enter your choice: ");

            switch (choice) {
                case ADD:
                    addTrainee();
                    break;
                case SHOW:
                    showAllTrainees();
                    break;
                case FINDBYID:
                    findById();
                    break;
                case FINDBYNAME:
                    findByName();
                    break;
                case UPDATE:
                    updateTrainee();
                    break;
                case EXIT:
                    System.out.println("Exit the program.");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static void main(String[] args) {
        new TraineeManagement().runMenu();
    }
}
