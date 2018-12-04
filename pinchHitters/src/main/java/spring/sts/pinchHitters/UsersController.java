package spring.sts.pinchHitters;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.model.users.UsersDAO;
import spring.model.users.UsersDTO;

@Controller
public class UsersController {
	
	@Autowired
	private UsersDAO dao;
	
	@RequestMapping("/users/list")
	public String list(Map map) {
		
	}
}
