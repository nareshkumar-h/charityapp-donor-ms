package com.revature.charityappdonorms.dto;


import java.time.LocalDate;


import lombok.Data;

@Data
public class DonorDto {
private int id;
	
	private int userId;
	
	private int requesId;
	
	private double amount;
	
	private LocalDate createDate=LocalDate.now();
	
	private LocalDate updateDate=LocalDate.now();
	
}
