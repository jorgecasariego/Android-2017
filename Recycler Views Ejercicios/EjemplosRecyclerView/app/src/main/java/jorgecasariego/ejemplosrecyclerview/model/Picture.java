package jorgecasariego.ejemplosrecyclerview.model;

/**
 * Created by jorgecasariego on 4/8/17.
 */

public class Picture {
    private int image;
    private String name;

    public Picture(String name, int image) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
