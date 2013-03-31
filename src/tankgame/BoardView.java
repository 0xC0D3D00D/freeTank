
package tankgame;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Mohammad Hossein Heydari <mdh.heydari@gmail.com>
 */
public class BoardView extends JFrame implements ActionListener {
    private JButton Blocks[][];
    private GridLayout boardLayout;
    private BorderLayout mainLayout;
    private Container container;
    private Icon explodedIcon;
    private Icon tankIcon;
    
    public BoardView(String boardName)
    {
        super(boardName);
        boardLayout = new GridLayout(10, 10, -5, -4);
        mainLayout = new BorderLayout();
        container = getContentPane();
        setLayout(boardLayout);
        
        Blocks = new JButton[10][10];
        for(int i=0;i<10;i++)
            for(int j=0;j<10;j++)
            {
                Blocks[i][j]=new JButton();
                add(Blocks[i][j]);
            }
        
        explodedIcon = new ImageIcon(getClass().getResource("Explosion.png"));
        tankIcon = new ImageIcon(getClass().getResource("TankRed.png"));
    }
    
    public void update(Board board)
    {
        for(int i=0;i<10;i++)
            for(int j=0;j<10;j++)
                switch(board.getPointType(i, j))
                {
                    case PointEmpty:
                        Blocks[i][j].setText("");
                        break;
                    case PointTank:
                        Blocks[i][j].setIcon(tankIcon);
                    break;
                    case PointMissed:
                        Blocks[i][j].setText("Missed");
                    break;
                    case PointDead:
                        Blocks[i][j].setText("Exploded");
                    default:
                        throw new UnknownError("gotten PointType is not exist!");
                }
                
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
