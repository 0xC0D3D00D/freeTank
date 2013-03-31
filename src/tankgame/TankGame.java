
package tankgame;

import java.util.logging.Level;
import java.util.logging.Logger;
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
        Tank tank = new Tank(0,3,5,Direction.Horizontal);
        Tank tank2 = new Tank(4,5,3, Direction.Vertical);
        player.addTank(tank);
        player.addTank(tank2);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TankGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        BoardView game = new BoardView("Test BoardView");
        game.update(player.getBoard());
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(600,600);
        game.setVisible(true);
    }
}
