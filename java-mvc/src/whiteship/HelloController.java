package whiteship;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello(@RequestParam String name, Model model) { // GET요청 name으로 받음(의미 없는게 아님). 
		
		model.addAttribute("hello","HELLO " + name); // jsp에서 사용할 hello 라는 변수.
		return "/WEB-INF/views/Hello.jsp"; // application내 view 경로.
		
	}
}
