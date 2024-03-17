package Silmulation;

import java.util.Objects;

public class Coordinates {
    public final Hori hori;
    public final Integer vert;

    public Coordinates(Hori hori, Integer vert) {
        this.hori = hori;
        this.vert = vert;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(hori, that.hori) && Objects.equals(vert, that.vert);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hori, vert);
    }
}
