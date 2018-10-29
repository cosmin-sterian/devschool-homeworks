package Composition;

public class Table extends Furniture {

    public enum TableSize { SMALL, MEDIUM, LARGE }
    public enum TableShape { ROUND, RECTANGLE }

    private TableSize tableSize;
    private TableShape tableShape;

    public Table(TableSize tableSize, TableShape tableShape) {
        super("Table", "wood");
        this.tableSize = tableSize;
        this.tableShape = tableShape;
    }

    public Table(String name, String material, TableSize tableSize, TableShape tableShape) {
        super(name, material);
        this.tableSize = tableSize;
        this.tableShape = tableShape;
    }

    public TableSize getTableSize() {
        return tableSize;
    }

    public void setTableSize(TableSize tableSize) {
        this.tableSize = tableSize;
    }

    public TableShape getTableShape() {
        return tableShape;
    }

    public void setTableShape(TableShape tableShape) {
        this.tableShape = tableShape;
    }

    @Override
    public String toString() {
        return super.toString() + ", size: " + tableSize + ", shape: " + tableShape;
    }
}
