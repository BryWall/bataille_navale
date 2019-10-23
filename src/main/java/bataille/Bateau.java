package bataille;

public class Bateau {
    private int taille;
    private int x;
    private int y;
    private int pv;
    private String orientation;

    public Bateau(int taille, int x, int y, String orientation){
        this.taille = taille;
        this.pv = taille;
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
    public int getPV(){
        return this.pv;
    }

    public boolean isFlowed(){
        return this.pv == 0;
    }

    public void attacked(){
        this.pv--;
        this.touched();
        if(this.pv == 0)
            this.flowing();
    }

    private void flowing() {
        System.out.println("Coulé !");
    }

    private void touched() {
        System.out.println("Touché !");
    }

    public String getOrientation() {
        return this.orientation;
    }





}