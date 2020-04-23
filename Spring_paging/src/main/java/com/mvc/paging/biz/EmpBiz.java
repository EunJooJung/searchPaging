package com.mvc.paging.biz;

import java.util.List;
import java.util.Map;

import com.mvc.paging.dto.EmpDto;

public interface EmpBiz {
	
	int pageCount = 10;		//페이지당 레코드 수
	int groupSize = 5;		//페이지당 보여줄 번호
	
	public int totalCount();		//사용자가 입력한 값 (전체 개수) 리턴
	
	public List<EmpDto> selectList(int pageNum);
	
	public int totalPage(int pageNum);		//전체 페이지 수
	
	public int makeGroup(int pageNum);	
	
	public Map<String, Integer> makeGroupNum(int pageNum);
	
}
