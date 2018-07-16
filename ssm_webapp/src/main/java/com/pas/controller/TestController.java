package com.pas.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pas.dao.domain.User;
import com.pas.service.IUsersService;

@Controller
public class TestController {

	@Resource(name = "usersService")
	private IUsersService usersService;

	@RequestMapping(value = "/doTest.do")
	public String doTest() {

		User user = new User();
		user.setCode("pandy");
		user.setEmail("afasdf");
		user.setPassword("pandy");
		user.setState("001");
		user.setCreateBy("01");
		user.setCreateDatetime(new Date());
		user.setModifyBy("001");
		user.setModifyDatetime(new Date());
		usersService.saveUser(user);

		user = usersService.queryUsersById(1);
		user = usersService.queryUsersByName("pandy");

		System.out.println("Test success.......");
		return "success";
	}
}
