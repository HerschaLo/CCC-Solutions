import java.util.Scanner;
import java.lang.Math;
public class CCC11S3{
  public static void main(String[] args){
    Scanner inputScan = new Scanner(System.in);
    int numberOfSamples = Integer.parseInt(inputScan.nextLine());

    int[][] samples = new int[numberOfSamples][3];
    for(int i=0; i<numberOfSamples; i+=1){
        String[] sampleStrForm = inputScan.nextLine().split(" ");
        int[] sampleIntForm = new int[3];
        for(int j=0; j< 3; j+=1){
          sampleIntForm[j] = Integer.parseInt(sampleStrForm[j]);
        }
        samples[i] = sampleIntForm;
    }

    for(int[] i: samples){
        int magnification = i[0];
        int x = i[1];
        int y = i[2];
        while (magnification>0){
            if (Math.pow(5,magnification)*0.2 <= x && x <= Math.pow(5,magnification)*0.8 && y < Math.pow(5,magnification)*0.2){
                System.out.println("crystal");
                break;
            }
            else if(Math.pow(5,magnification)*0.4 <= x && x <= Math.pow(5,magnification)*0.6 && y < Math.pow(5,magnification)*0.4){
                System.out.println("crystal");
                break;
            }
            else if(magnification == 1){
                System.out.println("empty");
                break;
            }

            else{
                if(Math.pow(5,magnification)*0.4 <= x && x <= Math.pow(5,magnification)*0.6 && Math.pow(5,magnification)*0.4 <= y && y <= Math.pow(5,magnification)*0.6){

                    x -= Math.pow(5,magnification) * 0.4;
                    y -= Math.pow(5,magnification) * 0.4;
                    magnification -= 1;
                }

                else if (Math.pow(5,magnification)*0.2 <= y && y <= Math.pow(5,magnification)*0.4){
                    if (Math.pow(5,magnification)*0.2 <= x && x <= Math.pow(5,magnification)*0.4){
                        x -= Math.pow(5,magnification) * 0.2;
                        y -= Math.pow(5,magnification) * 0.2;
                        magnification -= 1;
                    }
                    else if (Math.pow(5,magnification)*0.6 <= x && x <= Math.pow(5,magnification)*0.8){
                        x -= Math.pow(5,magnification) * 0.6;
                        y -= Math.pow(5,magnification) * 0.6;
                        magnification -= 1;
                    }
                    else{
                        System.out.println("empty");
                        break;
                    }
                }
                else{
                    System.out.println("empty");
                    break;
                }
              }
            }
        }
    }
}