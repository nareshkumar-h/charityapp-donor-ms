package com.revature.charityappdonorms.validator;



import org.springframework.stereotype.Component;

import com.revature.charityappdonorms.dto.DonorDto;
import com.revature.charityappdonorms.exception.ValidatorException;
import com.revature.charityappdonorms.util.MessageConstant;

@Component
public class DonorContributeValidator {
	
	public void contributeValidator(DonorDto donor) throws ValidatorException
	{
		int userId=donor.getUserId();
		int requestId=donor.getRequesId();
		double amount=donor.getAmount();

		if(userId == 0 || "".isBlank())
		{
			throw new ValidatorException(MessageConstant.INVALID_USERID);
		}
		if(requestId  == 0 || "".isBlank())
		{
			throw new ValidatorException(MessageConstant.INVALID_REQUESTID);
		}
		if(amount == 0|| "".isBlank())
		{
			throw new ValidatorException(MessageConstant.INVALID_AMOUNT);
		}
	}



}
