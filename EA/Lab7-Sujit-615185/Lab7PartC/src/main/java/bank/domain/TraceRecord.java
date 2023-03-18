package bank.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TraceRecord {
    @Id
    @GeneratedValue
    private long id;
    private Date date;
    private String recordDetails;
    public TraceRecord(){

    }
    public TraceRecord(Date date, String recordDetails){
        this.date=date;
        this.recordDetails=recordDetails;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getRecordDetails() {
        return recordDetails;
    }
    public void setRecordDetails(String recordDetails) {
        this.recordDetails = recordDetails;
    }
}
