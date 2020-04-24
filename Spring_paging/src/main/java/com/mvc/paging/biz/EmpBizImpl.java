package com.mvc.paging.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.paging.dao.EmpDao;
import com.mvc.paging.dto.EmpDto;


@Service
public class EmpBizImpl implements EmpBiz {

	@Autowired
	private EmpDao dao;
	
	@Override
	public int totalCount() {
		
		return dao.totalCount();
	}
	

	@Override
	public int totalCount(String searchKeyword) {
		
		return dao.totalCount(searchKeyword);
	}

	
	


	@Override
	public int totalPage(int pageNum, String searchKeyword) {
		
		return dao.totalPage(pageNum, searchKeyword);
	}


	@Override
	public List<EmpDto> selectList(int pageNum) {
		
		int pageStartNum = 0;
		int pageEndNum = 0;
		
		pageEndNum =  pageNum * pageCount;
		pageStartNum = pageEndNum - (pageCount - 1);
		
		if(pageEndNum > totalCount()) {
			pageEndNum = totalCount();
		}
		
		return dao.selectList(pageStartNum, pageEndNum);
	}
	
	

	@Override
	public List<EmpDto> selectList(int pageNum, String searchKeyword) {
		
		int pageStartNum = 0;
		int pageEndNum = 0;
		
		pageEndNum =  pageNum * pageCount;
		pageStartNum = pageEndNum - (pageCount - 1);
		
		if(pageEndNum > totalCount()) {
			pageEndNum = totalCount();
		}
		
		return dao.selectList(pageStartNum, pageEndNum, searchKeyword);
	}

	@Override
	public int totalPage(int pageNum) {
		// TODO Auto-generated method stub
		return dao.totalPage(pageNum);
	}

	@Override
	public int makeGroup(int pageNum) {
		// TODO Auto-generated method stub
		return dao.makeGroup(pageNum);
	}

	@Override
	public Map<String, Integer> makeGroupNum(int pageNum) {
		// TODO Auto-generated method stub
		return dao.makeGroupNum(pageNum);
	}


	@Override
	public Map<String, Integer> makeGroupNum(int pageNum, String searchKeyword) {
		// TODO Auto-generated method stub
		return dao.makeGroupNum(pageNum, searchKeyword);
	}

	
}
