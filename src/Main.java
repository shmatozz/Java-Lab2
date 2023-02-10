import Exceptions.EmptyFileException;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws EmptyFileException {
        Scanner sc = new Scanner(System.in);
        String inputFile, outputFile;

        System.out.print("Input path to input file: ");
        inputFile = sc.next();
        System.out.print("Input path to output file: ");
        outputFile = sc.next();

        FrequencyCounter counter = new FrequencyCounter(inputFile, outputFile);
        counter.countFrequency();
    }
}