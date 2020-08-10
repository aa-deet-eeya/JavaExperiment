package Image.assets.SimpleScreen;
import javax.swing.ImageIcon ;
import javax.swing.*;
import java.awt.*;

public class ImageDisplay extends JFrame {
    private Screen S ;
    private Image succ ;
    private Image space ;
    private boolean loaded ;

    public static void main(String[] args) {
        DisplayMode DM = new DisplayMode(1920, 1080, 16, DisplayMode.REFRESH_RATE_UNKNOWN) ;
        ImageDisplay img = new ImageDisplay() ;

        img.run(DM) ;
    }

    private void run(DisplayMode disp){
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.ITALIC, 25));
        loaded = false ;

        S = new Screen() ;
        try {
            S.setFullScreen(disp, this);
            loadPics() ;
            try {
                Thread.sleep(2000);
            } catch (Exception ignore) {}
        } finally {
            S.restoreScreen();
        }

    }

    public void loadPics() {
        succ = new ImageIcon("/home/vostok/Desktop/java/JavaExperiment/src/Image.assets/succ.jpeg").getImage() ;
        space = new ImageIcon("/home/vostok/Desktop/java/JavaExperiment/src/Image.assets/space.jpeg").getImage() ;
        loaded = true ;
        repaint();
    }

    public void paint(Graphics G){
        if(G instanceof Graphics2D){
            Graphics2D G2 = (Graphics2D) G ;
            G2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }

        if(loaded){
            G.drawImage(space, 0,0,null) ;
            G.drawImage(succ, 200,200, null) ;
        }
    }
}
