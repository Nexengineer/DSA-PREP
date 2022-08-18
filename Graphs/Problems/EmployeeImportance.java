package Graphs.Problems;
import java.util.*;
//[Medium]: https://leetcode.com/problems/employee-importance/

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class EmployeeImportance {
    Map<Integer, Employee> employeeMap ;
    public int doDFS(int id, List<Integer> visited){
        Employee emp = employeeMap.get(id);
        int sum = emp.importance;
        visited.add(emp.id);
        for (Integer subid: emp.subordinates)
            sum += doDFS(subid, visited);
        return sum;
    }
    public int getImportance(List<Employee> employees, int id) {
        if(employees.size() <= 0){
            return 0;
        }
        employeeMap = new HashMap<>();
        for(Employee e : employees){
            employeeMap.put(e.id, e);
        }
        
        return doDFS(id, new ArrayList<Integer>());
    }
}
