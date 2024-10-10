package com.itwillbs.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * 
 *  VO	: (Value Object) : 데이터 저장 객체 (값을 저장하는 동작 이외의 동작 O)
 *	DTO	: (Date Transfer Object) : 데이터 전송 객체 (값을 저장하는 동작 이외의 동작 X)
 */

// @Data set/get 메서드 자동생성
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
@Data
public class MemberVO {
	
	// private String Uid;
	// private String uId; // getUId() (x)
	// private String userId; 
	
	private String id;  // getUserid()
	private String pw;
	private String name;
	private String email;
	private Timestamp regdate;
	private Timestamp updatedate;
}
