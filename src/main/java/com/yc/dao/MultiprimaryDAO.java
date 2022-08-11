package com.yc.dao;

import com.yc.entity.Multiprimary;
import com.yc.entity.MultiprimaryPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MultiprimaryDAO extends JpaRepository<Multiprimary, MultiprimaryPK> {

    List<Multiprimary> findByPrimary1(int primary1);

}
