package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping(value = "/distilleries")
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(name = "/distilleries")
    public ResponseEntity<List<Distillery>> getDistilleriesForRegion(
            @RequestParam(name = "region", required = false) String region
    ) {
        if (region != null){
            return new ResponseEntity<>(distilleryRepository.findByRegion(region), HttpStatus.OK);
        }
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }

//    @GetMapping(name = "/distilleries/whiskies")
//    public ResponseEntity<List<Distillery>> findDistilleriesByWhisky(
//            @RequestParam(name = "age") Integer age
//    ) {
//        return new ResponseEntity<>(distilleryRepository.findByWhiskyAge(age), HttpStatus.OK);
//    }

}
