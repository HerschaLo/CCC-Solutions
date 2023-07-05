import java.util.Scanner;
public class CCC22S1{
  public static void main(String[] args){
    Scanner inputScanner = new Scanner(System.in);
    int num = Integer.parseInt(inputScanner.nextLine());
    int count5 = num / 5;
    int remain = num % 5;
    if (remain < 4 && remain > 0 && count5 < 4 - remain){
      System.out.println(0);
    }
    else{
      if(remain < 4 && remain > 0){
        count5 -= 4 - remain;
      }
      int comboCount = count5 / 4 + 1;
      System.out.println(comboCount);
    }
  }
}