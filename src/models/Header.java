package models;

public class Header {
    public String headerIdent;
    public String transCode;
    public char spacer1;
    public String counter;
    public char spacer2;
    public String date;
    public char spacer3;
    public String time;
    public String trailer;

    public String getHeaderIdent() {
        return headerIdent;
    }

    public void setHeaderIdent(String headerIdent) {
        this.headerIdent = headerIdent;
    }

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

    public char getSpacer1() {
        return spacer1;
    }

    public void setSpacer1(char spacer1) {
        this.spacer1 = spacer1;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    public char getSpacer2() {
        return spacer2;
    }

    public void setSpacer2(char spacer2) {
        this.spacer2 = spacer2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public char getSpacer3() {
        return spacer3;
    }

    public void setSpacer3(char spacer3) {
        this.spacer3 = spacer3;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
}
