package src;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;



public class LeaveRequest {

    private int requestId;
    private Employee employee;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status; //pending, Approved, Denied
    private String reason;
   

    public LeaveRequest(int requestId, Employee employee, LocalDate startDate,
            LocalDate endDate, String reason) {
        
        this.requestId = requestId;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "pending";
        this.reason = reason;
    }   

    public boolean processRequest(){
        System.out.println("Processing generic leave request...");
        return true;
    }

    public float getDuration() {
    
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        float duration = (float) days;
        return duration;
    }   
}


