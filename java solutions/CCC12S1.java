import java.util.Scanner;
public class CCC12S1 {
  public static void main(String[] args) {
    Scanner inputScan = new Scanner(System.in);
    int maxJersey = Integer.parseInt(inputScan.nextLine());
    if (maxJersey<4){
      System.out.println(0);
    }
    else{
      System.out.println(jerseyCheck(maxJersey-1, 3));
    }
  }
   static int jerseyCheck(int jersey_num, int remaining_jerseys){
    int comboCount = 0;
    if (remaining_jerseys == 0){
        return 1;
    }
    for(int i = jersey_num; i >= 1; i-=1){
        comboCount += jerseyCheck(i-1, remaining_jerseys-1);
    }
    return comboCount;
  };
}