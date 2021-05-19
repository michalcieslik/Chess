package plansza;

public class Pozycja {
    private int x;
    private int y;


    public Pozycja(int xx, int yy) {
        this.x = xx;
        this.y = yy;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
