package com.yc.dao;

import com.yc.entity.Singleprimary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingleprimaryDAO extends JpaRepository<Singleprimary, Integer> {

    Singleprimary findByPrimary1(int primary1);

    List<Singleprimary> findByField1(String field1);
}
