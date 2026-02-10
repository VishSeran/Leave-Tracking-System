package src;

public interface Approve {
    
    boolean approve(String approverName);
    boolean deny(String approverName, String reason);
}
