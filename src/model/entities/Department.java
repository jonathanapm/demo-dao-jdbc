package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Department extends BasicClass implements Serializable {

    private static final long serialVersionUID = 1L;

    public Department(Integer id, String name) {
        super(id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                '}';
    }
}
