
package tankgame;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
//import javax.swing.plaf.metal.MetalLookAndFeel
/**
 * 
 * @author Mohammad Hossein Heydari
 */
public class TankGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player player = new Player();
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TankGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        GameStartEvent gs = new GameStartEvent();
        AddTankView test = new AddTankView(gs);
        test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        GameView game = new GameView();
        test.setVisible(true);
        gs.setGameView(game);
        gs.setAddTankView(test);
    }
}
