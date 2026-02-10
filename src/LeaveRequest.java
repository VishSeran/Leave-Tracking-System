package src;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;



public abstract class LeaveRequest implements Approve {

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

    public abstract  boolean processRequest();

    public float getDuration() {
    
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        float duration = (float) days;
        return duration+1;
    }   

    public abstract int calculateLeaveDays();

    private ArrayList<StatusChange> statusHistory = new ArrayList<>();

    public class StatusChange {
        private String oldStatus;
        private String newStatus;
        private LocalDate changeDate;
        private String changeBy;
        private String reason;


        public StatusChange (String oldStatus, String newStatus, LocalDate changeDate, String changeBy, String reason){
            this.oldStatus = oldStatus;
            this.newStatus = newStatus;
            this.changeDate = changeDate;
            this.changeBy = changeBy;
            this.reason = reason;
        }

    

    }

    public void changeStatus (String newStatus, String changeBy, LocalDate changDate, String reason){
        String oldStatus = this.status;
        this.status = newStatus;

        //create a new object and add to the arrrayList
        StatusChange change = new StatusChange(oldStatus, newStatus, changDate, changeBy, reason);
        statusHistory.add(change);

    }   

    @Override
    public boolean approve(String approverName,String reason){
        changeStatus("Approved", approverName, LocalDate.now(), reason);
        return true;
    }

    @Override
    public boolean deny (String approverName, String reason){
        changeStatus("Denied", approverName, LocalDate.now(), reason);
        return true;
    }
}


