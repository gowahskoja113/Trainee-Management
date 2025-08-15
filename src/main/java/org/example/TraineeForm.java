package org.example;

import java.util.Scanner;

import static org.example.TraineeManagement.count;
import static org.example.TraineeManagement.listOfTrainees;

public class TraineeForm {
    private final Scanner scanner;

    public static boolean isNullOrEmpty(String str) {
        if (str == null || str.trim().isEmpty()) {
            System.out.println("Input cannot be null or empty. Please try again.");
            return true;
        }
        return false;
    }

    public boolean checkDupplicateId(String id) {
        if (id == null || id.trim().isEmpty()){
            return false;
        }else {
            for (int i = 0; i < count; i++) {
                if (listOfTrainees[i] != null && id.equals(listOfTrainees[i].getId())) {
                    System.out.println("ID already exists. Please enter a different ID.");
                    return true;
                }
            }
            return false;
        }
    }

    public static int indexOfId(String id) {
        for (int i = 0; i < count; i++) {
            if (listOfTrainees[i] != null && id.equals(listOfTrainees[i].getId())) {
                return i;
            }
        }
        return -1;
    }

    public static String indexOfName(String name) {
        if (isNullOrEmpty(name)) {
            return null;
        }else{
            String index = name.trim();
            for (int i = 0 ; i < count; i++){
                Trainee trainee = listOfTrainees[i];
                if (trainee != null && !isNullOrEmpty(trainee.getName()) && index.equalsIgnoreCase(trainee.getName().trim())) {
                    return trainee.getId();
                }
            }
        }
        return null;
    }


    public String inputString(String msg){
        while (true) {
            System.out.println(msg);
            String input = scanner.nextLine().trim();
            if (!isNullOrEmpty(input)) {
                return input;
            } else {
                System.out.println("Input cannot be null or empty. Please try again.");
            }
        }
    }

    public String inputId(String message) {
        while (true){
            System.out.println(message);
            String input = scanner.nextLine().trim();
            if (!isNullOrEmpty(input)) {
                if (!checkDupplicateId(input)) return input;
            }
        }
     }

    public String inputGender() {
        while (true) {
            String gender = inputString("Enter 'male' or 'female': ");
            if (!isNullOrEmpty(gender) && gender.trim().toLowerCase().equals("male") || gender.trim().toLowerCase().equals("female")){
                return gender;
            }else {
                System.out.println("Can not be null or empty and must be either");
            }
        }
    }

    public byte inputAge(String msg) {
        System.out.println(msg);
        while (true) {
            try {
                byte a = Byte.parseByte(scanner.nextLine().trim());
                if (a < 6){
                    System.out.println("Age must be greater than 6. Please try again.");
                } else {
                    return a;
                }
            }catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter again a number.");
            }
        }
    }

    public TraineeForm(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getId(){
        while (true) {
            String id = inputId("Enter ID: ");
            if (!isNullOrEmpty(id)) {
                return id;
            } else {
                System.out.println("ID cannot be null or empty. Please try again.");
            }
        }
    }

    public Trainee getTrainee(){
        Trainee trainee = new Trainee();

        String id = getId();
        trainee.setId(id);
        String name = inputString("Enter Name: ");
        trainee.setName(name);
        String gender = inputGender();
        trainee.setGender(gender);
        byte age = inputAge("Enter Age (must be greater than 6): ");
        trainee.setAge(age);

        return trainee;
    }
}
