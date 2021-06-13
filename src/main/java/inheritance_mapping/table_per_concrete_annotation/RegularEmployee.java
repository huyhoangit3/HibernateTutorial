package inheritance_mapping.table_per_concrete_annotation;

import javax.persistence.*;

@Entity
@Table(name = "regular_employee")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name="e_id")),
        @AttributeOverride(name = "name", column = @Column(name="e_name"))
})
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
