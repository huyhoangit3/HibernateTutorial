package inheritance_mapping.table_per_subclass_annotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "regular_employee")
@PrimaryKeyJoinColumn(name = "e_id")
public class RegularEmployee extends Employee {
    @Column(name = "salary")
    private double salary;
    @Column(name = "bonus")
    private int bonus;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
