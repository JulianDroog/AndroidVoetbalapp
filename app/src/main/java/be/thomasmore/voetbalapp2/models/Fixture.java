package be.thomasmore.voetbalapp2.models;

public class Fixture {
    private Long id;
    private String time;
    private String date;
    private String home_name;
    private String away_name;

    public Fixture() {

    }

    public Fixture(Long id, String time, String date, String home_name, String away_name) {
        this.id = id;
        this.time = time;
        this.date = date;
        this.home_name = home_name;
        this.away_name = away_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
