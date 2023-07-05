import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Scanner;
public class CCC11S1{
  public static void main(String[] args){
    Scanner inputScanner = new Scanner(System.in);
    int lineCount = Integer.parseInt(inputScanner.nextLine());
    int sCount = 0;
    int tCount = 0;
    ArrayList<String> tMatches = new ArrayList<String>();
    ArrayList<String> sMatches = new ArrayList<String>();
    for(int i=0; i<lineCount; i+= 1){
      String text = inputScanner.nextLine();
      Matcher tMatcher = Pattern.compile("[tT]").matcher(text.strip());
      Matcher sMatcher = Pattern.compile("[sS]").matcher(text.strip());
      while (tMatcher.find()){
        tMatches.add(tMatcher.group());
      }
      while (sMatcher.find()){
        sMatches.add(sMatcher.group());
      }
    }
    if (sMatches.size() >= tMatches.size()){
      System.out.println("French");
    }
    else{
      System.out.println("English");
    }
  }
}