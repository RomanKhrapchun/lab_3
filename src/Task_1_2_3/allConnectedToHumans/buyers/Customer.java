package Task_1_2_3.allConnectedToHumans.buyers;

import Task_1_2_3.allConnectedToHumans.check.Check;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Customer {

    private String name;

    private List<Check> customerCheck;

    public Customer(String name, List<Check> customerCheck) {
        this.name = name;
        this.customerCheck = customerCheck;
    }

    public List<Check> getCustomerCheck() {
        return customerCheck;
    }

    public void setCustomerCheck(List<Check> customerCheck) {
        this.customerCheck = customerCheck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(getName(), customer.getName()) && Objects.equals(getCustomerCheck(), customer.getCustomerCheck());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCustomerCheck());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", customerCheck=" + customerCheck +
                '}';
    }
}
