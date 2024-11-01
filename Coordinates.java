package simulation;

import java.util.Objects;
import java.util.Set;

public class Coordinates {
    public final Integer row;
    public final Integer column;

    public Coordinates(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }

    public Coordinates shift (CoordinatesShift shift) {
        return new Coordinates(this.row + shift.rowShift, this.column + shift.columnShift);
    }

    public boolean canShift(CoordinatesShift shift){
        int r = row + shift.rowShift;
        int c = column + shift.columnShift;
        if ((r<0)|| (r>15)) return false;
        if ((c<0)|| (c>15)) return false;

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(row, that.row) && Objects.equals(column, that.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
