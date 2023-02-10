import Exceptions.EmptyFileException;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class FrequencyCounter {
    private final String fileIn;    // Поле для пути файла ввода
    private final String fileOut;   // Поле для пути файла выводы
    private final HashMap<Character, Integer> frequency = new HashMap<>();  // Хэшмэп для хранения частоты вхождения каждого символа

    /**
     * Конструктор по умолчанию
     */
    FrequencyCounter() {
        this("files\\in.txt", "files\\out.txt");
    }

    /**
     * Конструктор с параметрами
     * @param fileIn путь файла ввода
     * @param fileOut путь файла вывода
     */
    FrequencyCounter(String fileIn, String fileOut) {
        this.fileIn = fileIn; this.fileOut = fileOut;
    }

    /**
     * Подсчёт количества вхождений
     * @throws EmptyFileException если файл ввода пустой
     * @throws RuntimeException если данного файла ввода не существует
     */
    public void countFrequency() throws EmptyFileException {
        try {
            File input = new File(fileIn);
            Scanner sc = new Scanner(input);
            if (!sc.hasNext() && frequency.isEmpty()) throw new EmptyFileException("Your file is empty!"); // выбрасываем исключение если файл пустой
            while (sc.hasNext()) {
                String line = sc.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    frequency.put(line.charAt(i), frequency.getOrDefault(line.charAt(i), 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileIn + " not found");
            throw new RuntimeException(e);
        } catch (EmptyFileException e) {
            throw new EmptyFileException("Your file is empty!");
        }

        output();   // вызов функции вывода результатов посчёта в файл
    }

    /**
     * Вывод количества вхождений в файл вывода
     */
    private void output() {
        try (FileWriter out = new FileWriter(fileOut)) {
            frequency.forEach(
                    (key, value) -> {
                        try {
                            out.write(key + " - " + value + '\n');
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

