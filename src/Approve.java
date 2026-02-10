package src;

public interface Approve {
    
    boolean approve(String approverName, String reason);
    boolean deny(String approverName, String reason);
}
