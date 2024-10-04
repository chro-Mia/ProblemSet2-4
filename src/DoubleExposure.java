import images.*;
import java.util.Scanner;
public class DoubleExposure
{
    public static void main(String[] args){

        int canvasWidth;
        int canvasHeight;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an image file name:");
        String filename = input.nextLine();
        APImage image1 = new APImage(filename);
        System.out.println("Enter another image file name:");
        filename = input.nextLine();
        APImage image2 = new APImage(filename);

        //this code makes sure that the canvas size is the largest width and the largest height of the 2 images
        //Math.max returns the greater of two int values passed in
        canvasWidth = Math.max(image1.getImageWidth(), image2.getImageWidth());
        canvasHeight = Math.max(image1.getImageHeight(), image2.getImageHeight());

        //the canvas will be expanded to fit both images
        APImage canvas = new APImage(canvasWidth, canvasHeight);

        //a for-each loop would not work, since we need location data (x, y)
        //this loops through each pixel in the *canvas*, not the images passed in
        for(int i = 0; i < canvas.getImageHeight(); i++){
            for (int j = 0; j < canvas.getImageWidth(); j++){

                //define pixel objects
                Pixel p1;
                Pixel p2;

                //prevent out of bounds exception by using the pixel location of the canvas when we attempt to go OOB
                //this also technically lets you use any canvas color you'd like
                if(j < image1.getImageWidth() && i < image1.getImageHeight()){
                    p1 = image1.getPixel(j, i);
                }
                else{
                    p1 = canvas.getPixel(j, i);
                }
                if(j < image2.getImageWidth() && i < image2.getImageHeight()){
                    p2 = image2.getPixel(j, i);
                }
                else{
                    p2 = canvas.getPixel(j, i);
                }

                //average colors
                int redMean = (p1.getRed() + p2.getRed()) / 2;
                int greenMean = (p1.getGreen() + p2.getGreen()) / 2;
                int blueMean = (p1.getBlue() + p2.getBlue()) / 2;

                //initialize new pixel and set it on the canvas
                Pixel mean = new Pixel(redMean, greenMean, blueMean);
                canvas.setPixel(j, i, mean);
            }
        }

        canvas.draw();
    }
}
