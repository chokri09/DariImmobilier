package tn.dari.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.dari.entities.Response;
import tn.dari.services.StripeService;


@RestController
public class PayementController1 {
	@Value("${stripe.key.public}")
	private String API_PUBLIC_KEY;
	private StripeService stripeService;
	
	public PayementController1(StripeService stripeService) {
		this.stripeService = stripeService;
	}
	@PostMapping(value = "/payement/{email}/{token}")
	public  String PriceOfRent(@PathVariable String email,@PathVariable String token){
		
		return stripeService.createCharge(email, token,89989);	
	}
	@PostMapping("/create-payment/{email}/{token}")
	public @ResponseBody Response createCharge(@PathVariable String email, @PathVariable String token) {

		if (token == null) {
			return new Response(false, "Stripe payment token is missing. please try again later.");
		}

		String chargeId = stripeService.createCharge(email, token, 999);// 9.99 usd

		if (chargeId == null) {
			return new Response(false, "An error accurred while trying to charge.");
		}

		// You may want to store charge id along with order information

		return new Response(true, "Success your charge id is " + chargeId);
	}
	
}
