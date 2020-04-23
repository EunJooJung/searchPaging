package com.mvc.paging.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.paging.dto.EmpDto;

@Repository
public class EmpDaoImpl implements EmpDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	String NAMESPACE = "empTable.";

	@Override
	public int totalCount() {
		
		int count = 0;
		
		try {
			count = sqlSession.selectOne(NAMESPACE+"selectCount");
		} catch (Exception e) {
			System.out.println("[error] : mybatis selectCont ");
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public List<EmpDto> selectList(int pageStartNum, int pageEndNum) {
	
		List<EmpDto> list = new ArrayList<EmpDto>();
		
		if(pageEndNum > totalCount()) {
			pageEndNum = totalCount();
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("pageStartNum", pageStartNum);
		map.put("pageEndNum", pageEndNum);
		
		System.out.println("pageStart"+pageStartNum);
		System.out.println("pageEnd"+pageEndNum);
		try {
			list = sqlSession.selectList(NAMESPACE+"selectList", map);
		} catch (Exception e) {
			System.out.println("[error : mybatis selectList]");
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int totalPage(int pageNum) {
		int total_page = 0;
		
		total_page = totalCount() / pageCount + (totalCount() % pageCount > 0 ? 1 : 0);
		
		if(pageNum > total_page) {
			pageNum = total_page;
		}
		
		return total_page;
	}

	@Override
	public int makeGroup(int pageNum) {
		int groupNum = 0;
		
		groupNum = pageNum / groupSize + (pageNum % groupSize > 0 ? 1 : 0);
		
		return groupNum;
	}

	@Override
	public Map<String, Integer> makeGroupNum(int pageNum) {
		
		int groupNum = makeGroup(pageNum);
		
		int groupEnd = 0;
		groupEnd = groupNum * groupSize;
		
		int groupStart = 0;
		groupStart = groupEnd - (groupSize - 1);
		
		if(groupEnd > totalPage(pageNum)) {
			groupEnd = totalPage(pageNum);
		}
		
		int prevNum = groupStart - groupSize;
		int nextNum = groupStart + groupSize;
		
		if(prevNum < 1) {
			prevNum = 1;
		}
		
		if (nextNum > totalPage(pageNum)) {
			nextNum = totalPage(pageNum);
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("groupEnd", groupEnd);
		map.put("groupStart", groupStart);
		map.put("prevNum", prevNum);
		map.put("nextNum", nextNum);
		
		return map;
	}

}
