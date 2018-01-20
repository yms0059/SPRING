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

	//�����۾��� ��ų�� �ѹ��� ���°�
	BCommand command;
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		
		command=new BListCommand();
		command.execute(model);
		
		return"list";
	}
	
	@RequestMapping("/write_view")//�ۼ��ϴ� ȭ��  //�ۼ��ϴ� ������ �ϴ� ���̾ƴ϶� �ۼ��ϴ� ȭ���̴�
	public String write_view(Model model) {
		System.out.println("write_view()");
		
		return "write_view";
		
	}
	
	@RequestMapping("/write")//������ ��ư�� ������ �ۼ��̵Ǵ���
	public String write(HttpServletRequest request,Model model) {  //http�� �ֹ޳ĸ�? �ۼ��ѱ��� �ۿ� ���ȵ� �����͸� �ޱ����ؼ�
		System.out.println("write()");
		
		model.addAttribute("request",request); //���񽺿����� �۾��� ������ model���� �ִ´�.
		command= new BWriteCommand();  //�������� �´� DAO�� ����
		command.execute(model);//
		
		return"redirect:list"; //��Ʈ�ѷο��� �ٽ� ����Ʈ�� ���°� �����̷�Ʈ
		                       //
	}
	
	@RequestMapping("/content_view")//�������� ���� ��
	public String content_view(HttpServletRequest request,Model model) {
		System.out.println("content_view()");
		
		model.addAttribute("request",request);
		command= new BContentCommand();  //�������� �´� DAO�� ����
		command.execute(model);
		
		return"content_view";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/modify")//�����ϴºκ� �̴ϱ�
	public String modify(HttpServletRequest request,Model model) {
		System.out.println("modify()");
		
		model.addAttribute("request",request);
		command= new BModifyCommand();
		command.execute(model);
		
		return"redirect:list"; //��Ʈ�ѷο��� �ٽ� ����Ʈ�� ���°� �����̷�Ʈ
	}
	
	@RequestMapping("/reply_view")//�亯�� ���°�
	public String reply_view(HttpServletRequest request,Model model) {
		System.out.println("/reply_view()");
		
		model.addAttribute("request",request);
		command= new BReplayViewCommand();  //�������� �´� DAO�� ����
		command.execute(model);
		
		return"reply_view";
	}
	
	
	@RequestMapping("/reply")//�亯�� ���°�
	public String reply(HttpServletRequest request,Model model) {
		System.out.println("reply()");
		
		model.addAttribute("request",request);
		command= new BReplayCommand();  //�������� �´� DAO�� ����
		command.execute(model);
		
		return"redirect:list"; //��Ʈ�ѷο��� �ٽ� ����Ʈ�� ���°� �����̷�Ʈ
	}
	
	
	@RequestMapping("/delete")//�����ϴ� ���
	public String delete(HttpServletRequest request,Model model) {
		System.out.println("reply()");
		
		model.addAttribute("request",request);
		command= new BDeleteCommand();  //�������� �´� DAO�� ����
		command.execute(model);
		
		return"redirect:list"; //��Ʈ�ѷο��� �ٽ� ����Ʈ�� ���°� �����̷�Ʈ
	}
	
	
	
	
}
