package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CheckOutController {
	@RequestMapping(value={"/checkout"},method = RequestMethod.GET)
	public String defalut(ModelMap model)
	{
		
		return "checkout";
	}
}
