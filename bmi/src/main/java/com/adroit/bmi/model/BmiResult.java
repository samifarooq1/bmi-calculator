package com.adroit.bmi.model;

public class BmiResult {
	
	private double bmi;
    private String category;
    
    public BmiResult(double bmi, String category) {
        this.bmi = bmi;
        this.category = category;
    }
	public double getBmi() {
		return bmi;
	}
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	 @Override
	    public String toString() {
	        return "BmiResult{" +
	                "bmi=" + bmi +
	                ", category='" + category + '\'' +
	                '}';
	    }

}
