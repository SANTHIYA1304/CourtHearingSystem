package com.wipro.court.dao;

import com.wipro.court.bean.HearingBean;
import com.wipro.court.util.DBUtil;

import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class HearingDAO {
    public String createRecord(HearingBean hearingBean) {
        String result = "FAIL";
        try (Connection conn = DBUtil.getDBConnection()) {
            String sql = "INSERT INTO HEARING_TB VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hearingBean.getRecordId());
            ps.setString(2, hearingBean.getCaseNumber());
            ps.setString(3, hearingBean.getPetitioner());
            ps.setString(4, hearingBean.getRespondent());
            ps.setDate(5, new java.sql.Date(hearingBean.getHearingDate().getTime()));
            ps.setString(6, hearingBean.getCourtroom());
            ps.setString(7, hearingBean.getRemarks());
            int rows = ps.executeUpdate();
            if (rows > 0) result = hearingBean.getRecordId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;}
    public HearingBean fetchRecord(String caseNumber, Date hearingDate) {
        HearingBean bean = null;
        try (Connection conn = DBUtil.getDBConnection()) {
            String sql = "SELECT * FROM HEARING_TB WHERE CASENUMBER=? AND HEARING_DATE=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, caseNumber);
            ps.setDate(2, new java.sql.Date(hearingDate.getTime()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                bean = new HearingBean();
                bean.setRecordId(rs.getString(1));
                bean.setCaseNumber(rs.getString(2));
                bean.setPetitioner(rs.getString(3));
                bean.setRespondent(rs.getString(4));
                bean.setHearingDate(rs.getDate(5));
                bean.setCourtroom(rs.getString(6));
                bean.setRemarks(rs.getString(7));}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;}
    public String generateRecordID(String caseNumber, Date hearingDate) {
        String recordId = null;
        try (Connection conn = DBUtil.getDBConnection()) {
            DateFormat format = new SimpleDateFormat("yyyyMMdd");
            String temp = format.format(hearingDate);
            String prefix = caseNumber.substring(0, 2).toUpperCase();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT HEARING_SEQ.NEXTVAL FROM DUAL");
            if (rs.next()) {
                int seq = rs.getInt(1);
                recordId = temp + prefix + seq;}
        } catch (Exception e) {
            e.printStackTrace();}
        return recordId;}
    public boolean recordExists(String caseNumber, Date hearingDate) {
        boolean exists = false;
        try (Connection conn = DBUtil.getDBConnection()) {
            String sql = "SELECT 1 FROM HEARING_TB WHERE CASENUMBER=? AND HEARING_DATE=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, caseNumber);
            ps.setDate(2, new java.sql.Date(hearingDate.getTime()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) exists = true;
        } catch (Exception e) {
            e.printStackTrace();}
        return exists;}
    public List<HearingBean> fetchAllRecords() {
        List<HearingBean> list = new ArrayList<>();
        try (Connection conn = DBUtil.getDBConnection()) {
            String sql = "SELECT * FROM HEARING_TB";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                HearingBean bean = new HearingBean();
                bean.setRecordId(rs.getString(1));
                bean.setCaseNumber(rs.getString(2));
                bean.setPetitioner(rs.getString(3));
                bean.setRespondent(rs.getString(4));
                bean.setHearingDate(rs.getDate(5));
                bean.setCourtroom(rs.getString(6));
                bean.setRemarks(rs.getString(7));
                list.add(bean);}
        } catch (Exception e) {
            e.printStackTrace();}
        return list;
    }}
