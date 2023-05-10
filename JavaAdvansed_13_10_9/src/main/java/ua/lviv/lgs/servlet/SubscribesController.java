package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ua.lviv.lgs.domain.Subscribe;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.dto.SubscribeDto;
import ua.lviv.lgs.service.SubscribeService;
import ua.lviv.lgs.service.MagazineService;
import ua.lviv.lgs.service.impl.SubscribeServiceImpl;
import ua.lviv.lgs.service.impl.MagazineServiceImpl;


@WebServlet("/subscribes")
public class SubscribesController extends HttpServlet {
	 
	private	SubscribeService subscribeService = SubscribeServiceImpl.getSubscribeService();
	private MagazineService magazineService = MagazineServiceImpl.getMagazineService();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Subscribe> subscribes = subscribeService.readAll();
		Map<Integer, Magazine> idToMagazine = magazineService.readAllMap();
		List<SubscribeDto> listOfSubscribeDtos = map(subscribes, idToMagazine);
		
		String json = new Gson().toJson(listOfSubscribeDtos);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
	
	
	public List<SubscribeDto> map(List<Subscribe> subscribes, Map<Integer, Magazine> idToMagazine){

		return	subscribes.stream().map(subscribe->{
			SubscribeDto subscribeDto = new SubscribeDto();
			subscribeDto.subscribeId = subscribe.getId();
			subscribeDto.subscribeDate = subscribe.getSubscribeDate();
		   
			Magazine magazine = idToMagazine.get(subscribe.getMagazine());
		    subscribeDto.name = magazine.getName();
		    subscribeDto.description = magazine.getDescription();
		    subscribeDto.subscribePrice = magazine.getSubscribePrice();
			
			return subscribeDto;
		}).collect(Collectors.toList());
		
	} 
}
