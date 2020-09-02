import com.wang.dao.StudentMapper;
import com.wang.dao.TeacherMapper;
import com.wang.pojo.Student;
import com.wang.pojo.Teacher;
import com.wang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void TestGetTeacher() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);

        sqlSession.close();
    }

    @Test
    public void TestGetStudentInfo() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudentInfo();
        for (Student student : students) {
            System.out.println(student);
        }

        sqlSession.close();
    }

    @Test
    public void TestGetStudentInfo2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudentInfo2();
        for (Student student : students) {
            System.out.println(student);
        }

        sqlSession.close();
    }
}
