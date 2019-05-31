package may09jjh;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CRUDprocess {
//	1 MyBatis의 매퍼를 호출
//	2 2.1 mybites 환경설정파일을 읽는다.
//	위의 2.1의 작업으로 매퍼를  호출할 객체 (sqlsession)을 생성
//	특이사항 : sqlsession은 sqlsessionfactory가 생성
//	sqlsessionfactory는 sqlsessionfactorybuilder가 생성
// SQLSession을 만드는 method

	private SqlSession getSession() {
		String path = "may09jjh/mybatis_config.xml"; // 환경설정파일의 경로
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

	public List<ItemInfo> selectIteminfoCondition(Map<String, Object> condition) {
		// map을 매개변수로 받고 generic을걸어 String과 object만받고 변수이름 condition을 써 줌
		SqlSession s = getSession();
		List<ItemInfo> info = null;
		try {
			info = s.selectList("LoginMapper.selectIteminfoCondition", condition);
			return info;
		} finally {
			s.close();
		}
	}

	public List<ItemInfo> selectAllIteminfo() {
		SqlSession s = getSession();
		List<ItemInfo> info = null;
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

	public List<Empl_info> selectAllEmpl() {
		SqlSession s = getSession();
		List<Empl_info> info = null;
		try {
			info = s.selectList("LoginMapper.selectAllEmpl");
			return info;
		} finally {
			s.close();
		}
	}
}
