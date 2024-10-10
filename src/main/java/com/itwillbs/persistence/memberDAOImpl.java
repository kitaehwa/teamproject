package com.itwillbs.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;


/**
 * MemberDAO 동작을 수행
 * 
 *
 */

// @Repository : 스프링이 해당 클래스를 DAO객체(Bean)로 인식
//               root-context.xml파일에서 해당 객체를 사용하도록 설정

@Repository
public class memberDAOImpl implements MemberDAO{
	
	// 공통변수, 디비 연결, 자원해제
	// 디비 연결객체(SqlSessionFactory)가 필요함 => 의존관계 주입
//	@Inject
//	private SqlSessionFactory sqlFactory;
	
	@Inject
	private SqlSession sqlSession; // 자동으로 연결, 자원해제, SQL 실행, mybatis...
	
	// Mapper namespace 정보 저장
	private static final String NAMESPACE="com.itwillbs.mapper.MemberMapper";
	
	@Override
	public String getTime() {
		System.out.println(" DAO : getTime() 실행!");
		// 1.2 디비연결
		// SqlSession sqlSession = sqlFactory.openSession();
		// 3. SQL 구문 & pstmt 객체
		// 4. SQL 실행
		// sqlFactory.selectOne(SQL 구문);
		// sqlFactory.selectOne(SQL 구문,전달정보);
		String result 
		= sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime");
			// => Mapper의 sql구문 id를 호출 
			// => 직접적으로 SQL 구문 호출은 안된다.
		// 5. 데이터 처리
		System.out.println("결과 : "+result);
		return result;
	}
	
	@Override
	public void insertMember(MemberVO vo) {
		System.out.println(" DAO : 회원가입 동작 실행 ");
		
		// 1.2. 디비연결 => 생략 SqlSession객체 수행
		// 3. SQL구문(mapper 생성) & pstmt객체 (mybatis 관리)
		// 4. SQL 실행
		// com.itwillbs.mapper.MemberMapper.insertMember
		int result = sqlSession.insert(NAMESPACE+".insertMember", vo);
		
		System.out.println(" DAO : "+result);
		System.out.println(" DAO : 회원가입 동작 완료 ");
	}

	@Override
	public MemberVO loginMember(MemberVO vo) {
		System.out.println(" DAO : loginMember(Member VO vo) 실행");
		
		// SQL 구문을 mapper에 생성
		System.out.println(" DAO : mapper SQL 생성완료");
		// SQL 구문 실행
		MemberVO resultVO 
			= sqlSession.selectOne(NAMESPACE+".loginMember", vo);
		
		System.out.println(" DAO : resultVO");
		
		return resultVO;
	}
	
	@Override
	public MemberVO loginMember(String id, String pw) {
		System.out.println(" DAO : loginMember(String userid, String userpw) 실행");
	
		//sqlSession.selectOne(NAMESPACE+".loginMember",userid,userpw);

		//		MemberVO vo = new MemberVO();
		//		vo.setUserid(userid);
		//		vo.setUserpw(userpw);
		//		MemberVO resultVO = sqlSession.selectOne(NAMESPACE+".loginMember",vo);
		//		=> 전달받은 정보를 하나의 공통객체에 저장 => 전달할때 객체로 전달
		
		// * userid(회원가입), userpw(게시판)는 하나의 객체(MemberVO)에 저장이 불가능하다고 가정
		Map<String, Object> paramMap = new HashMap<String, Object>();
		// paramMap.put("mapper에서 호출하는 이름", 전달될 값);
		paramMap.put("id", id);
		paramMap.put("pw", pw);
		
		MemberVO resultVO = sqlSession.selectOne(NAMESPACE+".loginMember",paramMap);
	
		return resultVO;
	}

	@Override
	public MemberVO getMember(String id) {
		System.out.println(" DAO : getMember(String id)");
		
		// mapper SQL 작성

		// SqlSession 사용 SQL 실행
		return sqlSession.selectOne(NAMESPACE+".getMember",id);
	}

	@Override
	public int updateMember(MemberVO uvo) {
		System.out.println(" DAO : updateMember(MemberVO uvo)");
		// mapper SQL 작성
		// SqlSession - sql실행 (결과에 따른 정수데이터를 리턴)
		
		return sqlSession.update(NAMESPACE+".updateMember", uvo);
	}


	@Override
	public Integer deleteMember(MemberVO dvo) {
		System.out.println(" DAO : deleteMember(MemberVO dvo)");
		// mapper SQL 작성
		// SqlSession - sql실행
		return sqlSession.delete(NAMESPACE+".deleteMember", dvo);
	}

	@Override
	public List<MemberVO> getMemberList() {
		System.out.println(" DAO : getMemberList() ");
		// mapper SQL 작성
		// SqlSession - sql실행
		return sqlSession.selectList(NAMESPACE+".getMemberList");
		
	}
	
	
	


	


		
	

	
	
	
}
