
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
String strHostName =java.net.InetAddress.getLocalHost().getHostName();
if (strHostName.length() > 2) {
	strHostName = strHostName.substring(strHostName.length() - 2); 
	}%>
<HTML>
<HEAD>
<SCRIPT type="text/javascript" src="<%=request.getContextPath()%>/scripts/searching.js">
</SCRIPT>

<link media="screen" rel="stylesheet" href="colorbox.css" />
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script src="jquery.colorbox-min.js" type="text/javascript"></script>
 
<script type="text/javascript">
    $(function()
    {
        $('#link_content').colorbox({opacity:0.3});
    });
</script>
<script language="javascript">

function openDetailPage(url,w,h,x,y){
if(!isNaN(w) && !isNaN(h) && !isNaN(x)  && !isNaN(y))
{ 
window.open(url,'',"resizable=yes,toolbar=no,scrollbars=no,menubar=no,status=no,directories=no,width="+w+",height="+h+",left="+x+",top="+y+"");
}
else
{
alert("Not valid");
}
}                    

</script>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="<%=request.getContextPath()%>/theme/Master.css"
	rel="stylesheet" type="text/css">
<TITLE>Provider Lookup: <%=strHostName%></TITLE>
</HEAD>
<BODY>
<table cellspacing=0 cellpadding=0 border=0 width=100%>
	<tr>
		<td colspan=3><img
			src="<%=request.getContextPath()%>/images/clear.gif" border=0 alt=""
			width=1 height=5 border=0></td>
	</tr>
	<tr>
		<td valign="top" width="15%" bgcolor="#F5FAFA" align="left"><jsp:include
			page="/includes/SideBar.jsp" flush="true" /></td>
		<td><img src="<%=request.getContextPath()%>/images/clear.gif"
			width="0" height="62" border=0></td>
		<td width="83%" align="left" valign="top">
		<table width="100%" cellpadding="5" cellspacing="0" border="0"
			bgcolor="white" ID="Table1">
			
			<%
				 if (request.getAttribute("providersForDisplay") != null) {
                    ArrayList al = (ArrayList) request.getAttribute("providersForDisplay");
                    System.out.println(al);
                    Iterator itr = al.iterator();
                    while (itr.hasNext()) {
 
                       
                        ArrayList providersForDisplay = (ArrayList) itr.next();
            %>
			<tr>
				<td align="center">

				<table border="0" bgcolor="black" cellspacing="1">
					<tbody>
						<tr>
							<td width="423">
							<table bgcolor="#E8E7D2" cellspacing="0" cellpadding="2"
								border="0" width="100%">
								<tr>
									<td colspan="5" class="sbold" align="center" bgcolor="#AAC0CD">Search
									Criteria</td>
								</tr>
								<tr>
									<td class="sbold" align="right" nowrap width="94">ProvBaseNum:</td>
									<td class="small" align="left" nowrap="nowrap" width="132">
									<%=providersForDisplay.get(0) %>
									Not Specified
								
									</td>
									<td width="1"><img src="images/clear.gif" width="10"
										height="0" border="0"></td>
										<%=providersForDisplay.get(2) %>
									<td class="sbold" align="right" nowrap="nowrap" width="95">Provider
									Type:</td>
									<td class="small" align="left" nowrap="nowrap">
									<%=providersForDisplay.get(4) %>
										</td>
									
								</tr>

								<tr>
									<td class="sbold" align="right" width="94">Last Name:</td>
									<td class="small" align="left" nowrap="nowrap" width="132"><%=providersForDisplay.get(5) %></td>
									<td width="1"><img src="images/clear.gif" width="10"
										height="0" border="0"></td>
									<td class="sbold" align="right" nowrap="nowrap">Provider Location:</td>
									<td class="small" align="left" nowrap="nowrap">
									<%=providersForDisplay.get(6) %>
									</td>
								<td>	Firstname :</td>
									<td> <%=providersForDisplay.get(8) %>
									</td>
									<td class="sbold" align="right" nowrap="nowrap">Provider Address1:</td>
									<td> <%=providersForDisplay.get(9) %></td>
									<td class="sbold" align="right" nowrap="nowrap">Provider Address2:</td>
									<td> <%=providersForDisplay.get(10) %></td>
									<td class="sbold" align="right" nowrap="nowrap"></td>
									<td> <%=providersForDisplay.get(11) %></td>
									<td class="sbold" align="right" nowrap="nowrap"></td>
									<td> <%=providersForDisplay.get(12) %></td>
									<td class="sbold" align="right" nowrap="nowrap"></td>
									<td> <%=providersForDisplay.get(13) %></td>
									
								</tr>
								<tr>
									<tr>
																<td class="r" nowrap="nowrap">NPI:<b><s:property
																	value="provNpi" />&nbsp;</b></td>
															</tr>
									<td> <%=providersForDisplay.get(14) %></td>
							
								</tr>
							</table>
							</td>
						</tr>
					</tbody>
				</table>
				</td>
			</tr>
			<tr>
				<td>
				<hr>
				</td>
			</tr>
			<tr>
				<td class="rbold" align="center">

				<table width='100%' border=0 cellpadding=0 bgcolor="#AAC0CD">
					
					
				</table>

				</td>
			</tr>
			<%-- Iterate all providers in the list--%>
			
			<s:iterator value="providersForDisplay">
				<tr>
					<td align='center' width='100%'>
					<table border=0 bgcolor='#AAC0CD' cellspacing='0' cellpadding='1'>
						<tr>
							<td width='428'>
							<table border=0 bgcolor='#FFFFFF' cellspacing='0' cellpadding='1'>
								<tr>
									<td width='430'>
									<table bgcolor='#E8E7D2' cellspacing='0' cellpadding='6'
										width='100%'>
										<tr>
											<td width='426'>
											<table width='82%' border=0 cellpadding=0 bgcolor='#E8E7D2'
												cellspacing='5'>

												<tr>
													<td nowrap align='left' nowrap colspan='2' valign="top">
													<table width="100%" border="0" cellpadding="1"
														cellspacing="1">
														<tbody>
															<tr>
																<td class="rbold" nowrap="nowrap"><s:property
																	value="provFullName" /></td>
															</tr>
															<tr>
																<td class="small" nowrap="nowrap"><s:property
																	value="provAddLine1" /></td>
															</tr>
															<tr>
																<td class="small" nowrap="nowrap"><s:property
																	value="provAddLine2" /></td>
															</tr>
															<tr>
																<td class="small" nowrap="nowrap"><s:property
																	value="provCity" />, <s:property value="provState" />&nbsp;<s:property
																	value="provZip" /></td>
															</tr>
															<tr>
																<td class="small" nowrap="nowrap"><s:property
																	value="provTeleNum" /></td>
															</tr>
														</tbody>
													</table>
													</td>
													<td nowrap class='r'><img
														src="<%=request.getContextPath()%>/images/clear.gif"
														width=80 height=10 border=0></td>
													<td align='left' class='r' nowrap colspan='2' valign="top">
													<table width="100%" border="0" cellpadding="1"
														cellspacing="1">
														<tbody>
															<tr>
																<td class="r" nowrap="nowrap">Provider Number:<b><s:property
																	value="provBaseNum" />&nbsp;</b></td>
															</tr>
															
															<tr>
																<td class="r" nowrap="nowrap">NPI:<b><s:property
																	value="provNpi" />&nbsp;</b></td>
															</tr>
															</s:if>
															
															<tr>
																<td class="sbold"></td>
															</tr>
															<tr>
																<td class="sbold"></td>
															</tr>
														</tbody>
													</table>
												</tr>
												<tr>
													<td nowrap align='left' class='small' nowrap colspan='5'>
													</td>
												</tr>
												<tr>
													
													<td nowrap class='r'><img
														src="<%=request.getContextPath()%>/images/clear.gif"
														width=20 height=10 border=0></td>
													<td align='left' class='r' nowrap="nowrap"></td>
												</tr>
												<tr>
													<td nowrap class='r' colspan='5'><img
														src="<%=request.getContextPath()%>/images/clear.gif"
														width='700' height='20' border=0></td>
												</tr>
												<tr>
													<td nowrap align='left' class='r' nowrap colspan='5'>Managed
													Care Organization(s):</td>
												</tr>
												
												
											</table>
											</td>
										</tr>
									</table>
									</td>
								</tr>
							</table>
							</td>
						</tr>
					</table>
					</td>
				</tr>
				
			</s:iterator>
			<%-- Iterate all providers in the list ends here--%>
			<tr>
				<td class="rbold" align="center">

				<table width='100%' border=0 cellpadding=0 bgcolor="#AAC0CD">
					<tr>
						<td align="left" class="rbold" width="279"></td>
						
					</tr>
					
				</table>

				</td>
			</tr>

		</table>
		</td>
	</tr>
	<tr>
		<td colspan="2"><img
			src="<%=request.getContextPath()%>/images/clear.gif" border=0 alt=""
			width=1 height=1 border=0></td>
		<td align="center"><jsp:include page="/includes/Footer.jsp"
			flush="true" /></td>
	</tr>
</table>
</BODY>
</HTML>
