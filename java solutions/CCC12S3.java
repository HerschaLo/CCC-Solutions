import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.lang.Math;
public class CCC12S3 {
  public static void main(String[] args) {
    Scanner inputScan = new Scanner(System.in);
    Integer sensorCount = Integer.parseInt(inputScan.nextLine());
    Integer[] sensorReadings = new Integer[1001];
    for(int i=0; i<1001; i+=1){
      sensorReadings[i] = 0;
    }
    for(int i=0; i < sensorCount; i+=1){
      Integer reading = Integer.parseInt(inputScan.nextLine());
      sensorReadings[reading] += 1;
      
    }
    Integer[] sortedReadings = sensorReadings.clone();
    Arrays.sort(sortedReadings);
    Collections.reverse(Arrays.asList(sortedReadings));
    Integer topReading1Count = sortedReadings[0];
    Integer topReading2Count = sortedReadings[1];
  
    Integer[] reversedSensorReadings = sensorReadings.clone();
    Collections.reverse(Arrays.asList(sensorReadings));

    Integer topReading1Max = 1000 - Arrays.asList(reversedSensorReadings).indexOf(topReading1Count);
    Integer topReading1Min = Arrays.asList(sensorReadings).indexOf(topReading1Count);
    Integer topReading2Max = 1000 - Arrays.asList(reversedSensorReadings).indexOf(topReading2Count);
    Integer topReading2Min = Arrays.asList(sensorReadings).indexOf(topReading2Count);
    System.out.println(Math.max(Math.abs(topReading1Max - topReading2Min),Math.abs(topReading2Max-topReading1Min)));
  }; 
}