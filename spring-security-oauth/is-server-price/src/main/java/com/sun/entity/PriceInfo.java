package com.sun.entity;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 
 * @author jojo
 *
 */
@Data
public class PriceInfo {
	
	private Long id;
	
	private BigDecimal price;

}