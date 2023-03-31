import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class DataGenerator {
    public static void main(String[] args) {
        Random r = new Random();
        try {
            String filename = "File.txt";
            File file = new File(filename);
            if (!file.exists()) {
                file.createNewFile();
            }
            int num_sets = 50 + r.nextInt(51);
            int min_size = 100;
            int max_size = 10000;
            PrintWriter pw = new PrintWriter(file);
            for (int i = 0; i < num_sets; i++) {
                int size = min_size + r.nextInt(max_size - min_size + 1);
                for (int j = 0; j < size; j++) {
                    pw.print("" + (r.nextInt(10000) + 1) + " ");
                }
                pw.print("\n");
            }
            pw.close();

        } catch(IOException e) {
            System.out.print("Error: " + e);
        }
    }
}
