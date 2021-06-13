package inheritance_mapping.table_per_subclass_xml;

public class RegularEmployee extends Employee {
    private double salary;
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
