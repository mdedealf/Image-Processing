package imageprocessing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Citra {

    public static void citraGrayscale() throws IOException {
        BufferedImage img = null;
        File f = null;

        f = new File("./assets/Lena.png");
        img = ImageIO.read(f);

        int height = img.getHeight();
        int width = img.getWidth();

        for (int i = 0 ; i < height ; i++) {
            for (int j = 0 ; j < width ; j++) {
                int p = img.getRGB(i,j);

                int a = p >> 24 & 0xff;
                int r = p >> 16 & 0xff;
                int g = p >> 8 & 0xff;
                int b = p & 0xff;

                // calculate rgb
                int gray = (r+g+b) /3;

                // set new rgb
                p = a << 24 | gray << 16 | gray << 8 | gray;
                img.setRGB(i,j,p);
            }
        }

        // write new image after being convert into biner image
        f = new File("./assets/LenaGrayscale.jpg");
        ImageIO.write(img , "jpg" , f);
    }

    public static void citraBiner() throws IOException {
        BufferedImage img = null;
        File f = null;

        f = new File("./assets/Lena.png");
        img = ImageIO.read(f);

        int height = img.getHeight();
        int width = img.getWidth();
        int treshold = 128;

        for (int i = 0 ; i < height ; i++) {
            for (int j = 0 ; j < width ; j++) {
                int p = img.getRGB(i,j);

                int a = p >> 24 & 0xff;
                int r = p >> 16 & 0xff;
                int g = p >> 8 & 0xff;
                int b = p & 0xff;

                // calculate rgb
                int biner = (r+g+b) / 3;
                if (biner < treshold) {
                    biner = 0;
                }else if (biner >= treshold){
                    biner = 255;
                }

                // set new rgb
                p = a << 24 | biner << 16 | biner << 8 | biner;
                img.setRGB(i,j,p);
            }
        }

        // write new image after being convert into biner image
        f = new File("./assets/LenaBiner.jpg");
        ImageIO.write(img , "jpg" , f);
    }

    public static void citraNegative() throws IOException {
        BufferedImage img = null;
        File f = null;

        f = new File("./assets/Lena.png");
        img = ImageIO.read(f);

        int height = img.getHeight();
        int width = img.getWidth();

        for (int i = 0 ; i < height ; i++) {
            for (int j = 0 ; j < width ; j++) {
                int p = img.getRGB(i,j);

                int a = p >> 24 & 0xff;
                int r = p >> 16 & 0xff;
                int g = p >> 8 & 0xff;
                int b = p & 0xff;

                // calculate rgb
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;

                // set new rgb
                p = a << 24 | r << 16 | g << 8 | b;
                img.setRGB(i,j,p);
            }
        }

        // write new image after being convert into biner image
        f = new File("./assets/LenaNegative.jpg");
        ImageIO.write(img , "jpg" , f);
    }

    public static void citraBrightness() throws IOException {
        BufferedImage img = null;
        File f = null;

        f = new File("./assets/Lena.png");
        img = ImageIO.read(f);

        int height = img.getHeight();
        int width = img.getWidth();

        for (int i = 0 ; i < height ; i++) {
            for (int j = 0 ; j < width ; j++) {
                int p = img.getRGB(i,j);

                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                // calculate rgb
                int brightness = -100;
                int newR = r + brightness;
                int newG = g + brightness;
                int newB = b + brightness;

                if (newR < 0){
                    newR = 0;
                }else if (newR > 255){
                    newR = 255;
                }else newR = newR;

                if (newB < 0){
                    newB = 0;
                }else if (newB > 255){
                    newB = 255;
                }else newB = newB;

                if (newG < 0){
                    newG = 0;
                }else if (newG > 255){
                    newG = 255;
                }else newG = newG;

                // set new rgb
                p = a << 24 | newR << 16 | newG << 8 | newB;
                img.setRGB(i,j,p);
            }
        }

        // write new image after being convert into biner image
        f = new File("./assets/LenaBrightness.jpg");
        ImageIO.write(img , "jpg" , f);
    }

    public static void penjumlahanCitra() throws IOException {
        BufferedImage img1 = null;
        BufferedImage img2 = null;
        File f = null;
        File h = null;

        f = new File("./assets/Lena.png");
        img1 = ImageIO.read(f);
        h = new File("./assets/LenaGrayscale.jpg");
        img2 = ImageIO.read(h);

        int height1 = img1.getHeight();
        int width1 = img1.getWidth();

        int height2 = img2.getHeight();
        int width2 = img2.getWidth();

        for (int i = 0 ; i < height1 ; i++) {
            for (int j = 0 ; j < width1 ; j++) {
                int p1 = img1.getRGB(i,j);
                int p2 = img2.getRGB(i,j);
                int p3 = 0 ,r3 = 0 ,g3 = 0,b3 = 0 ,a3 = 0;

                int a1 = p1 >> 24 & 0xff;
                int r1 = p1 >> 16 & 0xff;
                int g1 = p1 >> 8 & 0xff;
                int b1 = p1 & 0xff;

                int a2 = p2 >> 24 & 0xff;
                int r2 = p2 >> 16 & 0xff;
                int g2 = p2 >> 8 & 0xff;
                int b2 = p2 & 0xff;

                // calculate rgb
                r3 = r1 + r2;
                g3 = g1 + g2;
                b3 = b1 + b2;

                if (r3 < 0){
                    r3 = 0;
                }else if (r3 > 255){
                    r3 = 255;
                }else r3 = r3;

                if (g3 < 0){
                    g3 = 0;
                }else if (g3 > 255){
                    g3 = 255;
                }else g3 = g3;

                if (b3 < 0){
                    b3 = 0;
                }else if (b3 > 255){
                    b3 = 255;
                }else b3 = b3;


                // set new rgb
                p3 = a3 << 24 | r3 << 16 | g3 << 8 | b3;
                img1.setRGB(i,j,p3);
            }
        }

        // write new image after being convert into biner image
        f = new File("./assets/penjumlahanLena.jpg");
        ImageIO.write(img1 , "jpg" , f);
    }

    public static void penguranganCitra() throws IOException {
        BufferedImage img1 = null;
        BufferedImage img2 = null;
        File f = null;
        File h = null;

        f = new File("./assets/Lena.png");
        img1 = ImageIO.read(f);
        h = new File("./assets/LenaNegative.jpg");
        img2 = ImageIO.read(h);

        int height1 = img1.getHeight();
        int width1 = img1.getWidth();

        int height2 = img2.getHeight();
        int width2 = img2.getWidth();

        for (int i = 0 ; i < height1 ; i++) {
            for (int j = 0 ; j < width1 ; j++) {
                int p3 = 0 ,r3 = 0 ,g3 = 0,b3 = 0 ,a3 = 0;

                int p1 = img1.getRGB(i,j);
                int a1 = p1 >> 24 & 0xff;
                int r1 = p1 >> 16 & 0xff;
                int g1 = p1 >> 8 & 0xff;
                int b1 = p1 & 0xff;

                int p2 = img2.getRGB(i,j);
                int r2 = p2 >> 16 & 0xff;
                int g2 = p2 >> 8 & 0xff;
                int b2 = p2 & 0xff;

                // calculate rgb
                r3 = r1 - r2;
                g3 = g1 - g2;
                b3 = b1 - b2;

                if (r3 < 0){
                    r3 = 0;
                }else if (r3 > 255){
                    r3 = 255;
                }else r3 = r3;

                if (g3 < 0){
                    g3 = 0;
                }else if (g3 > 255){
                    g3 = 255;
                }else g3 = g3;

                if (b3 < 0){
                    b3 = 0;
                }else if (b3 > 255){
                    b3 = 255;
                }else b3 = b3;

                // set new rgb
                p3 = a1 << 24 | r3 << 16 | g3 << 8 | b3;
                img1.setRGB(i,j,p3);
            }
        }

        // write new image after being convert into biner image
        f = new File("./assets/penguranganLena.jpg");
        ImageIO.write(img1 , "jpg" , f);
    }

    public static void perkalianCitra() throws IOException {
        BufferedImage img1 = null;
        BufferedImage img2 = null;
        File f = null;
        File h = null;

        f = new File("./assets/Lena.png");
        img1 = ImageIO.read(f);
        h = new File("./assets/LenaBiner.jpg");
        img2 = ImageIO.read(h);

        int height1 = img1.getHeight();
        int width1 = img1.getWidth();

        int height2 = img2.getHeight();
        int width2 = img2.getWidth();

        for (int i = 0 ; i < height1 ; i++) {
            for (int j = 0 ; j < width1 ; j++) {
                int p3 = 0 ,r3 = 0 ,g3 = 0,b3 = 0 ,a3 = 0;

                int p1 = img1.getRGB(i,j);
                int a1 = p1 >> 24 & 0xff;
                int r1 = p1 >> 16 & 0xff;
                int g1 = p1 >> 8 & 0xff;
                int b1 = p1 & 0xff;

                int p2 = img2.getRGB(i,j);
                int r2 = p2 >> 16 & 0xff;
                int g2 = p2 >> 8 & 0xff;
                int b2 = p2 & 0xff;

                // calculate rgb
                r3 = (r1 * r2);
                g3 = (g1 * g2);
                b3 = (b1 * b2);

                if (r3 < 0){
                    r3 = 0;
                }else if (r3 > 255){
                    r3 = 255;
                }else r3 = r3;

                if (g3 < 0){
                    g3 = 0;
                }else if (g3 > 255){
                    g3 = 255;
                }else g3 = g3;

                if (b3 < 0){
                    b3 = 0;
                }else if (b3 > 255){
                    b3 = 255;
                }else b3 = b3;


                // set new rgb
                p3 = a1 << 24 | r3 << 16 | g3 << 8 | b3;
                img1.setRGB(i,j,p3);
            }
        }
        // write new image after being convert into biner image
        f = new File("./assets/perkalianLena.jpg");
        ImageIO.write(img1 , "jpg" , f);
    }

    public static void komplemenCitraBiner() throws IOException {
        BufferedImage img = null;
        File f = null;

        f = new File("./assets/LenaBiner.jpg");
        img = ImageIO.read(f);

        int height = img.getHeight();
        int width = img.getWidth();

        for (int i = 0 ; i < height ; i++) {
            for (int j = 0 ; j < width ; j++) {
                int p = img.getRGB(i,j);

                int a = p >> 24 & 0xff;
                int r = p >> 16 & 0xff;
                int g = p >> 8 & 0xff;
                int b = p & 0xff;

                // komplement
                if (r == 0) {
                    r = 255;
                }else r = 0;

                if (g == 0) {
                    g = 255;
                }else g = 0;

                if (b == 0) {
                    b = 255;
                }else b = 0;

                // set new rgb
                p = a << 24 | r << 16 | g << 8 | b;
                img.setRGB(i,j,p);
            }
        }
        // write new image
        f = new File("./assets/komplemenLenaBiner.jpg");
        ImageIO.write(img , "jpg" , f);
    }

    public static void citraTranslasi() throws IOException {
        BufferedImage img1 = null;
        File f1 = null;

        f1 = new File("./assets/Lena.png");
        img1 = ImageIO.read(f1);

        BufferedImage img2 = null;
        File f2 = null;

        f2 = new File("./assets/white.jpg");
        img2 = ImageIO.read(f2);

        int height = img1.getHeight();
        int width = img1.getWidth();
        int m = 200;
        int n = 100;

        for (int i = 0 ; i < height ; i++) {
            for (int j = 0 ; j < width ; j++) {
                int p = img1.getRGB(i,j);

                int newI = i + m;
                int newJ = j + n;

                if (newI > width || newJ > height){
                    newI = width-1;
                    newJ = height-1;
                }else {
                    newI = newI;
                    newJ = newJ;
                }
                img2.setRGB(newI,newJ,p);
            }
        }
        // write new image
        f1 = new File("./assets/translasiLena.jpg");
        ImageIO.write(img2 , "jpg" , f1);
    }

    public static void zoomOutCitra() throws IOException {
        BufferedImage img1 = null;
        File f1 = null;

        f1 = new File("./assets/Lena.png");
        img1 = ImageIO.read(f1);

        BufferedImage img2 = null;
        File f2 = null;

        f2 = new File("./assets/rsz_white.jpg");
        img2 = ImageIO.read(f2);

        int height = img1.getHeight();
        int width = img1.getWidth();

        for (int i = 0 ; i < height ; i++) {
            for (int j = 0 ; j < width ; j++) {
                int p = img1.getRGB(i,j);

                int newI = i/2;
                int newJ = j/2;
                img2.setRGB(newI,newJ, img1.getRGB(i,j));
            }
        }
        // write new image
        f1 = new File("./assets/zoomOutLena.jpg");
        ImageIO.write(img2 , "jpg" , f1);
    }

    public static void flippingCitra() throws IOException {
        BufferedImage img1 = null;
        File f1 = null;

        f1 = new File("./assets/Lena.png");
        img1 = ImageIO.read(f1);

        BufferedImage img2 = null;
        File f2 = null;

        f2 = new File("./assets/rsz_white.jpg");
        img2 = ImageIO.read(f2);

        int height = img1.getHeight();
        int width = img1.getWidth();

        for (int i = 0 ; i < height ; i++) {
            for (int j = 0 ; j < width ; j++) {
                img2.setRGB(width-i-1, j , img1.getRGB(i,j));
            }
        }
        // write new image
        f1 = new File("./assets/flippingLena.jpg");
        ImageIO.write(img2 , "jpg" , f1);
    }

    public static void rotasiCitra() throws IOException
    {
        BufferedImage img1 = null;
        File f1 = null;

        f1 = new File("./assets/Lena.png");
        img1 = ImageIO.read(f1);

        BufferedImage img2 = null;
        File f2 = null;

        f2 = new File("./assets/rsz_white.jpg");
        img2 = ImageIO.read(f2);

        int height = img1.getHeight();
        int width = img1.getWidth();

        for (int i = 0 ; i < height ; i ++) {
            for (int j = 0 ; j < width ; j++) {
                img2.setRGB(j , (width-1) - i, img1.getRGB(i,j));
            }
        }
        // write new image
        f1 = new File("./assets/rotationLena.jpg");
        ImageIO.write(img2 , "jpg" , f1);
    }

    public static void main(String[] args) throws IOException{
        citraGrayscale();
        citraBiner();
        citraNegative();
        citraBrightness();
        penjumlahanCitra();
        penguranganCitra();
        perkalianCitra();
        komplemenCitraBiner();
        citraTranslasi();
        zoomOutCitra();
        flippingCitra();
        rotasiCitra();
    }
}
