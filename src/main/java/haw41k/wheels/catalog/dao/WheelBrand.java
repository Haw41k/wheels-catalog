package haw41k.wheels.catalog.dao;

import java.util.Objects;

public class WheelBrand {
    private int id;
    private String name;

    public WheelBrand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WheelBrand that = (WheelBrand) o;
        return id == that.id && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "WheelBrand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
