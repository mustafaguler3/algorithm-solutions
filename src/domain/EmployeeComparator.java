package domain;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        //first , compare by name
        int nameComparison = o1.getName().compareTo(o2.getName());
        if (nameComparison != 0){
            return nameComparison;
        }
        // if names are equal, compare by age
        int ageComparison = Integer.compare(o1.getAge(),o2.getAge());
        if (ageComparison != 0){
            return ageComparison;
        }
        // if ages are also equal, compare by address
        return o1.getAddress().compareTo(o2.getAddress());
    }

}





















