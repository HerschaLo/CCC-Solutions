import java.util.Scanner;
import java.util.ArrayList;
public class CCC15S1{
  public static void main(String[] args){
    Scanner inputScanner = new Scanner(System.in);
    int count = Integer.parseInt(inputScanner.nextLine());
    ArrayList<Integer> nums = new ArrayList<Integer>();
    for(int i=0; i<count; i+=1){
      int num = Integer.parseInt(inputScanner.nextLine());
      if(num > 0){
        nums.add(num);
      }
      else{
        nums.remove(nums.size()-1);
      }
    }
    int numSum = 0;
    for(int i: nums){
      numSum += i;
    }
    System.out.println(numSum);
  }
}