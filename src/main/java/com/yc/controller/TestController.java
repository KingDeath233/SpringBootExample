package com.yc.controller;

import com.yc.entity.Multiprimary;
import com.yc.entity.Singleprimary;
import com.yc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/SingleFindAll")
    public List<Singleprimary> singleFindAll(){
        return testService.singleFindAll();
    }

    @GetMapping("/SingleFindByPrimary1")
    public Singleprimary singleFindByPrimary1(@RequestParam int primary1){
        return testService.singleFindByPrimary1(primary1);
    }

    @GetMapping("/SingleFindByField1")
    public List<Singleprimary> singleFindByField1(@RequestParam String field1){
        return testService.singleFindByField1(field1);
    }

    @Transactional
    @PostMapping("/SingleInsert")
    public List<Singleprimary> singleInsert(@RequestBody List<Singleprimary> objList){
        return testService.singleInsert(objList);
    }

    @Transactional
    @PutMapping("/SingleSave")
    public List<Singleprimary> singleSave(@RequestBody List<Singleprimary> objList){
        return testService.singleSave(objList);
    }

    @Transactional
    @DeleteMapping("/SingleDelete")
    public void singleDelete(@RequestBody List<Singleprimary> objList){
        testService.singleDelete(objList);
    }

    @GetMapping("/MultiFindAll")
    public List<Multiprimary> multiFindAll(){
        return testService.multiFindAll();
    }

    @GetMapping("/MultiFindByPrimary1")
    public List<Multiprimary> multiFindByPrimary1(int primary1){
        return testService.multiFindByPrimary1(primary1);
    }

    @PostMapping("/MultiInsert")
    public List<Multiprimary> multiInsert(@RequestBody List<Multiprimary> objList){
        return testService.multiInsert(objList);
    }

    @Transactional
    @PutMapping("/MultiSave")
    public List<Multiprimary> multiSave(@RequestBody List<Multiprimary> objList){
        return testService.multiSave(objList);
    }

    @GetMapping("/ExceptionTestFail")
    public void exceptionTestFail(){
        testService.exceptionTestFail();
    }

    @GetMapping("/ExceptionTestSuccess")
    public ResponseEntity exceptionTestSuccess(){
        return new ResponseEntity<>(generateResponseEntityBody(testService.exceptionTestSuccess(), "Success"), HttpStatus.OK);
    }

    private Map<String, Object> generateResponseEntityBody(Object content, String message){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", message);
        body.put("content",content);
        body.put("status", true);
        return body;
    }
}
