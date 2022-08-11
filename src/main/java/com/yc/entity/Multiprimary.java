package com.yc.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(MultiprimaryPK.class)
public class Multiprimary {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "primary1", nullable = false)
    private int primary1;
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "primary2", nullable = false, length = 45)
    private String primary2;
    @Basic
    @Column(name = "field1", nullable = true, length = 45)
    private String field1;
    @Basic
    @Column(name = "field2", nullable = true, length = 45)
    private String field2;

    public int getPrimary1() {
        return primary1;
    }

    public void setPrimary1(int primary1) {
        this.primary1 = primary1;
    }

    public String getPrimary2() {
        return primary2;
    }

    public void setPrimary2(String primary2) {
        this.primary2 = primary2;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Multiprimary that = (Multiprimary) o;
        return primary1 == that.primary1 && Objects.equals(primary2, that.primary2) && Objects.equals(field1, that.field1) && Objects.equals(field2, that.field2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primary1, primary2, field1, field2);
    }
}
