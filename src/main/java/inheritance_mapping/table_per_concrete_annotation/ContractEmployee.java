package inheritance_mapping.table_per_concrete_annotation;

import javax.persistence.*;

@Entity
@Table(name = "contract_employee")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "e_id")),
        @AttributeOverride(name = "name", column = @Column(name = "e_name"))
})
public class ContractEmployee extends Employee {
    @Column(name = "pay_per_hour")
    private double payPerHour;
    @Column(name = "contract_period")
    private String contractPeriod;

    public double getPayPerHour() {
        return payPerHour;
    }

    public void setPayPerHour(double payPerHour) {
        this.payPerHour = payPerHour;
    }

    public String getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(String contractPeriod) {
        this.contractPeriod = contractPeriod;
    }
}
