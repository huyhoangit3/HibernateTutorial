package inheritance_mapping.table_per_hierarchy_annotation;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "reg_emp")
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
