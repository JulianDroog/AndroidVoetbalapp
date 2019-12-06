package be.thomasmore.myapplication.models;

public class Competitie {
    private int id;
    private String name;
    private String img_name;

    public Competitie() {
    }

    public Competitie(int id, String name, String img_name) {
        this.id = id;
        this.name = name;
        this.img_name = img_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg_name() {
        return img_name;
    }

    public void setImg_name(String img_name) {
        this.img_name = img_name;
    }

    @Override
    public String toString() {
        return name;
    }
}
