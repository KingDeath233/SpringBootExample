package com.yc.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Singleprimary {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "primary1", nullable = false)
    private int primary1;
    @Basic
    @Column(name = "field1", nullable = true, length = 45)
    private String field1;

    public int getPrimary1() {
        return primary1;
    }

    public void setPrimary1(int primary1) {
        this.primary1 = primary1;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Singleprimary that = (Singleprimary) o;
        return primary1 == that.primary1 && Objects.equals(field1, that.field1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primary1, field1);
    }
}
