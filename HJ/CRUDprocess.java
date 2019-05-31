package HJ;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//�� Ŭ������ ���� : MyBatis�� ���۸� ȣ���Ѵ�.
//�������� �ϳ� ?
// 1. MyBatis ȯ�漳�� ������ �д´�.
// 2. �� 1�� �۾����� ���۸� ȣ�� �� ��ü(SqlSession)�� �����Ѵ�.
//    --> Ư�̻�� : SqlSession�� SqlSessionFactory�� �����Ѵ�.
//               SqlSessionFactory�� SqlSessionFactoryBuilder�� �����Ѵ�.

public class CRUDprocess {
//////////////////SqlSession�� ����� �޼ҵ� /////////////////////
   private SqlSession getSession() {
      String path = "HJ/mybatis_config.xml";   //ȯ�漳�������� ���
      InputStream is = null;   //������ ������ ���� ��ü
      
      try {
         is = Resources.getResourceAsStream(path);
      } catch(Exception e) {   //Exception -> ������ �ֻ��� ����. ���� ���ܰ� �߻��ص� ~ ó��
         System.out.println("ȯ�漳�������� �д� �� ���ܰ� �߻��߽��ϴ�.");
      }   //����ó�� --> ���ܰ� �߻��ص� ������ ������� ���ƶ�.
      
      SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
      SqlSessionFactory factory = builder.build(is);
      SqlSession session = factory.openSession();
      return session;
   }
   
   
   
   
   
   public int insertreservecode(String ticketcode) {
	   SqlSession s = getSession();
	      int result;
	      try {
	         result = s.insert("loginmapper.insertreservecode",ticketcode);
	         if(result > 0) s.commit();
	         else s.rollback();
	         return result;	
	         
	         
	      } finally {
	         s.close();
	      }
	   
   }


}
