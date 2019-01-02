package namesearch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import namesearch.beans.Provider;
import namesearch.beans.SearchCriteria;
import namesearch.exception.NameSearchException;
import namesearch.beans.ProviderType;
import namesearch.beans.ProviderTypeRef;

public class Searchprvname {

		
	private String getFormattedZipCode(String zipCode) {
		String formattedZipCode = "";
		if (zipCode.equals("0")) {
			formattedZipCode = "";
		} else {
			if (zipCode.length() < 5) {
				zipCode = padLeft(zipCode, '0', 5);
			}
			formattedZipCode = zipCode;
			// formattedZipCode = zipCode.substring(0, 5) + "-"
			// + zipCode.substring(5, 9);
		}
		return formattedZipCode;
	}
	
	public List<ProviderType> getProvTypeForDisplay() {
		return ProviderTypeRef.getProviderTypes();
	}
	
	private String padLeft(String strToPad, char charPadder, int size) {
		StringBuffer strb;
		String strPadder = String.valueOf(charPadder);
		if (strPadder.length() == 0 || strToPad.length() >= size) {
			return strToPad;
		} else {
			strb = new StringBuffer(size);
			for (int loop = 0; loop < size - strToPad.length(); loop++) {
				strb.append(strPadder);
			}
			strb.append(strToPad);
		}
		return strb.toString();
	}
	
	public void formatProviderData(Provider prov)
	
	{
		prov.setProvBaseNum(padLeft(prov.getProvBaseNum(), '0', 7));
		prov.setProvLocation(padLeft(prov.getProvLocation(), '0', 2));
		// set PCP type indicator
		if (ProviderTypeRef.getPcpTypeProviders().contains(prov.getProvType())) {
			prov.isPCPType = true;
		} else {
			prov.isPCPType = false;
		}

		// add leading zeroes to spec codes
		String strSpecCode1 = padLeft(prov.getProvSpecCode(), '0', 3);
		String strSpecCode2 = padLeft(prov.getProvSpecCode1(), '0', 3);

		prov.setProvSpecCode(strSpecCode1);
		prov.setProvSpecCode1(strSpecCode2);

		if (prov.getProvType().equals("20")) {
			// DO NOT DISPLAY THE SPECIALTY CODE 000 -Display only provider Type
			if (strSpecCode1.equals("000")) {
				prov.setProvSpecDesc1(getProvTypeDesc(prov.getProvType()));
			} else {
				prov.setProvSpecDesc1(getProvTypeDesc(prov.getProvType()) + "-"
						+ getProvSpecialtyDesc(strSpecCode1));
			}
		} else {
			prov.setProvSpecDesc1(getProvTypeDesc(prov.getProvType()));
		}

		if (prov.getProvType().equals("20")
				&& (!prov.getProvSpecCode().equalsIgnoreCase(
						prov.getProvSpecCode1()))) {
			// DO NOT DISPLAY THE SPECIALTY CODE 000 - Display only provider
			// Type
			if (strSpecCode2.equals("000")) {
				// provEntry.setProvSpecDesc2("");
				prov.setProvSpecDesc2(getProvTypeDesc(prov.getProvType()));
			} else {
				prov.setProvSpecDesc2(getProvTypeDesc(prov.getProvType()) + "-"
						+ getProvSpecialtyDesc(strSpecCode2));
			}
		} else {
			prov.setProvSpecDesc2("");
		}

		// Format zipcode
		prov.setProvZip(getFormattedZipCode(prov.getProvZip()));

		// Format telephone number
		if (prov.getProvTeleNum().trim().length() > 0
				&& !prov.getProvTeleNum().trim().equalsIgnoreCase("0")) {
			prov.setProvTeleNum(getFormattedPhone(prov.getProvTeleNum()));
		} else {
			prov.setProvTeleNum("");
		}
	}
	
	
	private String getFormattedPhone(String teleNum) {
		String formattedTel = "";
		if (teleNum.equals("0")) {
			formattedTel = "";
		} else {
			if (teleNum.length() < 10) {
				teleNum = padLeft(teleNum, '0', 10);
			}
			formattedTel = "(" + teleNum.substring(0, 3) + ") "
					+ teleNum.substring(3, 6) + "-" + teleNum.substring(6, 10);
		}
		return formattedTel;
	}
	
	
	
