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
        Employee emp = new Employee(
                "Nguyen Van D",
                "d@fpt.edu.vn",
                new BigDecimal("15000000"),
                Gender.MALE,
                LocalDate.of(2022, 3, 1)
        );
        dao.save(emp);

     // =========================================================
        // TODO 0.4 - READ
        // =========================================================

       Employee found = dao.findById(emp.getId());
/*
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



        // =========================================================
        // TODO 0.6 - UPDATE
        // =========================================================

        // found hien tai la DETACHED
        // Vi EntityManager cua findById() da dong.
        //
        // Thay doi object DETACHED khong tu dong update DB.
        found.setSalary(new BigDecimal("17000000"));

        Employee updated = dao.update(found);

        // TODO 0.10 - Lifecycle: MERGE
        // em.merge(found) khong bien found thanh MANAGED.
        //
        // merge() tao/tra ve mot object MANAGED moi.
        // Object found ban dau van la DETACHED.
        //
        // Sau khi EntityManager trong update() dong,
        // updated cung tro thanh DETACHED.

        System.out.println("\n===== UPDATE =====");
        System.out.println("Employee sau update: " + updated);


        // =========================================================
        // TODO 0.6 - READ AFTER UPDATE
        // =========================================================

        Employee checkUpdate = dao.findById(emp.getId());

        System.out.println("\n===== READ AFTER UPDATE =====");
        System.out.println("Salary sau update: "
                + checkUpdate.getSalary());
*/
        // =========================================================
        // TODO 0.7 - DELETE
        // =========================================================

        dao.delete(emp.getId());

        // TODO 0.10 - Lifecycle: REMOVED
        // Trong delete():
        //
        // 1. em.find() -> entity MANAGED
        // 2. em.remove() -> entity REMOVED
        // 3. commit() -> DELETE record trong database

        System.out.println("\n===== DELETE =====");
        System.out.println("Da xoa employee ID: " + emp.getId());


        // =========================================================
        // TODO 0.7 - READ AFTER DELETE
        // =========================================================

        Employee checkDelete = dao.findById(emp.getId());

        System.out.println("\n===== READ AFTER DELETE =====");
        System.out.println("Ket qua sau khi xoa: " + checkDelete);

        // Ky vong:
        // checkDelete == null

    }


    }

