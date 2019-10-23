package bataille;

import java.util.Objects;

public class Cell {
    protected Bateau bateau;
    protected int x;
    protected int y;
    protected boolean attacked;


    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        this.bateau = null;
        this.attacked = false;
    }


    public Cell(Bateau b, int x, int y){
        this.x = x;
        this.y = y;
        this.bateau = b;
        this.attacked = false;
    }


    public Bateau getBateau(){
        return this.bateau;
    }

    public void setBateau(Bateau b){
        this.bateau = b;
    }

    public void attacked(){
        if(null != this.bateau){
            this.bateau.attacked();
        }
        else{
            this.ploof();
        }
        this.attacked = true;
    }

    private void ploof() {
        System.out.println("Ploof !");
    }

    public boolean isAttacked() {
        return this.attacked;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public boolean hasBateau(){
        return ! Objects.isNull(this.bateau);
    }

    public String toString(){
        if(isAttacked()){
            if(hasBateau()){
                return "2";
            }
            return "3";
        }
        else{
            if(hasBateau()){
                return "1";
            }
            return "0";
        }
    }
    public String toStringHidden(){
        String str = this.toString();
        return (str.equals("1") ? "0" : str);
    }


}