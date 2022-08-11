package com.yc.service;

import com.common.exceptionClass.*;
import com.yc.dao.MultiprimaryDAO;
import com.yc.dao.SingleprimaryDAO;
import com.yc.entity.Multiprimary;
import com.yc.entity.Singleprimary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    private final SingleprimaryDAO singleprimaryDAO;
    private final MultiprimaryDAO multiprimaryDAO;

    @Autowired
    public TestService(SingleprimaryDAO singleprimaryDAO, MultiprimaryDAO multiprimaryDAO) {
        this.singleprimaryDAO = singleprimaryDAO;
        this.multiprimaryDAO = multiprimaryDAO;
    }

    public List<Singleprimary> singleFindAll(){
        return singleprimaryDAO.findAll();
    }

    public Singleprimary singleFindByPrimary1(int primary1){
        return singleprimaryDAO.findByPrimary1(primary1);
    }

    public List<Singleprimary> singleFindByField1(String field1){
        return singleprimaryDAO.findByField1(field1);
    }

    public List<Singleprimary> singleInsert(List<Singleprimary> objList){
        return singleprimaryDAO.saveAll(objList);
    }

    public List<Singleprimary> singleSave(List<Singleprimary> objList){
        List<Singleprimary> result = new ArrayList<>();
        for(Singleprimary obj:objList){
            obj.setField1("xxx");
            result.add(singleprimaryDAO.save(obj));
        }
        return result;
    }

    public void singleDelete(List<Singleprimary> objList){
        singleprimaryDAO.deleteAll(objList);
    }

    public List<Multiprimary> multiFindAll(){
        return multiprimaryDAO.findAll();
    }

    public List<Multiprimary> multiFindByPrimary1(int primary1){
        return multiprimaryDAO.findByPrimary1(primary1);
    }

    public List<Multiprimary> multiInsert(List<Multiprimary> objList){
        return multiprimaryDAO.saveAll(objList);
    }

    public List<Multiprimary> multiSave(List<Multiprimary> objList){
        return multiprimaryDAO.saveAll(objList);
    }

    public void exceptionTestFail(){
        throw new DBException("DB Error");
    }

    public List<Multiprimary> exceptionTestSuccess(){
        return multiprimaryDAO.findAll();
    }
}