	public String getProvSpecialtyDesc(String provSpecCode) {
		ArrayList provSpecList = ProviderTypeRef.getProviderSpcecialty();
		int indxOfprovSpec = provSpecList.indexOf(provSpecCode.trim());
		if (indxOfprovSpec < 0) {
			return provSpecCode;
		}
		return provSpecList.get(indxOfprovSpec + 1).toString();
	}

	public String getProvTypeDesc(String provTypeCode) {
		ArrayList provTypeList = ProviderTypeRef.getAllProviderTypes();
		int indxOfprovType = provTypeList.indexOf(provTypeCode.trim());
		if (indxOfprovType < 0) {
			return provTypeCode;
		}
		return provTypeList.get(indxOfprovType + 1).toString();
	}
	
	
	
	
	public String getProviderTypeDesc(String providerType) {
		ArrayList<ProviderType> provTypes = ProviderTypeRef.getProviderTypes();
		Iterator<ProviderType> it = provTypes.iterator();
		ProviderType ptype = null;
		String providerTypeDesc = "";
		if (!providerType.equals("-99")) {
			while (it.hasNext()) {
				ptype = it.next();
				if (ptype.getProviderTypeCode().equals(providerType)) {
					providerTypeDesc = ptype.getProviderTypeDesc();
				}
			}
			return providerTypeDesc;
		} else {
			return "";
		}
	}
	
	
	
	

