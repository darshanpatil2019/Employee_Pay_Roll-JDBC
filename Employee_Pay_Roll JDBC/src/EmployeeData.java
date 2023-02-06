public class EmployeeData {
    int id;
    String name;
    long salary;
    String startDate;
    String phone;
    String address;
    String department;
    int basicPay;
    int deduction;
    int taxablePay;
    int incomeTax;
    int netPay;

    public EmployeeData(int id, String name, long salary, String startDate, String phone, String address, String department, int basicPay, int deduction, int taxablePay, int incomeTax, int netPay) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.startDate = startDate;
        this.phone = phone;
        this.address = address;
        this.department = department;
        this.basicPay = basicPay;
        this.deduction = deduction;
        this.taxablePay = taxablePay;
        this.incomeTax = incomeTax;
        this.netPay = netPay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(int basicPay) {
        this.basicPay = basicPay;
    }

    public int getDeduction() {
        return deduction;
    }

    public void setDeduction(int deduction) {
        this.deduction = deduction;
    }

    public int getTaxablePay() {
        return taxablePay;
    }

    public void setTaxablePay(int taxablePay) {
        this.taxablePay = taxablePay;
    }

    public int getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(int incomeTax) {
        this.incomeTax = incomeTax;
    }

    public int getNetPay() {
        return netPay;
    }

    public void setNetPay(int netPay) {
        this.netPay = netPay;
    }
}