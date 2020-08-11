import com.tonyngeno.logic.StudentLogic;
import com.tonyngeno.logic.TeacherLogic;
import com.tonyngeno.logic.TeacherLogicI;
import com.tonyngeno.model.Student;
import com.tonyngeno.model.Teacher;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class TeacherLogicTest {
    TeacherLogicI teacherLogicI;

    public TeacherLogicTest() throws SQLException, ClassNotFoundException{
        teacherLogicI = new TeacherLogic();
    }
    @Test
    public void add() throws SQLException {
        Teacher teacher = new Teacher();
        teacher.setStaffNo("10101010");
        teacher.setCourse("FOOD SCIENCE");
        teacher.setName("Tonito N");
        if(!teacherLogicI.add(teacher))
            Assert.assertFalse(false); // confirmation that it has failed
        Teacher search = teacherLogicI.find(teacher.getStaffNo());
        Assert.assertEquals(teacher.getStaffNo(), search.getStaffNo());
        Assert.assertEquals(teacher.getName(), search.getName());
        Assert.assertEquals(teacher.getCourse(), search.getCourse());
    }

    @Test
    public void update() throws SQLException {
        Teacher search = teacherLogicI.find("10101010");
        search.setName("CHEF THE GUSTEAU");
        search.setCourse("SCIENCE FOOD");
        if(!teacherLogicI.update(search))
            Assert.assertFalse(false); // confirmation that it has failed
        // Means the update was successful. We need to test for correctness of the updated data
        Teacher teacher = teacherLogicI.find(search.getStaffNo());
        Assert.assertEquals(teacher.getStaffNo(), search.getStaffNo());
        Assert.assertEquals(teacher.getName(), search.getName());
        Assert.assertEquals(teacher.getCourse(), search.getCourse());
    }

    @Test
    public void delete() throws SQLException {
        Teacher search = teacherLogicI.find("345");
        if(!teacherLogicI.delete(search))
            Assert.assertFalse(false);
        Teacher teacher = teacherLogicI.find(search.getStaffNo());
        Assert.assertEquals(teacher.getStaffNo(), search.getStaffNo());
    }

    @Test
    public void findAll() {
    }

    @Test
    public void find() {
    }

}