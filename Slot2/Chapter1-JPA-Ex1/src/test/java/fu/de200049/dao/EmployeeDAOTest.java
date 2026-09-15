package fu.de200049.dao;


import org.junit.jupiter.api.Test;

public class EmployeeDAOTest {

    @Test
    void TestDemo(){

        EmployeeDAO dao = new EmployeeDAO();
        dao.findAll();
    }

}
