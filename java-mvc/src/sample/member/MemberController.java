package sample.member;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sample.domain.Member;

@Controller
@RequestMapping("/member")
public class MemberController {

	//XML에서 주입하는 방식이 아닌, JAVA코드 상에서 Autowired 애노테이션으로 주입.
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/list") // member/list.jsp  .jsp를 붙인다는ㄱ ㅓㅅ은 
	public void list (Model model) {
		model.addAttribute("list", memberService.list());
	}
	
	@RequestMapping("/form")
	public void form(Model model) {
		model.addAttribute("member", new Member());
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String formSubmit(@Valid Member member, BindingResult result) {
		if(result.hasErrors())
			return "member/form";
		
		memberService.add(member);
		return "redirect:/app/member/list";
		
	}
	
	
}
