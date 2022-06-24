package models;

public class IDModel {
    private String transID;
    private char attemptCount;
    private String dateTime;
    private int scheduleID;
    private int itemID;

    private char REC_NULL;

    public char getREC_NULL() {
        return REC_NULL;
    }

    public void setREC_NULL(char REC_NULL) {
        this.REC_NULL = REC_NULL;
    }

    public String getTransID() {
        return transID;
    }

    public void setTransID(String transID) {
        this.transID = transID;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public void setAttemptCount(char attemptCount) {
        this.attemptCount = attemptCount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
}
