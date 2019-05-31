//package hhj;
//
//import java.io.InputStream;
//
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//
//import oracle.net.aso.s;
//
////이 클래스의 목적 : MyBatis의 매퍼를 호출한다.
////무슨일을 하나 ?
//// 1. MyBatis 환경설정 파일을 읽는다.
//// 2. 위 1의 작업으로 매퍼를 호출 할 객체(SqlSession)를 생성한다.
//// 	--> 특이사상 : SqlSession은 SqlSessionFactory가 생성한다.
////				   SqlSessionFactory는 SqlSessionFactoryBuilder가 생성한다.
//
//public class CRUDprocess {
////////////////////SqlSession을 만드는 메소드 /////////////////////
//	private SqlSession getSession() {
//		String path = "hhj/mybatis_config.xml";	//환경설정파일의 경로
//		InputStream is = null;	//파일의 내용을 읽을 객체
//		
//		try {
//			is = Resources.getResourceAsStream(path);
//		} catch(Exception e) {	//Exception -> 예외의 최상위 조상. 무슨 예외가 발생해도 ~ 처리
//			System.out.println("환경설정파일을 읽는 중 예외가 발생했습니다.");
//		}	//예외처리 --> 예외가 발생해도 오류를 출력하지 말아라.
//		
//		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//		SqlSessionFactory factory = builder.build(is);
//		SqlSession session = factory.openSession();
//		return session;
//	}
//	
////화면에서 입력한 ID와 비밀번호를 사용해서 쿼리를 실행하는 메소드///
//	public ManagerInfo selectIdAndPwd(UserIdPwd uip){
//		SqlSession s = getSession();
//		try {
//			ManagerInfo info = s.selectOne("loginmapper.selectIdPwd",uip);
//			
//		//selectOne은 검색결과가 1건일 때만 사용하는 메소드
//		//selectList는 검색결과가 여러건일 때 사용하는 메소드
//			
//			return info;
//		} finally {	//예외가 발생하든 안하든 finally 안에는 무조건 처리가되어야한다.
//			s.close();
//		}
//	}	//DB의 manager_info 테이블의 ID와 PASSWORD를 찾아서 리턴
//	
//	public int insertItemInfo(ItemInfo item) {		//삽입
//		SqlSession s = getSession();
//		int result = 0;	//작업의 성공유무를 위한 변수
//		try {
//			result = s.insert("loginmapper.insertItemInfo", item);
//			if(result > 0) {
//				s.commit();
//			} else {
//				s.rollback();
//			}
//			return result;
//		} finally {
//			s.close();
//		}
//	}
//	
//	public int deleteItemCode(String code) {		//삭제
//		SqlSession s = getSession();
//		int result = 0;
//		try {
//			
//			result = s.delete("loginmapper.deleteItemCode", code);
//			if(result > 0) {
//				s.commit();
//			} else {
//				s.rollback();
//			}
//			return result;
//		} finally {
//			s.close();
//		}
//	}
//	
//	public int updateItemInfo(ItemInfo info) {		//변경
//		SqlSession s = getSession();
//		int result = 0;
//		try {
//			
//			result = s.update("loginmapper.updateItemInfo", info);
//			if(result > 0) {
//				s.commit();
//			} else {
//				s.rollback();
//			}
//			return result;
//		} finally {
//			s.close();
//		}
//	}
//	
//	public ItemInfo selectItemCode(String code) {
//		SqlSession s = getSession();
//		ItemInfo ii = null;
//		try {
//			//검색결과가 한 건일 때, selectOne을 사용하고
//			//검색결과가 여러 건일 때, selectList를 사용한다.
//			ii = s.selectOne("loginmapper.selectItemCode",code);
//			return ii;
//		} finally {
//			s.close();
//		}
//	}
//	
//	public Empl_info selectEmpl(String id) {
//		
//		SqlSession s = getSession();
//		Empl_info emp;
//		try {
//			emp = s.selectOne("loginmapper.selectEmpl",id);
//			return emp;
//		} finally {
//			s.close();
//		}
//	}
//	
//	public int insertEmpl(Empl_info empl) {
//		
//		SqlSession s = getSession();
//		int result = 0;	//작업의 성공유무를 위한 변수
//		try {
//			result = s.insert("loginmapper.insertEmpl",empl);
//			if(result > 0) {
//				s.commit();
//			} else {
//				s.rollback();
//			}
//			return result;
//	
//		} finally {
//			s.close();
//		}
//	}
//	
//	public int deleteEmpl(String emp_id) {		//사원관리 삭제
//		
//		SqlSession s = getSession();
//		int result = 0;	//작업의 성공유무를 위한 변수
//		try {
//			result = s.delete("loginmapper.deleteEmpl",emp_id);
//			if(result > 0) {
//				s.commit();
//			} else {
//				s.rollback();
//			}
//			return result;
//	
//		} finally {
//			s.close();
//		}
//	}
//	
//	public int updateEmpl(Empl_info emp) {		//사원관리 변경
//		SqlSession s = getSession();
//		int result = 0;	//작업의 성공유무를 위한 변수
//		try {
//			result = s.delete("loginmapper.updateEmpl",emp);
//			if(result > 0) {
//				s.commit();
//			} else {
//				s.rollback();
//			}
//			return result;
//	
//		} finally {
//			s.close();
//		}
//	}
//	
//	public Customer_info selectCustomer(String id){
//		SqlSession s = getSession();
//		Customer_info cust;
//		try {
//			cust = s.selectOne("loginmapper.selectAllCustomer", id);
//			return cust;
//		} finally {
//			s.close();
//		}
//	}
//	
//	public int insertCustomer(Customer_info customer) {
//		SqlSession s = getSession();
//		int result = 0;
//		try {
//			result = s.insert("loginmapper.insertCustomer",customer);
//			if(result > 0) {
//				s.commit();
//			} else {
//				s.rollback();
//			}
//			return result;
//		} finally {
//			s.close();
//		}
//	}
//	
//	public Outputs selectOutputs() {
//		SqlSession s = getSession();
//		Outputs outputs;
//		try {
//			outputs = s.selectOne("loginmapper.selectOutputs");
//			return outputs;
//		} finally {
//			s.close();
//		}
//	}
//	
//	
//}
//
//
//
//
