package yyg;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CRUDprocess {
	// 이 클래스의 목적 : MyBatis의 매퍼를 호출한다.
	// 무슨일을 하나? 1. mybatis환경설정을 읽는다
	// 2.위의 1의 작업으로 매퍼를 호출할 객체(sqlSession)를 생성한다.
	// 특이사항 : sqlSession은 sqlSessionFactory가 생성한다.
	// sqlSessionFactory는 sqlSessionFactoryBuiler가 생성한다.
	/////// sqlSession을 만드는 메서드/////////////////
	private SqlSession getSession() {// 다른 객체에서 쓰면안되니깐 private로 만듬
		String path = "yyg/mybatis_config.xml";// 파일 경로주소 추가해줘야함
		InputStream/* 어떤 파일을 읽느냐에 따라서 달라짐 */ is = null;// 파일의 내용을 읽을 객체
		try {
			is = Resources.getResourceAsStream(path);
		} catch (Exception e) {
			System.out.println("환경설정 오류 발생");
		}
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder(); // 빌더를 만들어야 팩토리를 쓸수있음
		SqlSessionFactory factory = builder.build(is); // 팩토리만들고 빌더생성자 부름
		SqlSession session = factory.openSession(); // 팩토리 생성자에서
		return session;
	}

	public Customer_info selectCustomer(String id) {
		SqlSession s = getSession();
		Customer_info cust;
		try {
			cust = s.selectOne("loginmapper.selectCustomer", id);
			return cust;
		} finally {
			s.close();
		}
	}
	
	public int insertCustomer(Customer_info customer) {
		SqlSession s = getSession();
		int result = 0;
		try {
			result = s.insert("loginmapper.insertCustomer", customer);
			if (result > 0)
				s.commit();
			else
				s.rollback();
			return result;
		} finally {
			s.close();
		}
	}
	public int insertNCustomer(NCustomer_info ncustomer) {
		SqlSession s = getSession();
		int result = 0;
		try {
			result = s.insert("loginmapper.insertNCustomer", ncustomer);
			if (result > 0)
				s.commit();
			else
				s.rollback();
			return result;
		} finally {
			s.close();
		}
	}
	
	public Customer_info selectId(String id) { // 다른곳에서 사용해야하기떄문에 public 를 사용
		SqlSession s = getSession();
		Customer_info info= null;
		try {
			info = s.selectOne("loginmapper.selectId", id); // 매퍼의 쿼리 이름을 씀
			// selectone는 검색결과가 1건일 때만 사용하는 메서드
			// selectList는 검색결과가 여러건에 사용하는 메서드
			return info;
		} finally { // 예외가 발생하던 하지않던 무조건 실행함
			s.close();// 완료될경우 닫는다

		} // DB의 manager_info 테이블의 id와 암호를 찾아서 리턴
	}

	public NCustomer_info selectNUserIdPwd(NUserIdPwd emph) {
		SqlSession s = getSession();
		try {
			NCustomer_info info = s.selectOne("loginmapper.selectNUserIdPwd", emph); 
			return info;
		} finally {
			s.close();

		} 
	}
	
	public Customer_info selectIdPwd(UserIdPwd idpwd) {
		SqlSession s = getSession();
		try {
			Customer_info info = s.selectOne("loginmapper.selectIdPwd", idpwd); 

			return info;
		} finally {
			s.close();

		} 
	}
	
}