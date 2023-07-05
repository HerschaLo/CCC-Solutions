import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class CCC12S2 {
  public static void main(String[] args) {
    Scanner inputScan = new Scanner(System.in);
    String aroNumber = inputScan.nextLine();
    Matcher arPairSearch = Pattern.compile("[0-9][A-Z]").matcher(aroNumber);
    int totalValue = 0;
    ArrayList<String> allMatches = new ArrayList<String>();
    while (arPairSearch.find()) {
      allMatches.add(arPairSearch.group());
    }
    for (int i = 0; i < allMatches.size(); i += 1) {
      String curArPair = allMatches.get(i);
      String nextArPair;
      try {
        nextArPair = allMatches.get(i + 1);
      } catch (Exception e) {
        nextArPair = allMatches.get(0);
      }
      HashMap<Character, Integer> switcher = new HashMap<Character, Integer>();
      switcher.put('I', 1);
      switcher.put('V', 5);
      switcher.put('X', 10);
      switcher.put('L', 50);
      switcher.put('C', 100);
      switcher.put('D', 500);
      switcher.put('M', 1000);
      Integer curArabicValue = Character.getNumericValue(curArPair.charAt(0));
      Integer curRomanValue = switcher.get(curArPair.charAt(1));

      int curPairValue = curArabicValue * curRomanValue;
      int nextRomanValue = switcher.get(nextArPair.charAt(1));
      
      if (i < allMatches.size() - 1) {
        if (nextRomanValue > curRomanValue) {
          curPairValue *= -1;
        }
      }
      totalValue += curPairValue;
    }
    System.out.println(totalValue);
  }
}