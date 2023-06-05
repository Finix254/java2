import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Question_2_Write_Recycling_Report {
    public static void main(String[] args) {
        new Question_2_Write_Recycling_Report().recycling();
    }

    public void recycling() {
        int numberOfHouses = 8;
        int[] cratesPerHouse = getRecyclingPerHouse(numberOfHouses);
        int totalCrates = calculateTotal(cratesPerHouse);
        int maxCrates = calculateMax(cratesPerHouse);
        int minCrates = calculateMin(cratesPerHouse);
        int houseWithMostRecycling = calculateHouseWithMostRecycling(cratesPerHouse);

        System.out.println("Total crates from all houses = " + totalCrates);
        System.out.println("Max crates at any house = " + maxCrates);
        System.out.println("Min crates at any house = " + minCrates);
        System.out.println("House with most recycling = " + houseWithMostRecycling);

        String filename = "recycling_report.txt";
        writeReport(cratesPerHouse, totalCrates, filename);
    }

    public int[] getRecyclingPerHouse(int numberOfHouses) {
        Scanner scanner = new Scanner(System.in);
        int[] cratesPerHouse = new int[numberOfHouses];
        for (int i = 0; i < numberOfHouses; i++) {
            System.out.print("Enter the number of recycling crates for house " + i + ": ");
            cratesPerHouse[i] = scanner.nextInt();
        }
        return cratesPerHouse;
    }

    public int calculateTotal(int[] cratesPerHouse) {
        int total = 0;
        for (int i = 0; i < cratesPerHouse.length; i++) {
            total += cratesPerHouse[i];
        }
        return total;
    }

    public int calculateMax(int[] cratesPerHouse) {
        int max = cratesPerHouse[0];
        for (int i = 1; i < cratesPerHouse.length; i++) {
            if (cratesPerHouse[i] > max) {
                max = cratesPerHouse[i];
            }
        }
        return max;
    }

    public int calculateMin(int[] cratesPerHouse) {
        int min = cratesPerHouse[0];
        for (int i = 1; i < cratesPerHouse.length; i++) {
            if (cratesPerHouse[i] < min) {
                min = cratesPerHouse[i];
            }
        }
        return min;
    }

    public int calculateHouseWithMostRecycling(int[] cratesPerHouse) {
        int maxCrates = 0;
        int houseWithMostRecycling = 0;
        for (int i = 0; i < cratesPerHouse.length; i++) {
            if (cratesPerHouse[i] > maxCrates) {
                maxCrates = cratesPerHouse[i];
                houseWithMostRecycling = i;
            }
        }
        return houseWithMostRecycling;
    }

    public void writeReport(int[] cratesPerHouse, int totalCrates, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i < cratesPerHouse.length; i++) {
                String crateString = cratesPerHouse[i] == 1 ? "crate" : "crates";
                writer.println("House " + i + " recycled " + cratesPerHouse[i] + " " + crateString);
            }
            writer.println("Total crates recycled: " + totalCrates);
        } catch (IOException e) {
            System.out.println("Error writing to file " + filename);
        }
    }
}
    
