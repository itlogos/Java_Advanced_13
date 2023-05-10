package ua.lviv.lgs.servlet;


import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.lviv.lgs.domain.Subscribe;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.SubscribeService;
import ua.lviv.lgs.service.MagazineService;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.SubscribeServiceImpl;
import ua.lviv.lgs.service.impl.MagazineServiceImpl;
import ua.lviv.lgs.service.impl.UserServiceImpl;



@WebServlet("/subscribe")
public class SubscribeController extends HttpServlet {
 
private	SubscribeService subscribeService = SubscribeServiceImpl.getSubscribeService();
private MagazineService magazineService = MagazineServiceImpl.getMagazineService();
private UserService userService = UserServiceImpl.getUserService(); 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String magazineId = request.getParameter("magazineId");
		Magazine magazine = magazineService.read(Integer.parseInt(magazineId));
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		User user = userService.read(userId);
		
		Subscribe subscribe = new Subscribe();
		subscribeService.create(subscribe);
		subscribe.setId(UUID.randomUUID().toString());
		subscribe.setMagazine(magazine);
		subscribe.setUser(user);
		subscribe.setSubscribeDate(new Date());
		
		
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subscribeId = request.getParameter("subscribeId");
		subscribeService.delete(Integer.parseInt(subscribeId));
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

}