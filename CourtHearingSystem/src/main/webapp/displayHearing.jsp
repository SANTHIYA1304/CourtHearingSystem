<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="com.wipro.court.bean.HearingBean" %>

<html>
<body>
<%
String msg = (String)request.getAttribute("msg");
HearingBean bean = (HearingBean)request.getAttribute("bean");
if(msg!=null){
%>
<%=msg%>
<%
}else if(bean!=null){
%>
<%=bean.getRecordId()%><br>
<%=bean.getCaseNumber()%><br>
<%=bean.getPetitioner()%><br>
<%=bean.getRespondent()%><br>
<%=bean.getHearingDate()%><br>
<%=bean.getCourtroom()%><br>
<%=bean.getRemarks()%><br>
<%
}
%>
</body>
</html>
