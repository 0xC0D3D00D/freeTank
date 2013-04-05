package tankgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static tankgame.PointType.PointDead;
import static tankgame.PointType.PointEmpty;
import static tankgame.PointType.PointMissed;
import static tankgame.PointType.PointTank;

/**
 *
 * @author Mohammad Hossein Heydari <mdh.heydari@gmail.com>
 */
public class ComputerBoardView extends BoardView {
    GameView gView;

    public ComputerBoardView(GameView gView) {
        super("Computer Board");
        this.gView=gView;
    }

    @Override
    public void update(Board board)
    {
        for(int i=0;i<10;i++)
            for(int j=0;j<10;j++)
                switch(board.getPointType(j, i))
                {
                    case PointEmpty:
                        Blocks[i][j].setText("");
                    break;
                    case PointTank:
                        Blocks[i][j].setText("");
                    break;
                    case PointMissed:
                        Blocks[i][j].setIcon(crossIcon);
                    break;
                    case PointDead:
                        Blocks[i][j].setIcon(explodedIcon);
    //                    default:
    //                        throw new UnknownError("gotten PointType is not exist!");
                }
    }
        
    @Override
    protected ActionListener createListener(int i, int j) {
        return new BlockAction(j, i) {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(!gView.shotComputerBlock(block.getX(), block.getY()))
                    return;
                
                if(gView.endCheck())
                    return;
                Point computerShotedPoint = gView.getSelectedAiShot();
                while(!gView.shotHumanBlock(computerShotedPoint.getX(), computerShotedPoint.getY()))
                    computerShotedPoint = gView.getSelectedAiShot();
                if(gView.endCheck())
                    return;
            }
        };
    }
}
