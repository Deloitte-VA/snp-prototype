package com.github.jlgrock.snp.domain.sample;
/**
 * 
 * Returns the minimum and maximum values from the input assertion values. This method is used to obtain 
 * the minimum and maximum values from the given assertion values. The assertion values for an encounter 
 * are provided as the input parameter (argument) to this method.
 */
public class MinMaxAssertionValue {
	private Long min;
	private Long max;
	
	//Getters and Setters
	public Long getMin() {
		return min;
	}
	public void setMin(final Long pmin) {
		this.min = pmin;
	}
	public Long getMax() {
		return max;
	}
	public void setMax(final Long pmax) {
		this.max = pmax;
	}

}

