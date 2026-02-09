package src;
public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private String email;
     private int leaveBalance = 20;

    public Employee (int employeeId, String name, String department, String email){
        this.employeeId = employeeId;
        this.name= name;
        this.department = department;
        this.email = email;
    }

    public int getLeaveBalance(){
        return leaveBalance;
    }

    
    public void setLeaveBalance(int leaveBalance){
        if(leaveBalance >= 0){
            this.leaveBalance = leaveBalance;
        }else{
            System.out.println("The leave balance cannot be negative");
        }
    }
}