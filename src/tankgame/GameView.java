
package tankgame;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohammad Hossein Heydari <mdh.heydari@gmail.com>
 */
public class GameView {
    private BoardView humanBoardView;
    private BoardView computerBoardView;
    private Player humanPlayer;
    private AIPlayer computerPlayer;
    
    public GameView()
    {
        humanBoardView = new BoardView("Your Board");
        humanBoardView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        computerBoardView = new ComputerBoardView(this);
        computerBoardView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        humanPlayer = new Player();
        computerPlayer = new AIPlayer();
        computerPlayer.addTanks();
    }
    
    public void setHumanTanksData(ArrayList<Tank> tankData)
    {
        humanPlayer.addTankArray(tankData);
        humanBoardView.update(humanPlayer.getBoard());
    }
    
    public void show()
    {
        humanBoardView.setVisible(true);
        computerBoardView.setVisible(true);
    }
    
    public boolean shotComputerBlock(int i, int j)
    {
        boolean result;
        result = computerPlayer.shotPoint(i, j);
        computerBoardView.update(computerPlayer.getBoard());
        return result;
    }
    
    public boolean shotHumanBlock(int i, int j)
    {
        boolean result;
        result = humanPlayer.shotPoint(i, j);
        humanBoardView.update(humanPlayer.getBoard());
        return result;
    }
    
    public boolean endCheck()
    {
        if(humanPlayer.isLost())
        {
            JOptionPane.showMessageDialog(null, "You lost the game!", "You lost!", JOptionPane.INFORMATION_MESSAGE);
            computerBoardView.setVisible(false);
            return true;
        }
        if(computerPlayer.isLost())
        {
            JOptionPane.showMessageDialog(null, "You won the game!", "You won!", JOptionPane.INFORMATION_MESSAGE);
            humanBoardView.setVisible(false);
            return true;
        }
        return false;
    }
    
    public Point getSelectedAiShot()
    {
        return computerPlayer.shotPoint();
    }
}
