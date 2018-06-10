package graphic1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Lienzo extends Canvas implements KeyListener {

    BufferedImage img;
    private int x;
    private int y;

    public Lienzo() {
        this.x = 450;
        this.y = 170;
        this.addKeyListener(this);
        try {
            this.img = ImageIO.read(new File("img/perrito.jpg"));
        } catch (IOException e) {
            System.out.println("Imatge no trobada");
        }
    }

    public BufferedImage getImg() {
        return this.img;
    }

    /*public static void main(String[] args) {
        JFrame ventana = new JFrame("Graphic1");
        ventana.setSize(1000, 800);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container contenedor = ventana.getContentPane();
        Lienzo lienzo = new Lienzo();
        contenedor.add((Canvas)lienzo);


        ventana.setVisible(true);
        ventana.pack();

        Graphics2D g2d = (Graphics2D) lienzo.getGraphics();
        g2d.drawOval(300, 200, 400, 400);
        g2d.drawImage(lienzo.getImg(), 0, 0, 400, 400, null);
    }*/
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Graphic1");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container contenedor = ventana.getContentPane();
        Canvas lienzo = new Lienzo();
        contenedor.add(lienzo);

        ventana.setVisible(true);
        ventana.pack();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.red);
        g2d.drawImage(this.img, 0, 0, 800, 600, null);
        g2d.fillOval(100, 200, 100, 100);
        g2d.setColor(Color.cyan);
        g2d.fillOval(this.x, this.y, 25, 25);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) { 
        if (e.getKeyCode() == 37 && (this.x - 10 >= 0)) {
            this.x = this.x - 10;
        } else if (e.getKeyCode() == 39 && (this.x + 10 <= 800)) {
            this.x = this.x + 10;
        } else if (e.getKeyCode() == 38 && (this.y - 10 >= 0)) {
            this.y = this.y - 10;
        } else if (e.getKeyCode() == 40 && (this.y + 10 <= 508)) {
            this.y = this.y + 10;
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
  //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
