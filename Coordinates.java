package Simulation;

import java.util.Objects;

public class Coordinates {
    public final Integer vert;
    public final Integer hori;


    public Coordinates(Integer vert, Integer hori) {
        this.vert = vert;
        this.hori = hori;
    }

    public Coordinates shift(CoordinatesShift shift){
        return new Coordinates(this.vert+shift.vertShift,this.hori+shift.horiShift);
    }

    public boolean canShift(CoordinatesShift shift) {
        int v = vert + shift.vertShift;
        int h = hori + shift.horiShift;

        if ((v<1) || (v>10)) return false;
        if ((h<1) || (h>10)) return false;

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(vert, that.vert) && Objects.equals(hori, that.hori);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vert, hori);
    }

    @Override
    public String toString() {
        return String.valueOf(vert) + String.valueOf(hori);
    }
}
