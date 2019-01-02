package classes;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import namesearch.beans.Provider;
import namesearch.beans.SearchCriteria;
import namesearch.beans.ProviderType;
import namesearch.dao.*;
import namesearch.exception.NameSearchException;
import namesearch.beans.*;



public class ProvController  extends HttpServlet{
	
	private static final long serialVersionUID= 1L;
	private Searchprvname dao;
	Vector vectErrMsgs = new Vector();
	String displayPage = "";
	  List<Provider> prv = new ArrayList();
      SearchCriteria criteria = new SearchCriteria();
      Searchprvname search =new Searchprvname();
      Prvservice searchService;
      List<ProviderType> providerTypes;
	  List<Provider> providersForDisplay;

	public ProvController()
	{
		super();
		dao=new Searchprvname();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException,IOException
	{
		
		//String actionClass = "namesearchprocessor + System.getProperty(action);
		
			try{
				System.out.println("welcome");
//				providerTypes = searchService.getProvTypeForDisplay();
//		            request.setAttribute("providerTypes", providerTypes);
//				RequestDispatcher dis = getServletContext().getRequestDispatcher("SearchProvider.jsp");
//				dis.forward(request, response);
			}
			catch(Exception ex)
			{
				RequestDispatcher dis = getServletContext().getRequestDispatcher("/errorPages/timeout.jsp");
				dis.forward(request, response);
			} 
			}
	
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	  {
		  ArrayList provider= new ArrayList();
			
	        criteria.setFirstName(request.getParameter("firstName"));
	        criteria.setLastName(request.getParameter("lastName"));
	             
	        validateNpi(criteria);
	        
	        criteria.setProvNpi(request.getParameter("provNpi"));
	        try {
	            Date serviceDateFrom = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("serviceDateFrom"));
	            Date serviceDateTo = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("serviceDateTo"));
	            criteria.setserviceDateFrom(serviceDateFrom);
	            criteria.setserviceDateTo(serviceDateTo);
	            
	            if (vectErrMsgs.size() > 0) 
	            {
	            	try {
						providersForDisplay=	 search.fetchProviders(criteria, 10);
						getProvs(providersForDisplay,criteria);
						
					//	formatProviderData(provider);
					} catch (NameSearchException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	  RequestDispatcher view = request.getRequestDispatcher("../SearchResults.jsp");
	            	  request.setAttribute("providersForDisplay", providersForDisplay);
	            	  view.forward(request, response);
	            }
	            else
	            {
	            	return;
	            }
	            }
	         catch (ParseException e) {
	            e.printStackTrace();
	        }
//	  	
	      
	  }
	  public void getProvs(List<Provider> providers, SearchCriteria criteria) {
		
		  Iterator<Provider> provIt = providers.iterator();
			while (provIt.hasNext()) {
				Provider provider = (Provider) provIt.next();
			
			
				// format provider data
				formatProviderData(provider);
			}
		}
	  
	  
	  public void validateNpi(SearchCriteria criteria){
		  if(!criteria.provNpi.equals("")){
		if(!validateforNDigit(criteria.provNpi, 10)){
			vectErrMsgs.add("NPI must be a 10 digit number.");
			return;
		}
		  }
	  }


	  public void formatProviderData(Provider prov) {
	// format provbase
	// format location
	// format provtype
	// format provspecialty codes
	// format zipcode
	// format telephone number
	// format EPSDT indicator
	// format TTY
	// format handicap
	// format pcp gender
	// format pcp indicator
	// format new patient indicator
	// prov.setProvBaseNum(provBaseNum)
	int ttyIndicator = 0; // 0- not specified, 1-No, 2-yes
	int handicapIndicator = 0; // 0- not specified, 1-No, 2-yes
	String strPcpGender = "";
	String strAcceptNewPatient = "";
	String strPCPIND = "";

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

	  public String getLanguage(String strLang1, String strLang2, String strLang3) {
		  String strLanguage = "";

		  List<Language> langList = Language.getLangList();

		  int indx = langList.indexOf(strLang1);
		  if (indx >= 0) {
		strLanguage = strLanguage + langList.get(indx + 1) + ", ";
		  }
		  if (!strLang2.equals(strLang1)) {
		indx = langList.indexOf(strLang2);
		if (indx >= 0) {
			strLanguage = strLanguage + langList.get(indx + 1) + ", ";
		}
		  }
		  if (!(strLang3.equals(strLang1)) && !(strLang3.equals(strLang2))) {
		indx = langList.indexOf(strLang3);
		if (indx >= 0) {
			strLanguage = strLanguage + langList.get(indx + 1);
		}
		  }
		  if (strLanguage.length() != 0) {
		if (strLanguage.lastIndexOf(',') == strLanguage.length() - 2) {
			strLanguage = strLanguage
					.substring(0, strLanguage.length() - 2);
		}
		  }
		  return strLanguage;

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




	  public boolean validateforNDigit(String strToCheck, int numberOfDigit) {
		  if (strToCheck.length() < numberOfDigit) {
		return false;
		  }
		  try {
		char[] arraystrToCheck = strToCheck.toCharArray();
		for (int i = 0; i < strToCheck.length(); i++) {
			if (arraystrToCheck[i] < 48 || arraystrToCheck[i] > 57) {
				return false;
			}
		}
		  } catch (Exception ex) {
		ex.getMessage();
		return false;
		  }
		  return true;
	  }

	public void getAction(HttpServletRequest request, HttpSession session, String action) throws Exception {


		String actionClass = "emedicaid.classes." + System.getProperty(action);

		Thread t = Thread.currentThread();
		ClassLoader cl = t.getContextClassLoader();

//		System.out.println("Class to load : " + actionClass);
		
		Class toRun = Class.forName(actionClass);
	//	emedicaid.classes.CoreProcessor object = (emedicaid.classes.CoreProcessor)toRun.newInstance();
	//	object.startProcessing(request, session);
		
		toRun = null;
	//	object = null;
	}
//	private void populateList(HttpSession session) {
//		
//		// mcos = searchService.getMCOList();
//		if (session.get("providerTypes") == null) {
//			providerTypes = searchService.getProvTypeForDisplay();
//			session.put("providerTypes", providerTypes);
//		} else {
//			providerTypes = (List<ProviderType>) session.get("providerTypes");
//		}
//		
//	}
	
	
	
}
