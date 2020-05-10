package ca.qc.bdeb.info202;

public class Chlorophylle {
    
    private int chlorophylle;
    private int capital;
    private int pointVictoire;

    public Chlorophylle(int chlorophylle, int capital, int pointVictoire) {
        this.chlorophylle = chlorophylle;
        this.capital = capital;
        this.pointVictoire = pointVictoire;
    }

    

    public void nombreChlorophylle(){
    chlorophylle = chlorophylle + capital;
        System.out.println("Capital = " + capital);
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public int getCapital() {
        return capital;
    }
    
    public int getPointVictoire(){
    return pointVictoire;
    }

    public void setPointVictoire(int pointVictoire) {
        this.pointVictoire = pointVictoire;
    }
    
    
}
