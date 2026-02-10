package src;

import java.time.LocalDate;

public class SickLeaveRequest extends LeaveRequest {

    private boolean medicalCertificateProvided;

    public SickLeaveRequest(int requestId, Employee employee, LocalDate startDate, LocalDate endDate, String reason,
            boolean medicalCertificateProvided) {

        super(requestId, employee, startDate, endDate, "SickLeave");

        this.medicalCertificateProvided = medicalCertificateProvided;
    }

    public boolean isMedicalCertificateProvided() {
        return medicalCertificateProvided;
    }

    
    public boolean processRequest() {
        if (medicalCertificateProvided == false && this.getDuration() > 2) {
            System.out.println("Sick leave longer than 2 days requires a medical certificate");
            return false;
        } else {
            System.out.println("Processing sick leave request...");
            return true;
        }
    }

}
