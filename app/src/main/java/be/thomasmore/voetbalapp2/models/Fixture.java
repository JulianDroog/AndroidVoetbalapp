package be.thomasmore.voetbalapp2.models;

public class Fixture {
    private String id;
    private String time;
    private String date;
    private String home_name;
    private String away_name;
    private String competitionId;

    public Fixture() {

    }

    public Fixture(String id, String time, String date, String home_name, String away_name, String competitionId) {
        this.id = id;
        this.time = time;
        this.date = date;
        this.home_name = home_name;
        this.away_name = away_name;
        this.competitionId = competitionId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getHome_name() {
        return home_name;
    }

    public void setHome_name(String home_name) {
        this.home_name = home_name;
    }

    public String getAway_name() {
        return away_name;
    }

    public void setAway_name(String away_name) {
        this.away_name = away_name;
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }
}
