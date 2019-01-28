package com.DairyFarm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DairyFarmController {

	@RequestMapping(value = "/")
	public String getHomePage() {
		return "index";
	}

}