import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Question_7_Write_Operating_System_Info_To_File_In_Data_Directory {
    public static void main(String[] args) {
        writeOSName();
    }
    
    public static void writeOSName() {
        try {
            String osName = System.getProperty("os.name");
            File file = new File("data", "os.txt");
            FileWriter fw = new FileWriter(file);
            fw.write(osName);
            fw.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
       
}
