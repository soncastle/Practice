package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.Member;

@Mapper
public interface DataMappingInterface {
	@Select("SELECT * FROM tblMember")
	public List<Member> selectAll();
	
	@Insert("INSERT INTO tblMember(name, addr) VALUES (#{name}, #{addr})")
	public boolean insertData(Member mem);
	
	@Select("SELECT * FROM tblMember WHERE num=#{num}")
	public Member selectNum(int num);
	
	@Update("UPDATE tblMember SET name=#{name}, addr=#{addr} WHERE num=#{num}")
	public boolean updateData(Member mem);
}