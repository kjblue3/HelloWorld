import javax.swing.JLabel;
import java.awt.*;

public class Player {
    private JLabel player;

    public Player(){
        player = new JLabel("");
        player.setSize(20,20);
        player.setBackground(new Color(0,0,255));
        player.setOpaque(true);
    }
    public JLabel getPlayer(){
        return player;
    }

}
