package com.wipro.court.service;

import com.wipro.court.bean.HearingBean;
import com.wipro.court.dao.HearingDAO;
import com.wipro.court.util.InvalidInputException;

import java.util.*;

public class Administrator {
    HearingDAO dao = new HearingDAO();
    public String addRecord(HearingBean hearingBean) {
        try {
            if (hearingBean == null ||
                hearingBean.getCaseNumber() == null ||
                hearingBean.getHearingDate() == null)
                throw new InvalidInputException();
            if (hearingBean.getCaseNumber().length() < 2)
                return "INVALID CASE NUMBER";
            if (dao.recordExists(
                    hearingBean.getCaseNumber(),
                    hearingBean.getHearingDate()))
                return "ALREADY EXISTS";
            String id = dao.generateRecordID(
                    hearingBean.getCaseNumber(),
                    hearingBean.getHearingDate());
            hearingBean.setRecordId(id);
            return dao.createRecord(hearingBean);}
        catch (InvalidInputException e) {
            return "INVALID INPUT";
        }}
    public HearingBean viewRecord(String caseNumber, Date hearingDate) {
        return dao.fetchRecord(caseNumber, hearingDate);}

    public List<HearingBean> viewAllRecords() {
        return dao.fetchAllRecords(); }}
