package april23jjh;

import java.io.InputStream;

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
		String path = "april23jjh/mybatis_config.xml"; // 환경설정파일의 경로
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

	public int insertCustomer(Customer_info customer) {
		SqlSession s = getSession();
		int result = 0; // 작업의 성공유무를 위한변수
		try {
			result = s.insert("LoginMapper.insertCustomer", customer);
			if (result > 0)
				s.commit();
			else
				s.rollback();
			return result;
		} finally {
			s.close();
		}
	}

	public Customer_info selectCustomer(String id) {
		SqlSession s = getSession();
		Customer_info cust;
		try {
			cust = s.selectOne("LoginMapper.selectCustomer", id);
			return cust;
		} finally {
			s.close();
		}
	}

	public int updateEmpl(Empl_info emp) {
		SqlSession s = getSession();
		int result = 0;
		try {
			result = s.update("LoginMapper.updateEmpl", emp);
			if (result > 0)
				s.commit();
			else
				s.rollback();
			return result;
		} finally {
			s.close();
		}
	}

	public Empl_info selectEmpl(String id) {
		SqlSession s = getSession();
		Empl_info emp;
		try {
			emp = s.selectOne("LoginMapper.selectEmpl", id);
			return emp;
		} finally {
			s.close();
		}

	}

	public int insertEmpl(Empl_info empl) { // parameterType은 매개변수
		SqlSession s = getSession();
		int result = 0;
		try {
			result = s.insert("LoginMapper.insertEmpl", empl);
			if (result > 0)
				s.commit();
			else
				s.rollback();
			return result;

		} finally {
			s.close();
		}
	}

	public ItemInfo selectItemCode(String code) { // 상품번호를받아서 selectOne에 넘겨주기위해서 매개변수를선언
		SqlSession s = getSession(); // SqlSession을 만드는것
		ItemInfo ii = null;
		try {
			ii = s.selectOne("LoginMapper.selectItemCode", code); // mapper부터찾고 쿼리
			return ii;
		} finally {
			s.close();
		}
	}

	public int updateItemInfo(ItemInfo info) {
		SqlSession s = getSession();
		int result = 0;

		try {
			result = s.update("LoginMapper.updateItemInfo", info);
			if (result > 0)
				s.commit();
			else
				s.rollback();
			return result;
		} finally {
			s.close();
		}

	}

	public int deleteItemCode(String code) {
		SqlSession s = getSession();
		int result = 0;

		try {
			result = s.delete("LoginMapper.deleteItemCode", code);
			if (result > 0)
				s.commit();
			else
				s.rollback();
			return result;
		} finally {
			s.close();
		}

	}

	public int insertItemInfo(ItemInfo item) {
		SqlSession s = getSession();
		int result = 0;

		try {
			result = s.insert("LoginMapper.insertItemInfo", item);
			if (result > 0)
				s.commit();
			else
				s.rollback();
			return result;
		} finally {
			s.close();
		}
	}

	public int deleteEmpl(String emp_id) {
		SqlSession s = getSession();
		int result = 0;
		try {
			result = s.delete("LoginMapper.deleteEmpl", emp_id);
			if (result > 0)
				s.commit();
			else
				s.rollback();
			return result;
		} finally {
			s.close();
		}

	}

	// 화면에서 입력한 id와 패스워드를 사용해서 쿼리를 실행하는 메소드
	public ManagerInfo selectIdAndPwd(UserIdPwd uip) {
		SqlSession s = getSession();
		try {
			ManagerInfo info = s.selectOne("LoginMapper.selectIdPwd", uip); // "매퍼의 쿼리이름" //아이디와 쿼리가 uip에 들어가있음
			return info;
		} finally {
			s.close();
		}

	}
}
