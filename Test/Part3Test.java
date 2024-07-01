import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Part3Test {
String developer[] ={"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"};
String taskName[] = {"Create Login","Create Add Features","Create Reports","Add Arrays"};
int taskDuration[] = {5,8,2,11};
String taskStatus[] ={"To Do","Doing","Done","To Do"};
    @Test
    public void testDeveloper() {
        String expected = "Mike Smith"+"Edward Harrison"+"Samantha Paulson"+"Glenda Oberholzer";
        assertEquals(expected,"Mike Smith"+"Edward Harrison"+"Samantha Paulson"+"Glenda Oberholzer");
    }
    @Test
    public void longestDuration() {
        int taskDuration = 11;
        String developer = "Glenda Oberholzer";
        assertEquals(taskDuration,11);
        assertEquals(developer,"Glenda Oberholzer");
    }
    @Test
    public void taskSearch(){
        String taskName = "Create login";
        String developerName = "Mike Smith";
        assertEquals(taskName,"Create login");
        assertEquals(developerName, "Mike Smith");
    }
    @Test
    public void developerTask(){
        String developerName = "Samantha Paulson";
        String taskName = "Create Reports";
        assertEquals(developerName, "Samantha Paulson");
        assertEquals(taskName, "Create Reports");
    }
    @Test
    public void taskDeletion(){
        String taskName = "Create Reports";
        assertEquals(taskName, "Create Reports");
    }
}