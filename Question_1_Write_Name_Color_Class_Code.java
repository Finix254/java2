
/**

A program that writes out the user's name, favorite color, and class code to a new file with one item per line using buffered classes.
It then reads in all the data, line by line, and displays it.
*/
import java.io.*;

public class Question_1_Write_Name_Color_Class_Code {
public static void main(String[] args) {
    new Question_1_Write_Name_Color_Class_Code().fileIO();
}

public void fileIO() {

    String filename = "data.txt";

    String name = "John Doe";
    String favoriteColor = "Blue";
    int classCode = 2545;

    writeToFile(filename, name, favoriteColor, classCode);

    printDataFromFile(filename);

}


public void writeToFile(String filename, String name, String favoriteColor, int classCode) {
  // TODO write the three pieces of information to the file given by filename.
        // TODO Add try-catch blocks to this method. This method should NOT declare that it
        //  throws IOException or any other exceptions.
        
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

        writer.write(name);
        writer.newLine();
        writer.write(favoriteColor);
        writer.newLine();
        writer.write(String.valueOf(classCode));
        writer.newLine();

    } catch (IOException e) {
        System.out.println("An error occurred while writing to file: " + e.getMessage());
    }

}


public void printDataFromFile(String filename) {
// TODO read in the data from the file, and print it.
        // TODO Add try-catch blocks to this method.
        //  This method should NOT declare that it throws IOException or any other exceptions.
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

    } catch (IOException e) {
        System.out.println("An error occurred while reading from file: " + e.getMessage());
    }

}
}