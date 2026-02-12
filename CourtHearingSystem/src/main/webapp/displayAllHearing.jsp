<%@ page import="java.util.*,com.wipro.court.bean.HearingBean" %>
<html>
<body>
<%
String msg=(String)request.getAttribute("msg");
List<HearingBean> list=(List<HearingBean>)request.getAttribute("list");
if(msg!=null){
%>
<%=msg%>
<%
}else if(list!=null){
for(HearingBean bean:list){
%>
<hr>
<%=bean.getRecordId()%><br>
<%=bean.getCaseNumber()%><br>
<%=bean.getPetitioner()%><br>
<%=bean.getRespondent()%><br>
<%=bean.getHearingDate()%><br>
<%=bean.getCourtroom()%><br>
<%=bean.getRemarks()%><br>
<%
}
}
%>
</body>
</html>
