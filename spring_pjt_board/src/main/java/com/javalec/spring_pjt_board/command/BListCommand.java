package com.javalec.spring_pjt_board.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.javalec.spring_pjt_board.dao.BDao;
import com.javalec.spring_pjt_board.dto.BDto;

public class BListCommand implements BCommand {//command->service로 네이밍 할것

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		BDao dao=new BDao();
		ArrayList<BDto>dtos=dao.list();
		
		model.addAttribute("list",dtos);
		
	}

}
