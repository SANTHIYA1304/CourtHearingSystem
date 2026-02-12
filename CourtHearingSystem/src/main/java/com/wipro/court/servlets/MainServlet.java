package com.wipro.court.servlets;

import com.wipro.court.bean.HearingBean;
import com.wipro.court.service.Administrator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    Administrator admin = new Administrator();
    public String addRecord(HttpServletRequest request) {
       try {
            HearingBean bean = new HearingBean();
            bean.setCaseNumber(request.getParameter("caseNumber"));
            bean.setPetitioner(request.getParameter("petitioner"));
            bean.setRespondent(request.getParameter("respondent"));
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hearingDate"));
            bean.setHearingDate(date);
            bean.setCourtroom(request.getParameter("courtroom"));
            bean.setRemarks(request.getParameter("remarks"));
            return admin.addRecord(bean);
        } catch (Exception e) {
            return "FAIL";
        }
    }
    public HearingBean viewRecord(HttpServletRequest request) {
        try {
            String caseNumber = request.getParameter("caseNumber");
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hearingDate"));
            return admin.viewRecord(caseNumber, date);
        } catch (Exception e) {
            return null;}}
    public List<HearingBean> viewAllRecords(HttpServletRequest request) {
        return admin.viewAllRecords();}
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("operation");
        try {
            if ("newRecord".equals(op)) {
                String res = addRecord(request);
                if ("FAIL".equals(res))
                    response.sendRedirect("error.html");
                else
                    response.sendRedirect("success.html");}
            else if ("viewRecord".equals(op)) {
                HearingBean bean = viewRecord(request);
                if (bean == null) {
                    request.setAttribute("msg",
                            "No matching records exists! Please try again!"); } 
                else 
                { request.setAttribute("bean", bean);}
                RequestDispatcher rd =
                        request.getRequestDispatcher("displayHearing.jsp");
                rd.forward(request, response);}
            else if ("viewAllRecords".equals(op)) {
                List<HearingBean> list = viewAllRecords(request);
                if (list.isEmpty())
                    request.setAttribute("msg", "No records available!");
                else
                    request.setAttribute("list", list);
                RequestDispatcher rd =
                        request.getRequestDispatcher("displayAllHearing.jsp");
                rd.forward(request, response);}}
        catch (Exception e) {
            response.sendRedirect("error.html");}}
}