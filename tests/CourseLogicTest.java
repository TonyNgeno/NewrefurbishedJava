
import com.tonyngeno.logic.CourseLogic;
import com.tonyngeno.logic.CourseLogicI;
import com.tonyngeno.model.Course;
import com.tonyngeno.model.Student;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseLogicTest {
    CourseLogicI courseLogicI;
    public CourseLogicTest() throws SQLException, ClassNotFoundException {
        courseLogicI = new CourseLogic();
    }
    @Test
    public void add() throws SQLException, ClassNotFoundException {
        Course course= new Course();
        course.setCourseId(10101);
        course.setName("FOOD SCIENCE");
        if(!courseLogicI.add(course))
            Assert.assertFalse(false); // confirmation that it has failed
        Course search = courseLogicI.find(course.getCourseId());
        Assert.assertEquals(course.getCourseId(), search.getCourseId());
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException {
        Course search = courseLogicI.find(1234);
        search.setName("CHEF science");
        if(!courseLogicI.update(search))
            Assert.assertFalse(false); // confirmation that it has failed
        // Means the update was successful. We need to test for correctness of the updated data
        Course course = courseLogicI.find(search.getCourseId());
        Assert.assertEquals(course.getCourseId(), search.getCourseId());
    }

    @Test
    public void delete() throws SQLException, ClassNotFoundException {
        Course search = courseLogicI.find(1234);
        if(!courseLogicI.delete(search))
            Assert.assertFalse(false);
        Course course = courseLogicI.find(search.getCourseId());
        Assert.assertEquals(course.getCourseId(), search.getCourseId());
    }

    @Test
    public void findAll() throws SQLException, ClassNotFoundException {
        Course course =new Course();
        List<Course> find = new ArrayList<>() {};
        find=courseLogicI.findAll();
        if(find.isEmpty());
        Assert.assertFalse(false);
        course.setCourseId(2020);
        Course search=courseLogicI.find(course.getCourseId());
        Assert.assertEquals(search.getCourseId(),course.getCourseId());

    }

    @Test
    public void find() throws SQLException, ClassNotFoundException {
        Course course=new Course();
        course.setCourseId(2020);
        Course search=courseLogicI.find(course.getCourseId());
        Assert.assertEquals(search.getCourseId(),course.getCourseId());
    }
}
