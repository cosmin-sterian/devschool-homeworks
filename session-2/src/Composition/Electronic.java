package Composition;

public class Electronic implements Usable {

    protected String name;
    private UsableType type;

    public Electronic(String name) {
        this.name = name;
        type = UsableType.ELECTRONIC;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public UsableType getType() {
        return type;
    }

    @Override
    public void setType(UsableType usableType) {
        type = usableType;
    }

    @Override
    public String toString() {
        return "[" + getClass().getName() + "] name: " + name + ", type: " + type;
    }
}
