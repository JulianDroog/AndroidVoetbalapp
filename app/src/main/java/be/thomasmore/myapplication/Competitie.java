package be.thomasmore.myapplication;

public class Competitie {
    private String name;
    private String img_name;

    public Competitie() {
    }

    public Competitie(String name, String img_name) {
        this.name = name;
        this.img_name = img_name;
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
