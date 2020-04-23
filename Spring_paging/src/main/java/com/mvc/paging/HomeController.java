package com.mvc.paging;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.paging.biz.EmpBiz;
import com.mvc.paging.dto.EmpDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private EmpBiz biz;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String selectList(Model model, int pageNum) {
		
		model.addAttribute("pageNum",pageNum);
		
		List<EmpDto> list = biz.selectList(pageNum);
		model.addAttribute("list", list);
		
		int count = biz.totalCount();
		model.addAttribute("count",count);
		
		int totalpage = biz.totalPage(pageNum);
		model.addAttribute("totalpage",totalpage);
		
		Map<String, Integer> makeGroupNum = biz.makeGroupNum(pageNum);
		int groupEnd = makeGroupNum.get("groupEnd");
		int groupStart = makeGroupNum.get("groupStart");
		int prevNum = makeGroupNum.get("prevNum");
		int nextNum = makeGroupNum.get("nextNum");
		
		model.addAttribute("groupStart", groupStart);
		model.addAttribute("groupEnd", groupEnd);
		model.addAttribute("prevNum", prevNum);
		model.addAttribute("nextNum", nextNum);
		
		
		System.out.println("pageNum : "+pageNum);
		System.out.println("count : "+count);
		System.out.println("totalpage : "+totalpage);
		System.out.println("groupEnd : "+groupEnd);
		System.out.println("groupStart : "+groupStart);
		System.out.println("prevNum : "+prevNum);
		System.out.println("nextNum : "+nextNum);
		
		return "list";
	}
	
	
}
