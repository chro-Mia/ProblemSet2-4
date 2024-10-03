import images.*;
import java.util.Scanner;
public class ScalingDown
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter an image file name:");
        String filename = input.nextLine();
        APImage image = new APImage(filename);

        System.out.println("Enter an integer to scale down the image by:");
        int scale = input.nextInt();
        APImage canvas = new APImage(image.getImageWidth() / scale, image.getImageHeight() / scale);

        for(int i = 0; i < canvas.getImageHeight(); i++){
            for(int j = 0; j < canvas.getImageWidth(); j++){
                Pixel p = image.getPixel(j * scale, i * scale);
                canvas.setPixel(j, i, p);
            }
        }

        canvas.draw();
    }
}
