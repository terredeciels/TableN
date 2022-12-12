package p;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.Color.black;
import static java.awt.Color.white;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;
import static java.lang.String.valueOf;

public class C {

    private final int[][] T;
    private final int n;

    public C(int N) {
        n = N;
        T = new int[N][N];
        for (int i = 2; i < N; i++) {
            for (int j = i; j < N; j++) {
                T[i][j] = i * j;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int N = 20;
        N++;
        C c = new C(N);
        System.out.print(c);
        createImage(c);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 2; i < n; i++) {
            buffer.append('\n').append("     ".repeat(i));
            for (int j = i; j < n; j++) {
                buffer.append(T[i][j]);
                switch (valueOf((T[i][j])).length()) {
                    case 1 -> buffer.append(" ".repeat(4));
                    case 2 -> buffer.append(" ".repeat(3));
                    case 3 -> buffer.append(" ".repeat(2));
                }
            }
        }
        return buffer.toString();
    }


    private static void createImage(C c) throws IOException {
        int width = 1024;
        int height = 1024;

        BufferedImage bufferedImage = new BufferedImage(width, height, TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        // fill
        g2d.setColor(white);
        g2d.fillRect(0, 0, width, height);

        // create a string
        g2d.setColor(black);
        g2d.drawString(c.toString(), 50, 120);
//        g2d.drawString("\n".repeat(3), 50, 120);
//        g2d.drawString(c.toString(), 50, 120);

        g2d.dispose();

        File file = new File("myimage.jpg");
        ImageIO.write(bufferedImage, "jpg", file);
    }

}
