package be.thomasmore.voetbalapp2.models;

public class Stats {
    private int home_possesion;
    private int away_possesion;
    private int home_attempts;
    private int away_attempts;
    private int home_ontarget;
    private int away_ontarget;
    private int home_yellowcard;
    private int away_yellowcard;
    private int home_redcard;
    private int away_redcard;

    public Stats() {

    }

    public Stats(int home_possesion, int away_possesion, int home_attempts, int away_attempts, int home_ontarget, int away_ontarget, int home_yellowcard, int away_yellowcard, int home_redcard, int away_redcard) {
        this.home_possesion = home_possesion;
        this.away_possesion = away_possesion;
        this.home_attempts = home_attempts;
        this.away_attempts = away_attempts;
        this.home_ontarget = home_ontarget;
        this.away_ontarget = away_ontarget;
        this.home_yellowcard = home_yellowcard;
        this.away_yellowcard = away_yellowcard;
        this.home_redcard = home_redcard;
        this.away_redcard = away_redcard;
    }

    public int getHome_possesion() {
        return home_possesion;
    }

    public void setHome_possesion(int home_possesion) {
        this.home_possesion = home_possesion;
    }

    public int getAway_possesion() {
        return away_possesion;
    }

    public void setAway_possesion(int away_possesion) {
        this.away_possesion = away_possesion;
    }

    public int getHome_attempts() {
        return home_attempts;
    }

    public void setHome_attempts(int home_attempts) {
        this.home_attempts = home_attempts;
    }

    public int getAway_attempts() {
        return away_attempts;
    }

    public void setAway_attempts(int away_attempts) {
        this.away_attempts = away_attempts;
    }

    public int getHome_ontarget() {
        return home_ontarget;
    }

    public void setHome_ontarget(int home_ontarget) {
        this.home_ontarget = home_ontarget;
    }

    public int getAway_ontarget() {
        return away_ontarget;
    }

    public void setAway_ontarget(int away_ontarget) {
        this.away_ontarget = away_ontarget;
    }

    public int getHome_yellowcard() {
        return home_yellowcard;
    }

    public void setHome_yellowcard(int home_yellowcard) {
        this.home_yellowcard = home_yellowcard;
    }

    public int getAway_yellowcard() {
        return away_yellowcard;
    }

    public void setAway_yellowcard(int away_yellowcard) {
        this.away_yellowcard = away_yellowcard;
    }

    public int getHome_redcard() {
        return home_redcard;
    }

    public void setHome_redcard(int home_redcard) {
        this.home_redcard = home_redcard;
    }

    public int getAway_redcard() {
        return away_redcard;
    }

    public void setAway_redcard(int away_redcard) {
        this.away_redcard = away_redcard;
    }
}
