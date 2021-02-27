package com.example.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.blog.model.Post;
import com.example.blog.service.api.PostServiceApi;

@Controller
public class PostController {
	
	@Autowired
	private PostServiceApi postServiceApi;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list",postServiceApi.getAll());
				
		return "index";
	}
	
	@GetMapping("/save/{ID}")
	public String showSave(@PathVariable("ID")Long ID,Model model) {
		if(ID !=null && ID !=0) {
			model.addAttribute("post",postServiceApi.get(ID));
		}else {
			model.addAttribute("post",new Post());
		}
		return "save";
	}
	
	@PostMapping("/save")
	public String save(Post post,Model model) {
		postServiceApi.save(post);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{ID}")
	public String delete(@PathVariable Long ID,Model model) {
		postServiceApi.deltete(ID);
		return "redirect:/";
	}
	
	
	
	

}
