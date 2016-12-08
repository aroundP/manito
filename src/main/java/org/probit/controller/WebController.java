package org.probit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
  * WebController
  *
  * @author sunghyun
  * @since 2016. 12. 05.
  */
@Controller
public class WebController {
	@RequestMapping("/")
	public String addRoomPage() {
		return "create";
	}

	@RequestMapping("/loginPage")
	public String loginPage() {
		return "login";
	}

}
