import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class Obsticle{

    private JLabel obsticle;

    public Obsticle(int xpos, int ypos,int height, int width,JFrame frame){
        obsticle = new JLabel("");
        obsticle.setSize(width,height);
        obsticle.setBackground(Color.BLACK);
        obsticle.setOpaque(true);
        obsticle.setLocation(xpos,ypos);
        frame.add(obsticle);
        obsticle.setVisible(true);
    }
    public int getY(){
        return obsticle.getY();
    }
    public int getX(){
        return obsticle.getX();
    }
    public int getWidth(){
        return obsticle.getWidth();
    }

    public Report colisionInfo(int x, int y,int size){
        Report report = new Report(false,0);
        int leftX = obsticle.getX();
        int topY = obsticle.getY();
        int rightX = obsticle.getX()+obsticle.getWidth();
        int bottomY = obsticle.getY()+obsticle.getHeight();
        if(x+size>obsticle.getX()&&x<obsticle.getX()+obsticle.getWidth()&&y<obsticle.getY()+obsticle.getHeight()&&y+size>obsticle.getY()){
            report.setColiding(true);
            //System.out.println("test");
        }
        if(report.isColiding()){
            if(y<bottomY&&y>topY) report.setSide(Report.RIGHT);
            else report.setSide(Report.LEFT);
        }
        return report;
    }
}