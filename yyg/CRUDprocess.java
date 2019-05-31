package yyg;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CRUDprocess {
	// �� Ŭ������ ���� : MyBatis�� ���۸� ȣ���Ѵ�.
	// �������� �ϳ�? 1. mybatisȯ�漳���� �д´�
	// 2.���� 1�� �۾����� ���۸� ȣ���� ��ü(sqlSession)�� �����Ѵ�.
	// Ư�̻��� : sqlSession�� sqlSessionFactory�� �����Ѵ�.
	// sqlSessionFactory�� sqlSessionFactoryBuiler�� �����Ѵ�.
	/////// sqlSession�� ����� �޼���/////////////////
	private SqlSession getSession() {// �ٸ� ��ü���� ����ȵǴϱ� private�� ����
		String path = "yyg/mybatis_config.xml";// ���� ����ּ� �߰��������
		InputStream/* � ������ �д��Ŀ� ���� �޶��� */ is = null;// ������ ������ ���� ��ü
		try {
			is = Resources.getResourceAsStream(path);
		} catch (Exception e) {
			System.out.println("ȯ�漳�� ���� �߻�");
		}
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder(); // ������ ������ ���丮�� ��������
		SqlSessionFactory factory = builder.build(is); // ���丮����� ���������� �θ�
		SqlSession session = factory.openSession(); // ���丮 �����ڿ���
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
	
	public Customer_info selectId(String id) { // �ٸ������� ����ؾ��ϱ⋚���� public �� ���
		SqlSession s = getSession();
		Customer_info info= null;
		try {
			info = s.selectOne("loginmapper.selectId", id); // ������ ���� �̸��� ��
			// selectone�� �˻������ 1���� ���� ����ϴ� �޼���
			// selectList�� �˻������ �����ǿ� ����ϴ� �޼���
			return info;
		} finally { // ���ܰ� �߻��ϴ� �����ʴ� ������ ������
			s.close();// �Ϸ�ɰ�� �ݴ´�

		} // DB�� manager_info ���̺��� id�� ��ȣ�� ã�Ƽ� ����
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