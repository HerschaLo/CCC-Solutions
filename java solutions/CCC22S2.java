import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
public class CCC22S2{
  public static void main(String[] args){
    Scanner inputScanner = new Scanner(System.in);
    HashMap<String, ArrayList<String>> mustIncludes = new HashMap<String, ArrayList<String>>();
    HashMap<String, HashSet<String>> mustNotIncludes = new HashMap<String, HashSet<String>>();
    int x = Integer.parseInt(inputScanner.nextLine());
    for (int i=0; i < x; i +=1){
      String[] names = inputScanner.nextLine().split(" ");
      
      if (!mustIncludes.containsKey(names[0])){
        mustIncludes.put(names[0], new ArrayList<String>());
      }
      if (!mustIncludes.containsKey(names[1])){
        mustIncludes.put(names[1], new ArrayList<String>());
      }
      ArrayList<String> personalInclude = mustIncludes.get(names[0]);
      personalInclude.add(names[1]);
      personalInclude = mustIncludes.get(names[1]);
      personalInclude.add(names[0]);
    }
    int y = Integer.parseInt(inputScanner.nextLine());
    for (int i=0; i < y; i +=1){
      String[] names = inputScanner.nextLine().split(" ");
      
      if (!mustNotIncludes.containsKey(names[0])){
        mustNotIncludes.put(names[0], new HashSet<String>());
      }
      if (!mustNotIncludes.containsKey(names[1])){
        mustNotIncludes.put(names[1], new HashSet<String>());
      }
      HashSet<String> personalNotInclude = mustNotIncludes.get(names[0]);
      personalNotInclude.add(names[1]);
      personalNotInclude = mustNotIncludes.get(names[1]);
      personalNotInclude.add(names[0]);   
    }
    int g = Integer.parseInt(inputScanner.nextLine());
    int breakCounter = 0;
    int includeBreakCounter = 0;
    for (int i=0; i<g; i+=1){
      String[] names = inputScanner.nextLine().split(" ");
      String[] pair1 = {names[0], names[1]};
      String[] pair2 = {names[0], names[2]};
      String[] pair3 = {names[1], names[2]};
      String[][] pairs= {pair1, pair2, pair3};
      for(String[] pair: pairs){
        HashSet<String> notInclude1 = mustNotIncludes.get(pair[0]);
        if(notInclude1 != null){
          if(notInclude1.contains(pair[1])){
            breakCounter += 1;
          }
        }
      }
      HashSet<String> nameSet = new HashSet<String>();
      for(String name: names){
        nameSet.add(name);
      }
      for(String name: names){
        ArrayList<String> personalIncludes = mustIncludes.get(name);
          if(personalIncludes != null){
            for(String mustInclude: personalIncludes){
              if(!nameSet.contains(mustInclude)){
                includeBreakCounter += 1;
              }
            }
        }
      }
    }
    breakCounter += includeBreakCounter/2;
    System.out.println(breakCounter);
  }
}