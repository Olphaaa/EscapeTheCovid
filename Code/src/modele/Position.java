package modele;

public class Position {
    private float x;
    private float y;

    private final float MINX = 45;
    private final float MAXX = 1000-80;

    private final float MINY = 45;
    private final float MAXY = 710-100;

    public Position(float x, float y){
        this.x=x;
        this.y=y;
    }

    public void setPosition(float x, float y){
        this.x=x;
        this.y=y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
