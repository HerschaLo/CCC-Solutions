import java.util.Scanner;
public class CCC11S2{
  public static void main(String[] args){
    Scanner inputScanner = new Scanner(System.in);
    int questionCount = Integer.parseInt(inputScanner.nextLine());
    char[] studentAnswers = new char[questionCount];
    char[] correctAnswers = new char[questionCount];
    int correctCount = 0;
    for(int i = 0; i < questionCount; i+=1){
      studentAnswers[i] = inputScanner.nextLine().charAt(0);
    }
    for(int i = 0; i < questionCount; i+=1){
      correctAnswers[i] = inputScanner.nextLine().charAt(0);
    }
    for(int i = 0; i < questionCount; i+=1){
      if (correctAnswers[i] == studentAnswers[i]){
        correctCount += 1;
      }
    }
    System.out.println(correctCount);
  }
}