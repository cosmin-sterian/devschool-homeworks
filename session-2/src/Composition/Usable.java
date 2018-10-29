package Composition;

public interface Usable {

    public enum UsableType { ELECTRONIC, OTHER }

    String getName();
    void setName(String name);
    UsableType getType();
    void setType(UsableType usableType);

}
