package Composition;

public class Bed extends Furniture {

    public enum BedType { SINGLE, DOUBLE, SOFA }

    private BedType bedType;

    public Bed(String material, BedType bedType) {
        super("Bed", material);
        this.bedType = bedType;

        if (bedType == BedType.SOFA)
            this.name = "Sofa";
    }

    public Bed(BedType bedType) {
        super("Bed", "wood+textile");
        this.bedType = bedType;

        if (bedType == BedType.SOFA)
            this.name = "Sofa";
    }

    @Override
    public String toString() {
        return super.toString() + ", type: " + bedType;
    }
}
