package HJ;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//이 클래스의 목적 : MyBatis의 매퍼를 호출한다.
//무슨일을 하나 ?
// 1. MyBatis 환경설정 파일을 읽는다.
// 2. 위 1의 작업으로 매퍼를 호출 할 객체(SqlSession)를 생성한다.
//    --> 특이사상 : SqlSession은 SqlSessionFactory가 생성한다.
//               SqlSessionFactory는 SqlSessionFactoryBuilder가 생성한다.

public class CRUDprocess {
//////////////////SqlSession을 만드는 메소드 /////////////////////
   private SqlSession getSession() {
      String path = "HJ/mybatis_config.xml";   //환경설정파일의 경로
      InputStream is = null;   //파일의 내용을 읽을 객체
      
      try {
         is = Resources.getResourceAsStream(path);
      } catch(Exception e) {   //Exception -> 예외의 최상위 조상. 무슨 예외가 발생해도 ~ 처리
         System.out.println("환경설정파일을 읽는 중 예외가 발생했습니다.");
      }   //예외처리 --> 예외가 발생해도 오류를 출력하지 말아라.
      
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
