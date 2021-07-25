import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

public class Browser {

   
    private static void initAndShowGUI() {
        // This method is invoked on Swing thread
        JFrame frame = new JFrame("FX");
        final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setBounds(0,0,1950,1050);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
        });
        

    }

    private static void initFX(JFXPanel fxPanel) {
        // This method is invoked on JavaFX thread
        WebView view = new WebView();
        view.getEngine().load("https://www.google.com");
            
        Scene scene = new Scene(view);
        fxPanel.setScene(scene);
    }

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initAndShowGUI();
            }
        });
    }
}