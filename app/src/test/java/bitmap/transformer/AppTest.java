/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.*;

public class AppTest {
    @Test public void test1Transfrom() {
        Bitmap img = new Bitmap();
        BufferedImage defaultImg=img.imageData;
        img.transfrom("multiFilter","Test2","Test");
        BufferedImage first= img.read("./src/main/resources/Test.bmp");
        BufferedImage second= img.read("./src/main/resources/Test2.bmp");
        assertEquals("Test multiFilter",true,first!=second);

    }
    @Test public void test2Transfrom() {
        Bitmap img = new Bitmap();
        BufferedImage defaultImg=img.imageData;
        img.transfrom("bw","Test3","Test");
        BufferedImage first= img.read("./src/main/resources/Test.bmp");
        BufferedImage second= img.read("./src/main/resources/Test3.bmp");
        assertEquals("Test bw",true,first!=second);
    }
    @Test public void test3Transfrom() {
        Bitmap img = new Bitmap();
        BufferedImage defaultImg=img.imageData;
        BufferedImage fileBefore= img.read("./src/main/resources/TestFind.bmp");
        img.transfrom("Zoom","TestFind","Test");
        BufferedImage second= img.read("./src/main/resources/TestFind.bmp");
        assertEquals("Test Zoom",true,fileBefore!=second);
    }
    @Test public void test4Transfrom() {
        Bitmap img = new Bitmap();
        BufferedImage defaultImg=img.imageData;
        BufferedImage fileBefore= img.read("./src/main/resources/TestFind2.bmp");
        img.transfrom("halfAndHalf","TestFind2","Test");
        BufferedImage second= img.read("./src/main/resources/TestFind2.bmp");
        assertEquals("Test halfAndHalf",true,fileBefore!=second);
    }


}
