package fu.de200049;



import fu.de200049.dao.EmployeeDAO;
import fu.de200049.pojo.Employee;
import fu.de200049.pojo.Gender;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAO();



        // [Lifecycle]
        // emp dang o trang thai NEW/TRANSIENT
        // Vi vua duoc tao bang tu khoa "new" va chua duoc quan ly boi JPA.
   /*     Employee emp = new Employee(
                "Nguyen Van B",
                "b@fpt.edu.vn",
                new BigDecimal("15000000"),
                Gender.MALE,
                LocalDate.of(2022, 3, 1)
        );
        dao.save(emp);

      // =========================================================
        // TODO 0.4 - READ
        // =========================================================

       Employee found = dao.findById(emp.getId());

        // [Lifecycle]
        // found la MANAGED trong EntityManager cua findById().
        //
        // Nhưng EntityManager da dong ngay truoc khi findById()
        // return -> found tro thanh DETACHED.

       System.out.println("\n===== READ =====");
        System.out.println("Doc lai: " + found);


        // =========================================================
        // TODO 0.4 - FIND ALL
        // =========================================================

        List<Employee> employees = dao.findAll();

        System.out.println("\n===== FIND ALL =====");

        for (Employee employee : employees) {
            System.out.println(employee);
        }


   */

        // =========================================================
        // TODO 0.5 - FIND BY SALARY AND ACTIVE
        // =========================================================

        System.out.println("\n===== FIND BY SALARY AND ACTIVE =====");

        List<Employee> highSalaryEmployees =
                dao.findBySalaryGreaterThanAndActive(
                        new BigDecimal("10000000")
                );

        for (Employee employee : highSalaryEmployees) {
            System.out.println(employee);
        }


        // =========================================================
        // TODO 0.5 - TEST NO RESULT
        // =========================================================

        System.out.println("\n===== FIND BY EMAIL - NO RESULT =====");

        Employee notFound =
                dao.findByEmail("notfound@fpt.edu.vn");

        System.out.println("Ket qua: " + notFound);
    }

    }

