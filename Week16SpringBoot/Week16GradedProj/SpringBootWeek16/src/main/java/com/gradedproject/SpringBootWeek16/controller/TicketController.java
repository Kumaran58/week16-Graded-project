package com.gradedproject.SpringBootWeek16.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.gradedproject.SpringBootWeek16.Service.TicketService;
import com.gradedproject.SpringBootWeek16.model.TicketModel;

@Controller
public class TicketController {
	
	@Autowired
	TicketService s1;

	@RequestMapping("/")
	public String home(Model d1) {
		List<TicketModel>l1=s1.showAll();
		d1.addAttribute("ob", l1);
		return "home";	
	}
	
	@RequestMapping("/add")
	public String add() {
		return "add";	
	}
	
	@PostMapping("/insert-ticket")
	public String insert(@RequestParam String tickettitle,@RequestParam String shortdescription,@RequestParam String content,Model d1) {
		
		TicketModel t1=new TicketModel(0,tickettitle, shortdescription, content, LocalDate.now());
		s1.save(t1);
		List<TicketModel>l1=s1.showAll();
		d1.addAttribute("ob",l1);
		return "home";
	}
	
	@RequestMapping("/update-ticket")
	public String updateTic(@RequestParam int id,Model d1) {

		TicketModel l1=s1.fingById(id);
		d1.addAttribute("ob", l1);
		return "update";	
	}
	
	
	@PostMapping("/upd-tic")
	public String update(@RequestParam int id,@RequestParam String tickettitle,@RequestParam String shortdescription,@RequestParam String content,Model d1) {
		
		TicketModel t1=new TicketModel(id, tickettitle, shortdescription, content, LocalDate.now());
		s1.update(t1);
		List<TicketModel>l1=s1.showAll();
		d1.addAttribute("ob", l1);
		return "home";
	}

	@RequestMapping("/delete-ticket")
	public String delete(@RequestParam int id,Model d1) {
		
		TicketModel t1=new TicketModel(id, null, null, null, null);
		s1.delete(t1);
		List<TicketModel>l1=s1.showAll();
		d1.addAttribute("ob", l1);
		return "home";
	}
	
	@RequestMapping("/view")
	public String view(Model d1) {
		List<TicketModel>l1=s1.showAll();
		d1.addAttribute("ob", l1);
		return "home";	
	}
	
	@GetMapping("/view-ticket")
	public String view1(@RequestParam int id, Model data) {
		TicketModel t1=s1.fingById(id);
		data.addAttribute("ob", t1);
		return "ticketview";
	}
	
	
	@GetMapping("/search-ticket")
	public String search(@RequestParam String tickettitle, Model data) {
		List<TicketModel>t1=s1.filterByTitle(tickettitle);
		data.addAttribute("ob", t1);
		return "home";	
	}


}
