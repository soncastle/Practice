package com.example.model;

import lombok.Data;

//@RequiredArgsConstructor
//@Getter
//@Setter
@Data
public class Member {
	private int num;
	private String name;
	private String addr;
}

/*
 CREATE TABLE tblMember(
 num    int      auto_increment      primary key,
 name   varchar(50),
 addr   varchar(50)
 );
*/