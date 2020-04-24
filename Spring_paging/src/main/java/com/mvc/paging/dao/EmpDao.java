package com.mvc.paging.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mvc.paging.dto.EmpDto;

@Repository
public interface EmpDao {
	
	int pageCount = 10;		
	int groupSize = 5;
	
	public int totalCount();		
	
	public int totalCount(String searchKeyword);
	
	public List<EmpDto> selectList(int pageStartNum, int pageEndNum);
	
	public List<EmpDto> selectList(int pageStartNum, int pageEndNum, String searchKeyword);
	
	public int totalPage(int pageNum);
	
	public int totalPage(int pageNum, String searchKeyword);	
	
	public int makeGroup(int pageNum);	
	
	public Map<String, Integer> makeGroupNum(int pageNum);

	public Map<String, Integer> makeGroupNum(int pageNum,String searchKeyword);
}
