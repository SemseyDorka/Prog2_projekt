
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class fileUtils {
    public static List<String> readlines(String filename) {
        List<String> lines = new ArrayList<String>();

        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO error");
        }
        return lines;
    }

    public static void Writelines(List<String> list, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (String line : list)
            {
                bw.write(line + "\n");
            }
           // System.out.println("File writing complete");
        }
        catch (IOException e)
        {
            System.err.println("Error while writing file: " + e.getMessage());
        }
    }
}