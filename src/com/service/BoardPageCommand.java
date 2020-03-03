package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.BoardDAO;
import com.entity.PageTO;

public class BoardPageCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String page = "";
		int curPage = 1; //현재 페이지
		
		if(request.getParameter("curPage") != null) {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		BoardDAO dao = new BoardDAO();
		PageTO list = dao.page(curPage);
		
		int perPage = list.getPerPage();
		int totalCount = list.getTotalCount();
		
		int totalPage = totalCount / perPage; // 보여줄 페이지 번호 갯수
		if(totalCount % perPage != 0) {
			totalPage++;
		}
		
		for(int i = 0; i <= totalPage; i++) {
			if(curPage == i) {
				page+= "<span id='pg'>" + i + "</span>";
			}else {
				page+= "<a href='list.do?curPage= " + i + ">" + i + "</a>&nbsp;";
			} //end if
		}
		request.setAttribute("list", list.getList());
		request.setAttribute("page", list);
		request.setAttribute("pg", page);
	}
	
}
