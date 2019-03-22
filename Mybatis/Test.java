
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) {
        String path="sqlMapConfig.xml";
        try {
            InputStream in=Resources.getResourceAsStream(path);
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
            SqlSession sqlSession=sqlSessionFactory.openSession();
            User user=sqlSession.selectOne("org.test.Demo","026bc4bf-4a22-11e9-8f8c-4ccc6aadd694");
            System.out.println(user.getPassword()+ " "+ user.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(Resources.getResourceURL(""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
