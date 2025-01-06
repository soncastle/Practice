package com.example.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mapper.DataMappingInterface;
import com.example.model.Member;

@Repository
public class MemberDao {
	//@Autowired
	//private SqlSessionTemplate sqlSession;
	
	@Autowired
	private DataMappingInterface dataInterface;
	
	public boolean insertData(Member mem) {
		//int result = sqlSession.insert("com.example.memberMapper.insertData", mem);
		boolean result = dataInterface.insertData(mem);
		
		if(result) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<Member> selectAll(){
		//return sqlSession.selectList("com.example.memberMapper.selectAll");
		return dataInterface.selectAll();
	}
	
	public Member selectNum(int num) {
		// return sqlSession.selectOne("com.example.memberMapper.selectNum", num);
		return dataInterface.selectNum(num);
	}
	
	public boolean updateData(Member mem) {
		//int result = sqlSession.update("com.example.memberMapper.updateData", mem);
		boolean result = dataInterface.updateData(mem);
		
		return result;
	}
}








