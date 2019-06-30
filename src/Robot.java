public class Robot { //class of robot to store the coordinates of robot and the direction
    private int x; // the x position
    private int y; // the y position
    private String d; //face direction

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setD(String d){
        this.d = d;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public String getD(){
        return d;
    }

}
