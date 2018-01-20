package com.javalec.spring_pjt_board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.spring_pjt_board.command.BCommand;
import com.javalec.spring_pjt_board.command.BContentCommand;
import com.javalec.spring_pjt_board.command.BDeleteCommand;
import com.javalec.spring_pjt_board.command.BListCommand;
import com.javalec.spring_pjt_board.command.BModifyCommand;
import com.javalec.spring_pjt_board.command.BReplayCommand;
import com.javalec.spring_pjt_board.command.BReplayViewCommand;
import com.javalec.spring_pjt_board.command.BWriteCommand;

@Controller
public class BController {

	//각자작업을 시킬때 한번에 묶는거
	BCommand command;
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		
		command=new BListCommand();
		command.execute(model);
		
		return"list";
	}
	
	@RequestMapping("/write_view")//작성하는 화면  //작성하는 동작을 하는 것이아니라 작성하는 화면이다
	public String write_view(Model model) {
		System.out.println("write_view()");
		
		return "write_view";
		
	}
	
	@RequestMapping("/write")//실제로 버튼을 누느면 작성이되눈곳
	public String write(HttpServletRequest request,Model model) {  //http를 왜받냐면? 작성한글이 글에 폼안데 데이터를 받기위해서
		System.out.println("write()");
		
		model.addAttribute("request",request); //서비스에서는 작업이 없으니 model에다 넣는다.
		command= new BWriteCommand();  //컨텐츠에 맞는 DAO가 실행
		command.execute(model);//
		
		return"redirect:list"; //컨트롤로에서 다시 리스트를 가는거 리다이렉트
		                       //
	}
	
	@RequestMapping("/content_view")//컨텐츠를 보는 뷰
	public String content_view(HttpServletRequest request,Model model) {
		System.out.println("content_view()");
		
		model.addAttribute("request",request);
		command= new BContentCommand();  //컨텐츠에 맞는 DAO가 실행
		command.execute(model);
		
		return"content_view";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/modify")//수정하는부분 이니깐
	public String modify(HttpServletRequest request,Model model) {
		System.out.println("modify()");
		
		model.addAttribute("request",request);
		command= new BModifyCommand();
		command.execute(model);
		
		return"redirect:list"; //컨트롤로에서 다시 리스트를 가는거 리다이렉트
	}
	
	@RequestMapping("/reply_view")//답변을 보는곳
	public String reply_view(HttpServletRequest request,Model model) {
		System.out.println("/reply_view()");
		
		model.addAttribute("request",request);
		command= new BReplayViewCommand();  //컨텐츠에 맞는 DAO가 실행
		command.execute(model);
		
		return"reply_view";
	}
	
	
	@RequestMapping("/reply")//답변을 보는곳
	public String reply(HttpServletRequest request,Model model) {
		System.out.println("reply()");
		
		model.addAttribute("request",request);
		command= new BReplayCommand();  //컨텐츠에 맞는 DAO가 실행
		command.execute(model);
		
		return"redirect:list"; //컨트롤로에서 다시 리스트를 가는거 리다이렉트
	}
	
	
	@RequestMapping("/delete")//삭제하는 기능
	public String delete(HttpServletRequest request,Model model) {
		System.out.println("reply()");
		
		model.addAttribute("request",request);
		command= new BDeleteCommand();  //컨텐츠에 맞는 DAO가 실행
		command.execute(model);
		
		return"redirect:list"; //컨트롤로에서 다시 리스트를 가는거 리다이렉트
	}
	
	
	
	
}
