import dao.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import po.Student;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        Reader reader= Resources.getResourceAsReader("mybatis.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession session=sqlSessionFactory.openSession(true);
//        Student student=session.getMapper(StudentMapper.class).selectByPrimaryKey(2);
//        System.out.println(student);
//        List<Student> slist=session.getMapper(StudentMapper.class).select();
//        System.out.println(slist);
        Student student=new Student(3,"金属所","看看",8.0,"tyuio");
        int i=session.getMapper(StudentMapper.class).updateByPrimaryKey(student);
        System.out.println(i);
    }
}
