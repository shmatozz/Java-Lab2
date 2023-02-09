import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class FrequencyCounter {
    private final String fileIn;
    private final String fileOut;
    private final HashMap<Character, Integer> frequency = new HashMap<>();

    FrequencyCounter() {
        this("C:\\Users\\matve\\IdeaProjects\\Lab2\\files\\in.txt",
                "C:\\Users\\matve\\IdeaProjects\\Lab2\\files\\out.txt");
    }

    FrequencyCounter(String fileIn, String fileOut) {
        this.fileIn = fileIn; this.fileOut = fileOut;
    }

    public void countFrequency() {
        try {
            File input = new File(fileIn);
            Scanner sc = new Scanner(input);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    frequency.put(line.charAt(i), frequency.getOrDefault(line.charAt(i), 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileIn + "not found");
            throw new RuntimeException(e);
        }

        output();
    }

    private void output() {
        try (PrintStream out = new PrintStream(fileOut)) {
            frequency.forEach(
                    (key, value) -> out.println(key + " - " + value)
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
