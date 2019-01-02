

<Form name="frmSearchProvider" id="frmSearchProvider"
	 action="../ProvController" >
<table cellpadding="0" cellspacing="0" align="center" border="1"
	width="100%" bgcolor="#cccccc">
	<tr>
		<td class="sBold" colspan="4" bgcolor="#ffffce">
			Only the providers already enrolled in the system can be searched. 
		</td>
	</tr>
	<tr>
		<td class="rBold" nowrap="nowrap" align="center" width="35%">
		Provider Search</td>
		<td class="rBold" nowrap="nowrap" align="center" colspan="3"></td>
	</tr>
	<tr>
		<td class="small" nowrap="nowrap" align="center" valign="top">
		<table cellspacing="0" cellpadding="1" width="100%">
			<tr>
				<td nowrap="nowrap" class="sBold" align="left" valign="top" width="25%">Provider Base Num:</td>
				<td nowrap="nowrap" class="rBold" align="left" valign="top">
				
				<INPUT type="text"
					maxlength="7" size="8" name=provBaseNum " id="provBaseNum" >
				</td>;
			</tr>
				
				
				
				
						
			<tr>
				<td align="left" nowrap="nowrap" class="small" colspan="2">
					<tr>
													<td nowrap align='right' class='r'>Provider Type:</td>
													<td><img
														src="<%=request.getContextPath()%>/images/clear.gif"
														width="10" height="20" border=0></td>
													<td align='left' class='r' colspan='4'><select
					name="providerType" >
					 <c:forEach items="${providerTypes}" var="category">
                <option value="${providerTypeCode}"
                    <c:if test="${providerTypeCode eq selectedCatId}">selected="selected"</c:if>
                    >
                    ${providerTypeDesc}
                </option>
            </c:forEach>
            
            
          
					</s:select></td>
					</tr>
				</td>
			</tr>
		
		<tr>
				<td nowrap align='right' class='r'>Provider Last Name
													/Organization:</td>
													<td><img
														src="<%=request.getContextPath()%>/images/clear.gif"
														width="10" height="20" border=0></td>
													<td align='left' class='r' colspan='4'><INPUT type="text"
														name="lastName" maxlength="35">
					</s:textfield></td>
		</tr>
			<tr>
													<td nowrap align='right' class='r'>Provider First Name
													/Organization:</td>
													<td><img
														src="<%=request.getContextPath()%>/images/clear.gif"
														width="10" height="20" border=0></td>
													<td align='left' class='r' colspan='4'><INPUT type="text"
														name="firstName" maxlength="35">
													</s:textfield></td>
												</tr>									
												
												<tr>
													<td nowrap align='right' class='r'>National Provider Identifier(NPI):</td>
													<td><img
														src="<%=request.getContextPath()%>/images/clear.gif"
														width="10" height="20" border=0></td>
													<td align='left' class='r' colspan='4'><INPUT type="text"
														name="provNpi" maxlength="10" size="12">
													</td>
												</tr>
		
		
		</table>
		</td>
		
				<td width="30%" valign="top">
					<table cellspacing="0" cellpadding="1" width="100%" border="0">
						
						<tr>
							<td nowrap="nowrap" class="r" align="left" valign="top">
								Service Date From:<INPUT type="text"
														name="serviceDateFrom" maxlength="10" size="12">
													</s:textfield>
								<br> Service Date To:  <INPUT type="text"
														name="serviceDateTo" maxlength="10" size="12">
													
							</td>
												
						</tr>
					</table>
				</td>
			</tr>
		<tr>
		<td colspan="4"  nowrap="nowrap" class="r" align="center"><INPUT
			type="submit" value="Search Provider" name="submit">&nbsp;<INPUT type="button" value="Clear Form" name="submit"
			></td>
	</tr>
</table>

</Form>