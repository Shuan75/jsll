package JJH;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CRUDprocess {

	private SqlSession getSession() {
		String path = "JJH/mybatis_config.xml"; // 환경설정파일의 경로
		InputStream is = null; // 파일의 내용을 읽을 객체
		try {
			is = Resources.getResourceAsStream(path); // xml을 읽도록 만들어줌
		} catch (Exception e) {
			System.out.println("환경설정읽다가 에러 발생");
		}
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(is);
		SqlSession session = factory.openSession();

		return session;
	}

	
	public List<Customer_info> selectidIteminfo(String id) {
		SqlSession s = getSession();
		List<Customer_info> result = null;
		try {
			result = s.selectList("LoginMapper.selectidIteminfo", id);
			return result;
		} finally {
			s.close();
		}

	}
	public int deleteIteminfoCondition(Map<String, Object> condition) {
		SqlSession s = getSession();
		int result = 0;
		try {
			result = s.delete("LoginMapper.deleteIteminfoCondition", condition);
			if (result > 0)
				s.commit();
			else
				s.rollback();
			return result;
		} finally {
			s.close();
		}
	}

	public Outputs selectOutputs() {
		SqlSession s = getSession();
		Outputs outputs;
		try {
			outputs = s.selectOne("LoginMapper.selectOutputs");
			return outputs;
		} finally {
			s.close();
		}
	}

	public Outputs2 selectOutputs2() {
		SqlSession s = getSession();
		Outputs2 outputs2;
		try {
			outputs2 = s.selectOne("LoginMapper.selectOutputs2");
			return outputs2;
		} finally {
			s.close();
		}
		
	}

//	
//	public List<Exhibit_reserve> selectReState() {
//		SqlSession s = getSession();
//		Exhibit_reserve re;
//		try {
//			re = s.selectOne("LoginMapper.selectReState");
//			return (List<Exhibit_reserve>) re;
//		} finally {
//			s.close();
//		}
//	}
//	
	public List<Customer_info> selectIteminfoCondition(Map<String, Object> condition) {
		// map을 매개변수로 받고 generic을걸어 String과 object만받고 변수이름 condition을 써 줌
		SqlSession s = getSession();
		List<Customer_info> info = null;
		try {
			info = s.selectList("LoginMapper.selectIteminfoCondition", condition);
			return info;
		} finally {
			s.close();
		}
	}

	
	public List<Customer_info> selectAllIteminfo() {
		SqlSession s = getSession();
		List<Customer_info> info = null;
		try {
			info = s.selectList("LoginMapper.selectAllIteminfo");
			return info;
		} finally {
			s.close();
		}
	}

	public List<Customer_info> selectAllCustomer() {
		SqlSession s = getSession();
		List<Customer_info> info = null;
		try {
			info = s.selectList("LoginMapper.selectAllCustomer"); // 쿼리이름 (method와 동일)
			return info;
		} finally {
			s.close();
		}
	}
//
//	public List<Empl_info> selectAllEmpl() {
//		SqlSession s = getSession();
//		List<Empl_info> info = null;
//		try {
//			info = s.selectList("LoginMapper.selectAllEmpl");
//			return info;
//		} finally {
//			s.close();
//		}
//	}
}
