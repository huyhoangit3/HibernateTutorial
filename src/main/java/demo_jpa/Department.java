package demo_jpa;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "department")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Employee> employees;
    public void addEmployee(Employee... employees) {
        for (Employee e : employees) {
            this.employees.add(e);
            e.setDepartment(this);
        }
    }
}
