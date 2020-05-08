package com.nineleaps.model;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;

public class BillPaymentByCreditCardDetailsEditor extends PropertyEditorSupport 
{
	@Override
	public String getAsText() {
		
		BillPaymentByCreditCardDetails byCreditCardDetails = (BillPaymentByCreditCardDetails) getValue();
		
		return byCreditCardDetails == null ? "" : byCreditCardDetails.getRawCardNumber();
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		if(StringUtils.isEmpty(text))
		{
			setValue(null);
		}
		else
		{
			BillPaymentByCreditCardDetails cardDetails = new BillPaymentByCreditCardDetails();
			cardDetails.setRawCardNumber(text);
			
			String cardNo = text.replaceAll("-", "");
			
			if(cardNo.length() != 16)
			{
				throw new IllegalArgumentException(
		                  "Credit card format should be xxxx-xxxx-xxxx-xxxx");
			}
			
			try
			{
				cardDetails.setBankIdNo(Integer.valueOf(cardNo.substring(0, 6)));
				cardDetails.setAccountNo( Integer.valueOf(cardNo.substring(6, cardNo.length() - 1)) );
				cardDetails.setCheckCode( Integer.valueOf(cardNo.substring(cardNo.length() - 1)) );
				
		     } catch (NumberFormatException e) {
		                throw new IllegalArgumentException(e);
			}
		
			setValue(cardDetails);
		}
	}
}
