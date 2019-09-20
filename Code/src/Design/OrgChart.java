package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    private int id;
    private String name;
    private Employee supervisor;
    private List<Employee> supervisees;
    private int superviseesCount;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
        supervisor = null;
        supervisees = new ArrayList<>();
        superviseesCount = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public List<Employee> getSupervisees() {
        return supervisees;
    }

    public int getSuperviseesCount() {
        return superviseesCount;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
        supervisor.addSupervisee(this);
    }

    public void addSupervisee(Employee employee) {
        supervisees.add(employee);
        superviseesCount = 1 + superviseesCount + employee.superviseesCount;
    }

    public void removeSupervisee(Employee employee) {
        supervisees.remove(employee);
        superviseesCount--;
    }
}

public class OrgChart {

    private Map<Integer, Employee> employeeMap;

    public OrgChart() {
        employeeMap = new HashMap<>();
        employeeMap.put(-1, new Employee(-1, "Root"));
    }

    public void add(int id, String name, int superId) {
        Employee employee = new Employee(id, name);
        if (superId == 0)
            employee.setSupervisor(employeeMap.get(-1));
        else
            employee.setSupervisor(employeeMap.get(superId));
        employeeMap.put(id, employee);
    }

    public void remove(int id) {
        if (employeeMap.containsKey(id)) {
            Employee employee = employeeMap.get(id);
            for (Employee supervisee : employee.getSupervisees()) {
                supervisee.setSupervisor(employee.getSupervisor());
            }
            employee.getSupervisor().removeSupervisee(employee);
            employeeMap.remove(id);
        }
    }

    public void move(int id, int superId) {
        if (employeeMap.containsKey(id)) {
            Employee employee = employeeMap.get(id);
            if (employeeMap.containsKey(superId)) {
                employee.getSupervisor().removeSupervisee(employee);
                employee.setSupervisor(employeeMap.get(superId));
            }
        }
    }

    public int count(int id) {
        if (employeeMap.containsKey(id))
            return employeeMap.get(id).getSuperviseesCount();
        return 0;
    }

    public void print(Employee employee, int indent) {
        for (int i = 0; i < indent; i++)
            System.out.print(" ");
        System.out.println(employee.getId() + ": " + employee.getName());
        for (Employee supervisee : employee.getSupervisees()) {
            print(supervisee, indent + 1);
        }
    }

    public void print() {
        print(employeeMap.get(-1), 0);
    }

    public static void main(String[] args) {
        OrgChart obj = new OrgChart();
        obj.add(1, "a", 0);
        obj.add(2, "b", 1);
        obj.add(3, "c", 0);
        obj.add(4, "d", 2);
        obj.add(5, "e", 3);
        obj.add(6, "f", 0);
        obj.add(7, "g", 3);
        obj.print();

    }
}
