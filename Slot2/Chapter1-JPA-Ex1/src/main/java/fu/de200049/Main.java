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

        // =====================================================
        // TODO 0.8 - CREATE
        // =====================================================

        Employee emp = new Employee(
                "Nguyen Van E",
                "e@fpt.edu.vn",
                new BigDecimal("15000000"),
                Gender.MALE,
                LocalDate.of(2022, 3, 1)
        );

        dao.save(emp);

        System.out.println("===== CREATE =====");
        System.out.println("Employee da tao: " + emp);
        System.out.println("ID: " + emp.getId());


        // =====================================================
        // TODO 0.8 - READ
        // =====================================================

        Employee found = dao.findById(emp.getId());

        System.out.println("\n===== READ =====");
        System.out.println("Employee tim thay: " + found);


        // =====================================================
        // TODO 0.8 - UPDATE
        // =====================================================

        found.setSalary(new BigDecimal("17000000"));

        Employee updated = dao.update(found);

        System.out.println("\n===== UPDATE =====");
        System.out.println("Employee sau khi update: " + updated);


        // =====================================================
        // TODO 0.8 - READ AFTER UPDATE
        // =====================================================

        Employee checkUpdate = dao.findById(emp.getId());

        System.out.println("\n===== READ AFTER UPDATE =====");
        System.out.println("Employee sau update: " + checkUpdate);


        // =====================================================
        // TODO 0.8 - DELETE
        // =====================================================

        dao.delete(emp.getId());

        System.out.println("\n===== DELETE =====");
        System.out.println("Da xoa Employee co ID: " + emp.getId());


        // =====================================================
        // TODO 0.8 - READ AFTER DELETE
        // =====================================================

        Employee checkDelete = dao.findById(emp.getId());

        System.out.println("\n===== READ AFTER DELETE =====");
        System.out.println("Ket qua: " + checkDelete);
    }


    }

