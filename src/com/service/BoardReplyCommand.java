package com.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.BoardDAO;
import com.entity.BoardDTO;
public class BoardReplyCommand implements BoardCommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		if(request.getParameter("num") != null) {
			BoardDTO dto = new BoardDTO();
			dto.setNum(Integer.parseInt(request.getParameter("num")));
			dto.setTitle(request.getParameter("title"));
			dto.setAuthor(request.getParameter("author"));
			dto.setContent(request.getParameter("content"));
			dto.setRepRoot(Integer.parseInt(request.getParameter("repRoot")));
			dto.setRepIndent(Integer.parseInt(request.getParameter("repIndent")));
			dto.setRepStep(Integer.parseInt(request.getParameter("repStep")));
			dto.setPasswd(request.getParameter("passwd"));
			
			BoardDAO dao = new BoardDAO();
			dao.reply(dto);
		}
	}
}
