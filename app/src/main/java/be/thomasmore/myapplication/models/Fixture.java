package be.thomasmore.myapplication.models;

public class Fixture {
    private String id;
    private String time;
    private String home_team;
    private String away_team;

    public Fixture() {

    }

    public Fixture(String id, String time, String home_team, String away_team) {
        this.id = id;
        this.time = time;
        this.home_team = home_team;
        this.away_team = away_team;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHome_team() {
        return home_team;
    }

    public void setHome_team(String home_team) {
        this.home_team = home_team;
    }

    public String getAway_team() {
        return away_team;
    }

    public void setAway_team(String away_team) {
        this.away_team = away_team;
    }
}
