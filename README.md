## Java-Lab2
This lab includes working with files and counting characters in a text file.

---
To create a frequency counter, you need to create an object of the class **FrequencyCounter** and pass the paths to the input and output files as arguments to the constructor.
```java
inputFile = sc.next();
outputFile = sc.next();

FrequencyCounter counter = new FrequencyCounter(inputFile, outputFile);
```

Then you need to call the method **.countFrequency()** for counting symbol's frequency.
```java
counter.countFrequency();
```
the result of the counting will be in the file that you specified for output. 
> If file did not exist at the specified path, it will be created
