import java.util.Scanner;
import unit2.*;
public class RepeatedSequence
{
    public static void main(String[] args){

        String matchString;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string:");
        String string = input.nextLine();

        //create new FlexString with the input from the user
        FlexString flexString = new FlexString(string);

        //for each character in the string, the loop creates a string to match, from index i to index 1 + 2
        for(int i = 0; i < string.length(); i++){

            //avoid outOfBounds exception
            if(i + 2 < string.length()){
                matchString = string.substring(i, i + 2);

                //if the match string equals that of the substring two indexes ahead of i, remove the second instance
                //of the match string and replace it with "**"
                if(flexString.matches(i + 2, matchString)){
                   flexString.remove(i + 2, i + 4);
                   flexString.insert(i + 2, "**");
                }
            }
        }
        System.out.println(flexString);
        System.out.println("The string was modified " + flexString.numTimesModified() + " times.");
    }
}
