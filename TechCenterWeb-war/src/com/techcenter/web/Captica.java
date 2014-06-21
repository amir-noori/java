package com.techcenter.web;

import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaFactory;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;


public class Captica
{
	private ReCaptcha c;
	//private String remoteAddr;
	//private ReCaptchaImpl reCaptcha;
	
	public Captica() 
	{
		 c = ReCaptchaFactory.newReCaptcha("6Ld7edkSAAAAAIDB6Stv0eoFDKvLYLI9QECgqnuo", "6Ld7edkSAAAAAD6DYt65WY2ayigFXRX5-Av8n5oT", false);
		// remoteAddr = request.getRemoteAddr();
		// reCaptcha = new ReCaptchaImpl();
	}
	
	public String showCaptica()
	{
		return c.createRecaptchaHtml(null, null);
	}
}