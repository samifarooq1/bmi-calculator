package com.adroit.bmi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adroit.bmi.model.BmiResult;
import com.adroit.bmi.service.BmiCalculationService;

@RestController
@RequestMapping("/api/bmi")
public class BmiController {

    private final BmiCalculationService bmiCalculationService;

    @Autowired
    public BmiController(BmiCalculationService bmiCalculationService) {
        this.bmiCalculationService = bmiCalculationService;
    }

    @GetMapping("/calculate")
    public BmiResult calculateBmi(
            @RequestParam double weight,
            @RequestParam double height,
            @RequestParam(required = false, defaultValue = "kg") String weightUnit,
            @RequestParam(required = false, defaultValue = "m") String heightUnit
    ) {
        return bmiCalculationService.calculateBmi(weight, height, weightUnit, heightUnit);
    }
    
    /*
     * 
     Examples of API calls:

/api/bmi/calculate?weight=70&height=170&weightUnit=kg&heightUnit=m
/api/bmi/calculate?weight=154&height=65&weightUnit=pounds&heightUnit=inches
     */
}