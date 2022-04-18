package com.formacion.nttdata.hello.controller;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formacion.nttdata.hello.model.User;
import com.formacion.nttdata.hello.services.services;

@Controller

public class HomeController {

	/**
	 * 
	 * Simply selects the home view to render by returning its name.
	 * 
	 */
	/*@Autowired
	services servicio;*/

	@RequestMapping(value = "/", method = RequestMethod.GET)

	public String home(Locale locale, Model model) {

		//servicio.HomeService();
		System.out.println("Home Page Requested, locale = " + locale);

		Date date = new Date();

		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";

	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)

	public String user(@Validated User user, Model model, Locale locale) {

		System.out.println("User Page Requested"+user.getNumber());
		int number=user.getNumber();
		//metodo 1
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		date.setDate(date.getDate() + number);
		String formattedDate = dateFormat.format(date);
		
		///metodo 2
		Calendar calendar = Calendar.getInstance();
		Calendar fecha = new GregorianCalendar();
		int año = fecha.get(Calendar.YEAR);
		System.out.println("Fecha"+(calendar.get(fecha.DAY_OF_MONTH)+number));
		
		int dias= calendar.get(fecha.DAY_OF_MONTH)+number;
		int mes= calendar.get(fecha.MONTH);
		int ano= calendar.get(fecha.YEAR);
		String date2 = String.valueOf(dias)+'/'+ String.valueOf(mes)+'/'+ String.valueOf(ano);
		
		model.addAttribute("sumDaysTime", formattedDate);
		model.addAttribute("sumDaysTime2", date2);
		model.addAttribute("userName", user.getUserName());
		model.addAttribute("userSurname", user.getUserSurname());
		
		return "user";

	}
}