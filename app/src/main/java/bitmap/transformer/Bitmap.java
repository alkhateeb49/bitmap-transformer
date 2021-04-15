package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {
    public int height;
    public int width;
    public BufferedImage imageData;

    // Constructor
    public Bitmap (String themeName,String targetName,String fileName) {
        transfrom(themeName,targetName,fileName);
    }
    public Bitmap () {
        Bitmap img = new Bitmap("bw","Test1","Test");
    }

    public BufferedImage read(String filePath) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(filePath));
            this.imageData=img;
            this.height = this.imageData.getHeight();
            this.width = this.imageData.getWidth();
        } catch (IOException e) {
            System.out.println("Failed to open image");
            System.out.println(e);
        }
        return img;
    }


    public void transfrom(String themeName,String targetName,String fileName){
        try {
            final File f = new File(App.class.getProtectionDomain().getCodeSource().getLocation().getPath());
            String path = "./app/src/main/resources/" + fileName + ".bmp";
            if (f.compareTo(new File("C:\\Users\\asoom\\Desktop\\bitmap-transformer\\app\\out\\production\\classes")) != 0){
                path = "./src/main/resources/" + fileName + ".bmp";
            };
            read(path);
            if (themeName == "bw") {
                BufferedImage result = new BufferedImage(imageData.getWidth(), imageData.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
                Graphics2D graphic = result.createGraphics();
                graphic.drawImage(imageData, 0, imageData.getHeight(), imageData.getWidth(), 0, 0, 0, imageData.getWidth(), imageData.getHeight(), null);
                graphic.dispose();
                imageData=result;
            } else if (themeName == "multiFilter") {
                int rgb;
                for (int h = 1; h < this.height; h++) {
                    for (int w = 1; w < this.width; w++) {
                        rgb = this.imageData.getRGB(w, h) * 2;
                        this.imageData.setRGB(w, h, rgb);
                    }
                }
            } else if (themeName == "Zoom") {
                int rgb;
                for (int h = 1; h < this.height - 1; h++) {
                    for (int w = 1; w < this.width - 1; w++) {
                        rgb = this.imageData.getRGB(w, h);
                        this.imageData.setRGB(w + 1, h + 1, rgb);
                    }
                }
            } else if (themeName == "BlueDots") {
                int rgb;
                for (int h = 1; h < this.height; h = h + 2) {
                    for (int w = 1; w < this.width; w = w + 2) {
                        this.imageData.setRGB(w, h, 255);
                    }
                }
            } else if (themeName == "halfAndHalf") {
                int rgb;
                for (int h = 1; h < this.height / 2; h++) {
                    for (int w = 1; w < this.width; w = w + 4) {
                        this.imageData.setRGB(w, h, 255058190);
                    }
                }
                for (int h = this.height / 2; h < this.height; h++) {
                    for (int w = 1; w < this.width; w = w + 4) {
                        this.imageData.setRGB(w, h, 255218064);
                    }
                }
            }
            this.save(imageData, targetName);

        }catch (Exception ex){System.out.println(ex);}
    }


    public void save(BufferedImage result,String targetName) {
        final File f = new File(App.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String path = "./app/src/main/resources/" + targetName + ".bmp";
        if (f.compareTo(new File("C:\\Users\\asoom\\Desktop\\bitmap-transformer\\app\\out\\production\\classes")) != 0){
            path = "./src/main/resources/" + targetName + ".bmp";
        };
        File output = new File(path);
        try {
            ImageIO.write(result, "bmp", output);
        } catch (IOException e) {
            System.out.println("ERROR SAVING!");
            System.out.println(e);
        }
    }
}
