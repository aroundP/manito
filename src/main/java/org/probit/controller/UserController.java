package org.probit.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.probit.KakaoRestApiHelper;
import org.probit.domain.SessionUser;
import org.probit.domain.User;
import org.probit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
  * UserController
  *
  * @author sunghyun
  * @since 2016. 12. 07.
  */
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private KakaoRestApiHelper kakaoRestApiHelper;

	@RequestMapping("/users")
	@ResponseBody
	public List<User> findUserList() {
		List<User> userList = userService.findUserList();
		System.out.println(userList);
		return userList;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public void sessionSave(@RequestBody Map<String, Object> authObj, HttpSession session) throws IOException {
		SessionUser sessionUser = makeSessionUser(authObj);
		session.setAttribute("account", sessionUser);
		userService.addUser(new User(sessionUser));
	}

	private SessionUser makeSessionUser(Map<String, Object> authObj) {
		String accessToken = authObj.get("access_token").toString();
		kakaoRestApiHelper.setAccessToken(accessToken);
		return new SessionUser(kakaoRestApiHelper.me(), accessToken);
	}
	//
	//	@RequestMapping("/logout")
	//	@ResponseBody
	//	public void sessionRemove(HttpSession session) {
	//		session.removeAttribute("account");
	//		//System.out.println("session: "+session.getAttribute("account"));
	//	}
}
