import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public Connection connection;
    public PreparedStatement prepareStatement;
    public ResultSet resultSet;

    ArrayList<EmployeeData> employeeDataArrayList = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.accessEmployeeData();
        main.showEmployeeDataList();
        main.updateEmployeeData();
    }

    public Connection getConnection() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String databaseURL = "jdbc:mysql://localhost:3306/payroll_service";
            String username = "root";
            String password = "D@r$h9899#";
            Class.forName(driver);

            Connection connection = DriverManager.getConnection(databaseURL, username, password);
            return connection;

        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new UserException(UserException.ExceptionType.SQLException, "The Database Connection Not Closed Properly.");
        }
    }

    public void accessEmployeeData() {
        getConnection();
        try {
            prepareStatement = connection.prepareStatement("select * from employee_payroll");
            resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                employeeDataArrayList.add(new EmployeeData(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getInt(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7), resultSet.getInt(8),
                        resultSet.getInt(9), resultSet.getInt(10),
                        resultSet.getInt(11), resultSet.getInt(12)));
            }
        } catch (SQLException e) {
            throw new UserException(UserException.ExceptionType.SQLException, "The SQL Query is Not Properly Executed");
        } finally {
            closeConnection();
        }
    }

    public void updateEmployeeData() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Salary : ");
            long salary = sc.nextLong();
            System.out.println("Enter the Employee Name : ");
            String employeeName = sc.next();

            getConnection();
            prepareStatement = connection.prepareStatement("update employee_payroll set salary=? where name=?");
            prepareStatement.setLong(1, salary);
            prepareStatement.setString(2, employeeName);
            int rows = prepareStatement.executeUpdate();
            System.out.println(rows + " Rows Updated.");
            employeeDataArrayList.stream().forEach(x -> {
                if ((x.getName().equalsIgnoreCase(employeeName))) {
                    x.setSalary(salary);
                } else {
                    x.setSalary(x.getSalary());
                }
            });
            showEmployeeDataList();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void showEmployeeDataList() {
        try {
            for (EmployeeData employeeData : employeeDataArrayList) {
                System.out.println(employeeData.toString());
            }
        } catch (NullPointerException e) {
            throw new UserException(UserException.ExceptionType.NullList, "Employee Data List is Empty.");
        }
    }
}