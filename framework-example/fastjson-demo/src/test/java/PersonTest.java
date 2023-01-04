import com.alibaba.fastjson.JSON;
import com.szm.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PersonTest {

    private List<Person> listOfPersons = new ArrayList<>();


    @Before
    public void setUp() {
        listOfPersons.add(new Person(12, "tom"));
        listOfPersons.add(new Person(13, "jack"));
    }

    @Test
    public void testPrintMessage() {
        for (Person person : listOfPersons) {
            System.out.println(person);
        }

        String jsonOutPut = JSON.toJSONString(listOfPersons);
        System.out.println(jsonOutPut);
    }
}
