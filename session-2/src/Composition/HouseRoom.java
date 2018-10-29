package Composition;

import java.util.ArrayList;

public class HouseRoom {

    ArrayList<Furniture> furniture;
    ArrayList<Usable> usables;

    String name = "Living Room";

    public HouseRoom() {
        furniture = new ArrayList<>();
        usables = new ArrayList<>();
    }

    public HouseRoom(String name) {
        this(); // Bad tho, anti-pattern
        this.name = name;
    }

    public ArrayList<Furniture> getFurniture() {
        return furniture;
    }

    public void addFurniture(Furniture furniture) {
        this.furniture.add(furniture);
    }

    public ArrayList<Usable> getUsables() {
        return usables;
    }

    public void addUsable(Usable usable) {
        usables.add(usable);
    }

    public void printFurniture() {
        System.out.println("Furnitures in house: {");
        for (Furniture f : furniture) {
            System.out.println("<" + f + ">");
        }
        System.out.println("}");
    }

    public void printUsables() {
        System.out.println("Usables in house: {");
        for (Usable usable : usables) {
            System.out.println("|" + usable + "|");
        }
        System.out.println("}");
    }

    @Override
    public String toString() {
        return "[" + getClass().getName() + "] " +
                "name: " + name + ", " +
                furniture.size() + " furniture, " +
                usables.size() + "usables";
    }

    public static void testHouseRoom() {
        HouseRoom houseRoom = new HouseRoom() {{
           addFurniture(new Bed(Bed.BedType.DOUBLE));
           addFurniture(new Table(Table.TableSize.SMALL, Table.TableShape.ROUND));

           addUsable(new TV(TV.TVType.LED));
           addUsable(new Electronic("Computer"));

           printFurniture();
           printUsables();
        }};
    }
}
