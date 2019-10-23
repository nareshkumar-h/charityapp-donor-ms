package com.revature.charityappdonorms.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.charityappdonorms.dto.DonorDto;
import com.revature.charityappdonorms.dto.Message;
import com.revature.charityappdonorms.exception.ServiceException;
import com.revature.charityappdonorms.service.DonorTransService;
import com.revature.charityappdonorms.validator.DonorContributeValidator;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/donorTransaction")
public class DonorTransController {

	@Autowired
	DonorTransService donorTransService;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DonorTransController.class);

	@PostMapping("/contribute")
	@ApiOperation(value = "Donorcontribute API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = DonorDto.class),
			@ApiResponse(code = 400, message = "Cannot able to Contribute ", response = Message.class) })
	//TODO: Convert Request Param to Request Body
	public ResponseEntity<?> contribute(@RequestParam("userId") int userId, @RequestParam("requestId") int requestId,
			@RequestParam("amountDonated") double amount)  {

	
		DonorDto donor= new DonorDto();

		donor.setUserId(userId);
		donor.setRequesId(requestId);
		donor.setAmount(amount);
	
		
		try {
			donorTransService.donorContribute(donor);
			return new ResponseEntity<>(donorTransService, HttpStatus.OK);
		}
		catch (ServiceException e)
		{
			LOGGER.error("Exception:", e);
			Message	message = new Message(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

	
}
