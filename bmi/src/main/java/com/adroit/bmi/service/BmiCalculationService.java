package com.adroit.bmi.service;


import org.springframework.stereotype.Service;

import com.adroit.bmi.model.BmiResult;

@Service
public class BmiCalculationService {

    public BmiResult calculateBmi(Double weight, Double height, String weightUnit, String heightUnit) {
        
    	if (weight== null || height == null) {
            throw new IllegalArgumentException("Weight and height are mandatory parameters.");
        }
    	// Convert weight and height to kilograms and meters if necessary
        double weightInKg = convertToKilograms(weight, weightUnit);
        double heightInMeters = convertToMeters(height, heightUnit);

        // BMI calculation logic
        double bmi = weightInKg / (heightInMeters * heightInMeters);

        // Determine BMI category
        String category = determineBmiCategory(bmi);

        // Create and return BmiResult object
        return new BmiResult(bmi, category);
    }

    private double convertToKilograms(double weight, String unit) {
        // Assuming weight is already in kilograms if the unit is not specified or is "kg"
        if ("pounds".equalsIgnoreCase(unit)) {
            // 1 pound = 0.453592 kilograms
            return weight * 0.453592;
        }
        return weight;
    }

    private double convertToMeters(double height, String unit) {
        // Assuming height is already in meters if the unit is not specified or is "m"
        if ("inches".equalsIgnoreCase(unit)) {
            // 1 inch = 0.0254 meters
            return height * 0.0254;
        }
        return height;
    }

    private String determineBmiCategory(double bmi) {
        // BMI categories are for illustrative purposes; adjust as needed
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal weight";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

}
