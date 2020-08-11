
import com.tonyngeno.logic.StudentLogic;
import com.tonyngeno.logic.StudentLogicI;
import com.tonyngeno.model.Student;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentLogicTest {
    StudentLogicI studentLogicI;
    public StudentLogicTest() throws SQLException, ClassNotFoundException {
        studentLogicI = new StudentLogic();
    }
    @Test
    public void add() throws SQLException{
        Student student = new Student();
        student.setIdNumber("10101010");
        student.setCourse("FOOD SCIENCE");
        student.setRegistrationNo("FS04/22093/09");
        student.setName("GUSTEAU THE CHEF");
        if(!studentLogicI.add(student))
            Assert.assertFalse(false); // confirmation that it has failed
        Student search = studentLogicI.find(student.getRegistrationNo());
        Assert.assertEquals(student.getRegistrationNo(), search.getRegistrationNo());
        Assert.assertEquals(student.getName(), search.getName());
        Assert.assertEquals(student.getCourse(), search.getCourse());
        Assert.assertEquals(student.getIdNumber(), search.getIdNumber());
    }

    @Test
    public void update() throws SQLException {
        Student search = studentLogicI.find("FS04/22093/09");
        search.setName("CHEF THE GUSTEAU");
        search.setCourse("SCIENCE FOOD");
        search.setIdNumber("01010101");
        if(!studentLogicI.update(search))
            Assert.assertFalse(false); // confirmation that it has failed
        // Means the update was successful. We need to test for correctness of the updated data
        Student student = studentLogicI.find(search.getId());
        Assert.assertEquals(student.getRegistrationNo(), search.getRegistrationNo());
        Assert.assertEquals(student.getName(), search.getName());
        Assert.assertEquals(student.getCourse(), search.getCourse());
        Assert.assertEquals(student.getIdNumber(), search.getIdNumber());
    }

    @Test
    public void delete()  throws SQLException {
        Student search = studentLogicI.find("FS04/22093/09");
        if(!studentLogicI.delete(search))
            Assert.assertFalse(false);
        Student student = studentLogicI.find(search.getRegistrationNo());
        Assert.assertEquals(student.getRegistrationNo(), search.getRegistrationNo());
    }

    @Test
    public void findAll()  throws SQLException {
        Student student=new Student();
        List<Student> find=new ArrayList<>() {};
        find=studentLogicI.findAll();
        if(find.isEmpty());
            Assert.assertFalse(false);
        student.setRegistrationNo("c2020");
        Student search=studentLogicI.find(student.getRegistrationNo());
        Assert.assertEquals(search.getRegistrationNo(),student.getRegistrationNo());

    }

    @Test
    public void find()  throws SQLException {
        Student student=new Student();
        student.setRegistrationNo("234");
        Student search=studentLogicI.find(student.getRegistrationNo());
        Assert.assertEquals(search.getRegistrationNo(),student.getRegistrationNo());
    }
}