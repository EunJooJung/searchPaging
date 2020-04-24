package com.mvc.paging.biz;

import java.util.List;
import java.util.Map;

import com.mvc.paging.dto.EmpDto;

public interface EmpBiz {
	
	int pageCount = 10;		
	int groupSize = 5;		
	
	public int totalCount();	
	
	public int totalCount(String searchKeyword);
	
	public List<EmpDto> selectList(int pageNum);
	
	public List<EmpDto> selectList(int pageNum, String searchKeyword);
	
	public int totalPage(int pageNum);	
	
	public int totalPage(int pageNum, String searchKeyword);
	
	public int makeGroup(int pageNum);	
	
	public Map<String, Integer> makeGroupNum(int pageNum);
	
	public Map<String, Integer> makeGroupNum(int pageNum,String searchKeyword);
}
