package src;

public class LeaveRequest {

    private int requestId;
    private Employee employee;
    private String startDate;
    private String endDate;
    private String status; //pending, Approved, Denied
    private String reason;
    private int leaveBalance = 20;

    public LeaveRequest(int requestId, Employee employee, String startDate,
            String endDate, String reason) {
        
        this.requestId = requestId;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "pending";
        this.reason = reason;
    }

    //getter method
    public int getLeaveBalance(){
        return leaveBalance;
    }

    //setter method
    public void setLeaveBalance(int leaveBalance){
        if(leaveBalance >= 0){
            this.leaveBalance = leaveBalance;
        }else{
            System.out.println("The leave balance cannot be negative");
        }
    }
}
