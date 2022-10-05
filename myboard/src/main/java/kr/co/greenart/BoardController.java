package kr.co.greenart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService service;
	
//	@ModelAttribute
//	public Article testArticle() {
//		return new Article(100, "테스트 제목", "테스트 글쓴이");
//	}
	
//	@GetMapping("/board")
	@GetMapping
	public String boardMain(Model model) {
//		model.addAttribute("article", new Article(100, "테스트 제목", "테스트 글쓴이"));
		model.addAttribute("article", service.getAll().get(0));
		return "board";
	}
	
	@GetMapping("/write")
	public String writeForm() {
		return "writeForm";
	}
	
	@PostMapping("/write")
	public String write(Article a) {
//		throw new UnsupportedOperationException(a.getTitle() + "," + a.getWriter());
		service.write(a);
		return "redirect:/";
	}
}
