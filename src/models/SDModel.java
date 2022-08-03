package models;

public class SDModel {
    private String transID;
    private char transAttempt;
    private String dateTime;
    private char actionUID;
    private String sdc;
    private int sdcDestID;
    private String sdcGenericDesc;
    private String sdcCapacity;
    private String sdcDesc;
    private String discipline;
    private double iuwkDef;
    private double iuthDef;
    private int numRegBlocks;

    private String regBlocks;

    public String getRegBlocks() {
        return regBlocks;
    }

    public void setRegBlocks(String regBlocks) {
        this.regBlocks = regBlocks;
    }

    public String getTransID() {
        return transID;
    }

    public void setTransID(String transID) {
        this.transID = transID;
    }

    public char getTransAttempt() {
        return transAttempt;
    }

    public void setTransAttempt(char transAttempt) {
        this.transAttempt = transAttempt;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public char getActionUID() {
        return actionUID;
    }

    public void setActionUID(char actionUID) {
        this.actionUID = actionUID;
    }

    public String getSdc() {
        return sdc;
    }

    public void setSdc(String sdc) {
        this.sdc = sdc;
    }

    public int getSdcDestID() {
        return sdcDestID;
    }

    public void setSdcDestID(int sdcDestID) {
        this.sdcDestID = sdcDestID;
    }

    public String getSdcGenericDesc() {
        return sdcGenericDesc;
    }

    public void setSdcGenericDesc(String sdcGenericDesc) {
        this.sdcGenericDesc = sdcGenericDesc;
    }

    public String getSdcCapacity() {
        return sdcCapacity;
    }

    public void setSdcCapacity(String sdcCapacity) {
        this.sdcCapacity = sdcCapacity;
    }

    public String getSdcDesc() {
        return sdcDesc;
    }

    public void setSdcDesc(String sdcDesc) {
        this.sdcDesc = sdcDesc;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public double getIuwkDef() {
        return iuwkDef;
    }

    public void setIuwkDef(double iuwkDef) {
        this.iuwkDef = iuwkDef;
    }

    public double getIuthDef() {
        return iuthDef;
    }

    public void setIuthDef(double iuthDef) {
        this.iuthDef = iuthDef;
    }

    public int getNumRegBlocks() {
        return numRegBlocks;
    }

    public void setNumRegBlocks(int numRegBlocks) {
        this.numRegBlocks = numRegBlocks;
    }
}
