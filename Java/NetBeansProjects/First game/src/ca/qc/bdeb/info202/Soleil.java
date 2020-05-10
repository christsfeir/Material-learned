package ca.qc.bdeb.info202;

public class Soleil {

    public enum Position {
        Nord,
        Est,
        Sud,
        Ouest;
    }
    private Position position;
    private boolean phase1 = true;

    public Soleil(Position position) {
        this.position = position;
    }

    
    
    public Position getPosition(){
    return position;}

    public void setPhase1(boolean phase1) {
        this.phase1 = phase1;
    }
    
    public boolean getPhase(){
    return phase1;
    }
    



}
