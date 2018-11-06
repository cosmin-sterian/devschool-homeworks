package Composition;

public class Furniture {

    protected String name;
    private String material;

    public Furniture(String name, String material) {
        this.name = name;
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "[" + getClass().getName() + "] Name: " + name + ", material: " + material;
    }
}
