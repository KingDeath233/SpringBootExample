package com.yc.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MultiprimaryPK implements Serializable {
    @Column(name = "primary1", nullable = false)
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int primary1;
    @Column(name = "primary2", nullable = false, length = 45)
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String primary2;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiprimaryPK that = (MultiprimaryPK) o;
        return primary1 == that.primary1 && Objects.equals(primary2, that.primary2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primary1, primary2);
    }
}
