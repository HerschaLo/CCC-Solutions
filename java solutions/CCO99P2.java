import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class CCO99P2{
  public static void main(String[] args){
    Scanner inputScanner = new Scanner(System.in);
    int setCount = Integer.parseInt(inputScanner.nextLine());
    for (int i=0; i<setCount; i+=1){
      String[] setSpecifications = inputScanner.nextLine().split(" ");
      int lineCount = Integer.parseInt(setSpecifications[0]);
      int place = Integer.parseInt(setSpecifications[1]);
      HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
      for (int j=0; j<lineCount; j+=1){
        String word = inputScanner.nextLine();
        wordCountMap.merge(word, 1, Integer::sum);   
      }
      HashMap<Integer, ArrayList<String>> countPlacingMap = new HashMap<Integer, ArrayList<String>>();
      for(String word: wordCountMap.keySet()){
        int count = wordCountMap.get(word);
        if(!countPlacingMap.containsKey(count)){
          countPlacingMap.put(count, new ArrayList<String>());
        }
        countPlacingMap.get(count).add(word);
      }
      Object[] counts = countPlacingMap.keySet().toArray();
      Arrays.sort(counts, Collections.reverseOrder());
      String suffix = "";
      String placeStr = Integer.toString(place);
      int placeStrSize = placeStr.length();
      if(placeStr.length() >= 2 && placeStr.charAt(placeStrSize-2) != '1' || placeStr.length() == 1){
          if(placeStr.charAt(placeStrSize-1) == '1'){
              suffix = "st";
          }
          else if(placeStr.charAt(placeStrSize-1) == '2'){
            suffix = "nd";
          }
          else if(placeStr.charAt(placeStrSize-1) == '3'){
            suffix = "rd";
          }
          else{
              suffix = "th";
          }
      }
      else{
        suffix = "th";
      }
      System.out.println(placeStr+suffix+" most common word(s):");
      int abvCount = 0;
      for(int j=0; j<counts.length; j+=1){
        abvCount += countPlacingMap.get(counts[j]).size();
        if(abvCount == place-1 && j < counts.length-1){
            System.out.println(String.join("\n", countPlacingMap.get(counts[j+1])));
            break;
        }
        else if(place == 1){
            System.out.println(String.join("\n", countPlacingMap.get(counts[0])));
            break;
        }
        else if(abvCount > place){
            break;
        }
      }
      System.out.println("");
    }
  }
}
/*
set_count = int(input())

for i in range(set_count):
    set_specifications = input().split()
    line_count = int(set_specifications[0])
    place = int(set_specifications[1])
    word_count_dict = {}
    for j in range(line_count):
        word = input()
        if word not in word_count_dict:
            word_count_dict[word] = 0
        word_count_dict[word] += 1
    count_placing_dict = {}
    for word in word_count_dict:
        count = word_count_dict[word]
        if count not in count_placing_dict:
            count_placing_dict[count] = []
        count_placing_dict[count].append(word)
    counts = sorted(count_placing_dict.keys(), reverse=True)
    suffix = ""
    if len(str(place)) >= 2:
        if str(place)[-2] != "1":
            if str(place)[-1] == "1":
                suffix = "st"
            elif str(place)[-1] == "2":
                suffix = "nd"
            elif str(place)[-1] == "3":
                suffix = "rd"
            else:
                suffix = "th"
        else:
            suffix = "th"
    else:
        if str(place)[-1] == "1":
            suffix = "st"
        elif str(place)[-1] == "2":
            suffix = "nd"
        elif str(place)[-1] == "3":
            suffix = "rd"
        else:
            suffix = "th"
    print(str(place)+suffix+" most common word(s):")
    abv_count = 0
    for j in range(len(counts)):
        abv_count += len(count_placing_dict[counts[j]])
        if abv_count == place-1 and j < len(counts)-1:
            print("\n".join(count_placing_dict[counts[j+1]]))
            break
        elif place == 1:
            print("\n".join(count_placing_dict[counts[0]]))
            break
        elif abv_count > place:
            break
    print("")
*/