	public List<Provider> fetchProviders(SearchCriteria criteria,
			Integer fetchSize) throws NameSearchException{
/*
 * Using plain JDBC code rather than using Spring-JDBC .
 * Reason: if the sql fetch size greater than 221, the system did not work in Solaris environment
 * to solve this issue, used the plain JDBC code.
 * if using Spring-JDBC, the fetchedProviders should be handled differently in SearchServiceImpl.java
 * 
 */
		fetchSize =10;
		Connection con = null;
		ResultSet rs = null;
		DbConnectionBean dbBean = new DbConnectionBean();
		PreparedStatement pstmt = null;
		 String sql = getSelectQuery() + getFromClaus(criteria)
			+ getWhereClaus(criteria)
			+ " ORDER BY nmed.PRACT_LAST_NAME,nmed.PRACT_FIRST_NAME "
			+ " FETCH FIRST " + fetchSize + " ROWS ONLY ";
		List<Provider> fetchedProviders = new ArrayList<Provider>();
		try {
			con = dbBean.connectToDS("remote");
		
			pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,	ResultSet.CONCUR_READ_ONLY);
			rs = pstmt.executeQuery();
		//	rs.absolute(currentPosition);
			int rowNum=0;
	//		RowMapper mapper = new ProviderRowMapper();
			while (rs.next()) {
				
				Provider prov=new Provider() ;
							
					prov.setProvBaseNum(rs.getInt("PROV_BASE_NUM") + "");
					prov.setProvLocation(rs.getInt("PROV_LOCATION") + "");
					prov.setProvType(rs.getString("PROV_TYPE"));
					prov.setProvSpecCode(rs.getString("PROV_SPEC_CODE"));
					prov.setProvSpecCode1(rs.getString("PROV_SPEC_CODE_1"));
					String strProvLastName = rs.getString("PRACT_LAST_NAME");
					prov.setProvLastName(strProvLastName);
					String strProvMidInit = rs.getString("PRACT_MIDDLE_INIT");
					prov.setProvMidInit(strProvMidInit);
					String strProvFirstName = rs.getString("PRACT_FIRST_NAME");
					prov.setProvFirstName(strProvFirstName);

					// set the full name to display
					String strFullname = "";
					strFullname = strProvLastName.trim();
					if (!strProvFirstName.trim().equals("")) {
						strFullname = strFullname + ", " + strProvFirstName;
					}
					if (!strProvMidInit.trim().equals("")) {
						strFullname = strFullname + " " + strProvMidInit;
					}
					prov.setProvFullName(strFullname);
					prov.setProvAddLine1(rs.getString("PROV_ADD_LN_1"));
					prov.setProvAddLine2(rs.getString("PROV_ADD_LN_2"));
					prov.setProvCity(rs.getString("PROV_CITY"));
					prov.setProvZip(rs.getString("PROV_ZIP_CODE"));
					prov.setProvState(rs.getString("PROV_STATE"));
					prov.setProvTeleNum(rs.getLong("PROV_TELE_NUM") + "");
				//	prov.setProvEPSDTInd(rs.getString("EPSDT_IND"));
					prov.setProvNpi(rs.getString("PROV_NPI_N").trim());	
			}
				fetchedProviders.add((Provider) (rs));
			
		} catch (Exception ex) {
			//log.error("Error Executing Query",ex.fillInStackTrace());
		} finally {
			try {
				rs.close();
				pstmt.close();
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
			//	log.error("Error closing connection",e.fillInStackTrace());
			}
		}
		return fetchedProviders;
}
	
	
	private String getFromClaus(SearchCriteria criteria) {
			
			String strFrom = " FROM THQM_N_MED_PRV_MST nmed, THQM_PROV_MASTER pm";
//			if(criteria.getZipCode().length()!=0)
//			{
//				strFrom =strFrom+ " ,THQM_EM_ZIPCODES zip ";
//			}
			return strFrom;
		}

	//CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	private StringBuffer getWhereClaus(SearchCriteria criteria) {
		StringBuffer strWhere = new StringBuffer();
		if(criteria.getprovBaseNum()!="" )
		{
//		strWhere.append(" WHERE nmed.prov_base_num=xref.prov_base_num");
//		strWhere.append(" AND nmed.prov_location=xref.prov_location");
		strWhere.append(" WHERE nmed.prov_base_num=pm.prov_base_num");
		strWhere.append(" AND nmed.prov_location=pm.prov_location");
		}
		if(criteria.getFirstName()!="" && criteria.getLastName()!="")
		{
			strWhere.append(" WHERE nmed.FIRST_NAME=pm.FIRST_NAME");
			strWhere.append(" AND nmed.LAST_NAME=pm.LAST_NAME");
		}
		if(criteria.getProvNpi()!="" && criteria.getProvNpi()!="")
		{
			strWhere.append(" WHERE pm.provNpi=nmed.provNpi");
			//strWhere.append(" AND nmed.prov_location=xref.prov_location");
		}

		//String strProvBaseNum = criteria.getprovBaseNum();
		
		if(criteria.getprovBaseNum() !="" && criteria.getFirstName()!="" && criteria.getLastName()!="")
		{
			strWhere.append(" WHERE nmed.prov_base_num=pm.prov_base_num");
			strWhere.append(" AND nmed.prov_location=pm.prov_location");
			strWhere.append(" pm.provNpi=nmed.provNpi");
		}
		if(criteria.getprovBaseNum() !="" && criteria.getFirstName()!="" && criteria.getLastName()!="" && criteria.getProvNpi()!="" )
		{
			strWhere.append(" WHERE nmed.prov_base_num=pm.prov_base_num");
			strWhere.append(" AND nmed.prov_location=pm.prov_location");
			strWhere.append(" AND nmed.getProvNpi=pm.getProvNpi");
			strWhere.append(" pm.provNpi=nmed.provNpi");
		}
		
		
		
//		if (!strMCO.equalsIgnoreCase("")) {
//			strWhere.append(" AND xref.MCO_BASE_NUM="
//					+ Long.parseLong(criteria.getMcoNum().substring(0, 7)));
//			strWhere.append(" AND xref.MCO_LOCATION="
//					+ Integer.parseInt(criteria.getMcoNum().substring(7)));
//		}
		return strWhere;
	}
		
		private String getSelectQuery() {
			String strSelect = "SELECT DISTINCT nmed.PROV_BASE_NUM,"
					+ "nmed.PROV_LOCATION,nmed.PROV_SPEC_CODE,"
					+ "nmed.PROV_SPEC_CODE_1,nmed.PROV_TYPE,"
					+ "nmed.PRACT_LAST_NAME,nmed.PRACT_FIRST_NAME,"
					+ "nmed.PRACT_MIDDLE_INIT,nmed.PROV_ADD_LN_1,"
					+ "nmed.PROV_ADD_LN_2,nmed.PROV_CITY,"
					+ "nmed.PROV_STATE,nmed.PROV_ZIP_CODE,"
					+ "nmed.PROV_TELE_NUM,nmed.EPSDT_IND,"
					+ "nmed.PROV_NPI_N";
			return strSelect;
			
	}	
	
}
