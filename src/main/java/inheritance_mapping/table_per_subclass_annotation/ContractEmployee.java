package inheritance_mapping.table_per_subclass_annotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "contract_employee")
@PrimaryKeyJoinColumn(name = "e_id")
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
