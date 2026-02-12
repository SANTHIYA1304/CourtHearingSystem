package com.wipro.court.bean;

import java.util.Date;

public class HearingBean {

    private String recordId;
    private String caseNumber;
    private String petitioner;
    private String respondent;
    private Date hearingDate;
    private String courtroom;
    private String remarks;

    public String getRecordId() { return recordId; }
    public void setRecordId(String recordId) { this.recordId = recordId; }

    public String getCaseNumber() { return caseNumber; }
    public void setCaseNumber(String caseNumber) { this.caseNumber = caseNumber; }

    public String getPetitioner() { return petitioner; }
    public void setPetitioner(String petitioner) { this.petitioner = petitioner; }

    public String getRespondent() { return respondent; }
    public void setRespondent(String respondent) { this.respondent = respondent; }

    public Date getHearingDate() { return hearingDate; }
    public void setHearingDate(Date hearingDate) { this.hearingDate = hearingDate; }

    public String getCourtroom() { return courtroom; }
    public void setCourtroom(String courtroom) { this.courtroom = courtroom; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}
