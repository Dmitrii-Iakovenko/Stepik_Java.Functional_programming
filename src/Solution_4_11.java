import java.util.List;

// 4.11 The general number of employees
// https://stepik.org/lesson/35851/step/1?unit=15015
public class Solution_4_11 {

    public static void main(String[] args) {
        List<Department> departments = List.of(
                new Department("dep-1", "111-1", List.of(
                        new Employee("William", 20000L),
                        new Employee("Sophia", 10000L)
                )),

                new Department("dep-2", "222-1", List.of(
                        new Employee("John", 50000L)
                ))
        );

        System.out.println(calcNumberOfEmployees(departments, 20000L));
    }


    /**
     * Calculates the number of employees with salary >= threshold (only for 111- departments)
     *
     * @param departments are list of departments
     * @param threshold is lower edge of salary
     *
     * @return the number of employees
     */
    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        return departments.stream()
                .filter(department -> department.getCode().startsWith("111-"))
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getSalary() >= threshold)
                .count();
    }


    private static class Employee {
        private final String name;
        private final Long salary;

        public String getName() {
            return name;
        }

        public Long getSalary() {
            return salary;
        }

        public Employee(String name, Long salary) {
            this.name = name;
            this.salary = salary;
        }
    }


    private static class Department {
        private final String name;
        private final String code;
        private final List<Employee> employees;

        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public Department(String name, String code, List<Employee> employees) {
            this.name = name;
            this.code = code;
            this.employees = employees;
        }
    }


}