package bataille;

public class Bateau {
    private int taille;
    private int x;
    private int y;
    private String orientation;

    public Bateau(int taille, int x, int y, String orientation){
        this.taille = taille;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }


    public int getTaille(){
        return this.taille;
    }
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public String getOrientation(){
        return this.orientation;
    }





}