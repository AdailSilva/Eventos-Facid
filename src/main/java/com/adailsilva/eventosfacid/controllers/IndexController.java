package com.adailsilva.eventosfacid.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author AdailSilva
 */

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

}