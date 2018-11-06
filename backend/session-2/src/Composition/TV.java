package Composition;

public class TV extends Electronic {

    enum TVType { LCD, LED, OLED, PLASMA, OLD }

    private TVType tvType;

    public TV(TVType tvType) {
        super(tvType + " TV");
        this.tvType = tvType;
    }

    @Override
    public String toString() {
        return super.toString() + ", TV type: " + tvType;
    }
}
