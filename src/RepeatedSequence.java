import java.util.Scanner;
import unit2.*;
public class RepeatedSequence
{
    public static void main(String[] args){

        String biString;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string:");
        String string = input.nextLine();

        FlexString flexString = new FlexString(string);

        for(int i = 0; i < string.length(); i++){
            if(i + 2 < string.length()){
                biString = string.substring(i, i + 2);
                if(flexString.matches(i + 2, biString)){
                   flexString.remove(i + 2, i + 4);
                   flexString.insert(i + 2, "**");
                }
            }
        }
        System.out.println(flexString);
        System.out.println("The string was modified " + flexString.numTimesModified() + " times.");
    }
}
