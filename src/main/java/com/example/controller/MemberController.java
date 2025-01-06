package com.example.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Member;
import com.example.repository.MemberDao;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/list")
	public String list(Model model) {
		ArrayList<Member> list = (ArrayList<Member>)memberDao.selectAll();
		model.addAttribute("list", list);
		return "member/list";
	}
	
	@GetMapping("/insert")
	public void insert() {}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute Member mem, Model model) {
		boolean result = memberDao.insertData(mem);
		
		if(result) {
			return "redirect:/member/list";
		}
		else {
			model.addAttribute("message", "입력 오류");
			return "member/insert";
		}
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("num") int num, Model model) {
		Member mem = memberDao.selectNum(num);
		model.addAttribute("mem", mem);
		return "member/update";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Member mem, Model model) {
		boolean result = memberDao.updateData(mem);
		
		if(result) {
			return "redirect:/member/list";
		}
		else {
			model.addAttribute("message", "수정 오류");
			return "member/update";
		}
	}
}













