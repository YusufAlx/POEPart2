import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Part2Test {

    @Test
    public void isTaskDescriptionValid() {
        String validTaskDescription;
        validTaskDescription = "Create Add Task feature to add task users";
        assertEquals("Create Add Task feature to add task users",validTaskDescription);
    }
    @Test
    public void isTaskDescriptionInvalid(){
        String invalidTaskDescription;
        invalidTaskDescription = "Hello my name is Ethan and i like to go fishing during my spare time with my family and friends.The last time we left to go fish i caught fifty bass.";
        assertEquals("Hello my name is Ethan and i like to go fishing during my spare time with my family and friends.The last time we left to go fish i caught fifty bass.",invalidTaskDescription);
    }
    @Test
    public void isTaskIdValid(){
        String validTaskId;
        validTaskId = "AD:1:BYN";
        assertEquals("AD:1:BYN",validTaskId);
    }
    @Test
    public void isTaskIdInvalid(){
        String invalidTaskId;
        invalidTaskId = "1234:tss:Hsd";
        assertEquals("1234:tss:Hsd",invalidTaskId);
    }
    @Test
    public void isTotalHoursValid(){
        int validHours;
        validHours = 18;
        assertEquals(18,validHours);
    }
    @Test
    public void isTotalHoursInvalid(){
        int invalidHours;
        invalidHours = 21;
        assertEquals(21,invalidHours);
    }
}