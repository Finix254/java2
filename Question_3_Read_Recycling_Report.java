import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Question_3_Read_Recycling_Report {
    public static void main(String[] args) {
        new Question_3_Read_Recycling_Report().recyclingReport();
    }
    
    public void recyclingReport(){
        // Read the file into your program
        String filename = "recycling-report-main-street.txt";
    
        List<String> lines = readLinesFromRecyclingDataFile(filename);
        
        if(lines != null) {
            List<Integer> crateQuantities = extractCrateQuantityData(lines);
            int max = calculateMax(crateQuantities);
            List<Integer> housesWithMax = copyIndexesToNewList(crateQuantities, max);
        
            System.out.println("The maximum number of crates is " + max);
            System.out.println("The houses with this max number of crates is " + housesWithMax);
        }
    }
    
    public List<String> readLinesFromRecyclingDataFile(String filename) {
        List<String> lines = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
        
        return lines;
    }
    public List<Integer> extractCrateQuantityData(List<String> lines) {
        List<Integer> quantities = new ArrayList<>();
        
        for(String line : lines) {
            String[] parts = line.split(" ");
            quantities.add(Integer.parseInt(parts[1]));
        }
        
        return quantities;
    }
    
    
    public int calculateMax(List<Integer> crates) {
        int max = Integer.MIN_VALUE;
        
        for(int quantity : crates) {
            if(quantity > max) {
                max = quantity;
            }
        }
        
        return max;
    }
    
    public List<Integer> copyIndexesToNewList(List<Integer> quantities, int value) {
        List<Integer> indexes = new ArrayList<>();
        
        for(int i = 0; i < quantities.size(); i++) {
            if(quantities.get(i) == value) {
                indexes.add(i);
            }
        }
        
        return indexes;
    }
    
}
