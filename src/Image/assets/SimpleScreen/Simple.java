package Image.assets.SimpleScreen;

import java.awt.*;
import javax.swing.* ;

public class Simple extends JFrame {
    public static void main(String[] args) {
        DisplayMode DM = new DisplayMode(1920, 1080, 16, DisplayMode.REFRESH_RATE_UNKNOWN) ;

        Simple one = new Simple() ;
        one.run(DM) ;
    }
    public void run(DisplayMode something) {
        setBackground(Color.BLACK) ;
        setForeground(Color.WHITE) ;
        setFont(new Font("Arial", Font.ITALIC, 25));

        Screen first = new Screen() ;
        try {
            first.setFullScreen(something, this);
            try{
                Thread.sleep(2000);
            } catch (Exception ignore){}
        } finally {
            first.restoreScreen();
        }

    }

    public void paint(Graphics G){
        if(G instanceof Graphics2D){
            Graphics2D G2 = (Graphics2D) G ;
            G2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }
        G.drawString("I guess we did it bois", 800,600);
    }
}
