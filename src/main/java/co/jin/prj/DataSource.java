package co.jin.prj;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class DataSource { // 싱글톤 Class로 만듬
	   private static SqlSessionFactory sqlSessionFactory;
	   private DataSource() {}
	   
	   public static SqlSessionFactory getInstance() {
	      try {
	         String resource = "mybatis-config.xml";
	         InputStream inputStream = Resources.getResourceAsStream(resource);
	         sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      return sqlSessionFactory;
	   }
	}
//public class DataSource {
//	
//	private static SqlSessionFactory sqlSessionFactory;
//	private DataSource() {}
//
//	public static SqlSessionFactory getInstance() {
//		try {
//			String resource = "mybatis-config.xml";
//			InputStream inputStream;
//			inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return sqlSessionFactory;
//	}
//
//}
