import Exceptions.EmptyFileException;


public class Main {
    public static void main(String[] args) throws EmptyFileException {
        FrequencyCounter counter = new FrequencyCounter();
        counter.countFrequency();
    }
}