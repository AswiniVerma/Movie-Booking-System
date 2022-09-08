package MovieTicket.MovieTicket.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import MovieTicket.MovieTicket.entity.Inox;
import MovieTicket.MovieTicket.entity.Movie;
import MovieTicket.MovieTicket.entity.Screen;
import MovieTicket.MovieTicket.entity.Show;
import MovieTicket.MovieTicket.entity.Ticket;
import MovieTicket.MovieTicket.service.ShowService;
import MovieTicket.MovieTicket.service.TicketService;

@Controller
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	private ShowService showservice;
	@Autowired
	private TicketService ticketservice;
	@Autowired
	ServletContext servletcontext;
	
	@RequestMapping("addshow/{id}")
	public ModelAndView addItem(@PathVariable("id") int id, Model model, HttpServletRequest request,
			@Valid @ModelAttribute("ticket") Ticket ticket ,BindingResult result,
			HttpSession session) throws Exception
	{
		Show	show=showservice.getById(id);
		
	
		model.addAttribute("show",  show);
		model.addAttribute("ticket", new Ticket());
		
	
		
	    return new ModelAndView( "ticket-form");
		
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	public ModelAndView saveShow(HttpServletRequest request,@Valid @ModelAttribute("ticket") Ticket ticket ,Model model,BindingResult result,HttpSession session) throws Exception
	{
		
	System.out.println("Ticket"+ticket)	;
	if(ticket.getId()==null)	
	{
		ticket.setId(0);
	}
	if(ticket.getId()==0) 
	{
		  ticketservice.add(ticket); 
	}	               
	else
    {
    	ticketservice.update(ticket);
    }
    return new ModelAndView( "redirect:/ticket/list");
}	                
				

		        
	  
	    



	@RequestMapping("list")
	public ModelAndView list()
	{
		ModelAndView model=new ModelAndView();
		List<Ticket> tickets=ticketservice.getAll();
			model.addObject("tickets",tickets);
			model.setViewName("ticketlist");
			return model;
		}
	
	
	
		//mapping for delete item
		
		@RequestMapping(value="deleteticket/{id}")
		public String deleteTicket(@PathVariable("id") int id)
		{
			//get the item by id
			ticketservice.delete(id);
			
			return "redirect://ticket/list";
	}
}