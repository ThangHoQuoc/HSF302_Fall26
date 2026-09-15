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
        // CREATE
        // =====================================================

        // TODO 0.10 - NEW / TRANSIENT
        // Entity vua duoc tao bang new.
        // Luc nay Employee dang o trang thai NEW/TRANSIENT.
        // Entity chua duoc EntityManager quan ly.

        Employee emp = new Employee(

                "Nguyen Van T",
                "t@fpt.edu.vn",
                new BigDecimal("15000000"),
                Gender.MALE,
                LocalDate.of(2022, 3, 1)
        );

        System.out.println("===== CREATE =====");
        System.out.println("Employee truoc save: " + emp);


        dao.save(emp);


        // TODO 0.10 - MANAGED -> DETACHED
        // Trong save(), em.persist(emp) duoc goi.
        // -> emp chuyen sang MANAGED.
        //
        // Sau khi transaction commit va EntityManager dong:
        // -> emp chuyen sang DETACHED.

        System.out.println("Employee sau save: " + emp);
        System.out.println("ID sau save: " + emp.getId());


        // =====================================================
        // READ
        // =====================================================

        Employee found = dao.findById(emp.getId());

        // TODO 0.10 - MANAGED -> DETACHED
        // Trong findById(), em.find() load entity vao Persistence Context.
        // -> found dang o trang thai MANAGED.
        //
        // Khi EntityManager trong findById() dong:
        // -> found tro thanh DETACHED.

        System.out.println("\n===== READ =====");
        System.out.println("Employee tim thay: " + found);


        // =====================================================
        // UPDATE
        // =====================================================

        // found dang DETACHED.
        //
        // Thay doi field cua entity DETACHED
        // khong tu dong duoc dong bo xuong database.

        found.setSalary(new BigDecimal("17000000"));

        Employee updated = dao.update(found);


        // TODO 0.10 - MERGE
        // found ban dau la DETACHED.
        //
        // Trong update(), em.merge(found) duoc goi.
        //
        // merge() tra ve mot entity MANAGED moi.
        // -> updated la MANAGED trong Persistence Context.
        // -> found van la DETACHED.
        //
        // Sau khi EntityManager trong update() dong:
        // -> updated tro thanh DETACHED.

        System.out.println("\n===== UPDATE =====");
        System.out.println("Employee sau update: " + updated);


        // =====================================================
        // READ AFTER UPDATE
        // =====================================================

        Employee checkUpdate = dao.findById(emp.getId());

        System.out.println("\n===== READ AFTER UPDATE =====");
        System.out.println("Employee sau update: " + checkUpdate);


        // =====================================================
        // DELETE
        // =====================================================

        dao.delete(emp.getId());


        // TODO 0.10 - REMOVED
        // Trong delete():
        //
        // 1. em.find() -> entity MANAGED.
        // 2. em.remove(entity) -> entity REMOVED.
        // 3. transaction.commit() -> record bi DELETE khoi database.

        System.out.println("\n===== DELETE =====");
        System.out.println("Da xoa Employee co ID: " + emp.getId());


        // =====================================================
        // READ AFTER DELETE
        // =====================================================

        Employee checkDelete = dao.findById(emp.getId());

        System.out.println("\n===== READ AFTER DELETE =====");
        System.out.println("Ket qua sau khi xoa: " + checkDelete);


        // =====================================================
        // TODO 0.10 - LIFECYCLE SUMMARY
        // =====================================================

        /*
         * JPA ENTITY LIFECYCLE
         *
         * 1. NEW / TRANSIENT
         *    Employee emp = new Employee(...);
         *    -> Entity vua duoc tao.
         *    -> Chua duoc EntityManager quan ly.
         *
         *
         * 2. MANAGED
         *    em.persist(emp);
         *    -> Entity duoc Persistence Context quan ly.
         *
         *
         * 3. DETACHED
         *    EntityManager.close();
         *    -> Entity khong con duoc Persistence Context quan ly.
         *
         *
         * 4. MERGE
         *    Employee updated = em.merge(found);
         *    -> found van la DETACHED.
         *    -> updated la entity MANAGED.
         *
         *
         * 5. REMOVED
         *    em.remove(entity);
         *    -> Entity duoc danh dau REMOVED.
         *    -> commit() -> record bi xoa khoi database.
         */
    }


    }

