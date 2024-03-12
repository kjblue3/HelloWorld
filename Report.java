public class Report {
    private boolean coliding;
    private int side;
    public static final int LEFT = 1;
    public static final int TOP = 2;
    public static final int RIGHT = 3;
    public static final int BOTTOM = 4;



    public Report(boolean c, int s){
        coliding = c;
        side = s;
    }

    public void setColiding(boolean coliding) {
        this.coliding = coliding;
    }
    public void setSide(int side) {
        this.side = side;
    }
    public boolean isColiding() {
        return coliding;
    }
    public int getSide() {
        return side;
    }
    
}
