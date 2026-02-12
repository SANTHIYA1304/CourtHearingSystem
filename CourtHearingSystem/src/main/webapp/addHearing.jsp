<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<form action="MainServlet" method="post">

<input type="hidden" name="operation" value="newRecord">

Case Number:
<input type="text" name="caseNumber"><br>

Petitioner:
<input type="text" name="petitioner"><br>

Respondent:
<input type="text" name="respondent"><br>

Hearing Date:
<input type="date" name="hearingDate"><br>

Courtroom:
<input type="text" name="courtroom"><br>

Remarks:
<input type="text" name="remarks"><br>

<input type="submit" value="Submit">

</form>
</body>
</html>
