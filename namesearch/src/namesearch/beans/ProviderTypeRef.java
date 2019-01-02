/*
 * Created on May 31, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package namesearch.beans;

import java.util.ArrayList;

/**
 * @author DSHRESTHA
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ProviderTypeRef {
	public static ArrayList providerTypes = new ArrayList();
	public static ArrayList allProviderTypes = new ArrayList();
	public static ArrayList pcpTypes=new ArrayList();
	public static ArrayList providerSpecialty=new ArrayList();
	/**
	 * 
	 * @return the ArrayList of PCP provider types
	 */
	public static synchronized ArrayList getPcpTypeProviders()
	{
		if(pcpTypes.size()==0)
		{
			pcpTypes.add("01");
			pcpTypes.add("20");
			pcpTypes.add("22");
			pcpTypes.add("23");
			pcpTypes.add("31");
			pcpTypes.add("34");
			pcpTypes.add("36");
			pcpTypes.add("38");
		}
		return pcpTypes;
	}
	/**
	 * 
	 * @return the ArrayList of provider types that the user will see on the web.
	 * these are the only provider types that the users can search.
	 */
	public static synchronized ArrayList getProviderTypes() {
		if (providerTypes.size() == 0) {
		//	System.out.println("Called");
			providerTypes.add(new ProviderType("-99",""));
			providerTypes.add(new ProviderType("T1","Ambulance"));
			providerTypes.add(new ProviderType("39","Ambulatory Surgery"));
			providerTypes.add(new ProviderType("19","Audiology"));
			providerTypes.add(new ProviderType("80","Behavior Consultation"));
			providerTypes.add(new ProviderType("13","Chiropractor"));
			providerTypes.add(new ProviderType("CAll","Clinic - All")); //30,31,32,33,34,35,36,37,38
			providerTypes.add(new ProviderType("30","Clinic - Abortion"));
			providerTypes.add(new ProviderType("31","Clinic - Children And Youth"));
			providerTypes.add(new ProviderType("32","Clinic - Drug Abuse(Methadone)"));
			providerTypes.add(new ProviderType("33","Clinic - Family Planning"));
			providerTypes.add(new ProviderType("34","Clinic - Federally Qualified Health Center"));
			providerTypes.add(new ProviderType("38","Clinic - General"));
			providerTypes.add(new ProviderType("35","Clinic - Local Health Department"));
			providerTypes.add(new ProviderType("36","Clinic - MD Qualified Health Center"));
			providerTypes.add(new ProviderType("37","Clinic - Rural Health"));
			providerTypes.add(new ProviderType("CC","Counselor"));
			providerTypes.add(new ProviderType("14","Dental"));
			providerTypes.add(new ProviderType("61","Dialysis Facility"));
			providerTypes.add(new ProviderType("41","Home Health Agency"));
			providerTypes.add(new ProviderType("71","Hospice"));
			
			providerTypes.add(new ProviderType("HAll","Hospital - All"));//01,02,03,04,05,06,07 
			providerTypes.add(new ProviderType("01","Hospital - Acute"));
			providerTypes.add(new ProviderType("05","Hospital - Chronic"));
			providerTypes.add(new ProviderType("02","Hospital - Prov Non-Hosp Svcs"));
			providerTypes.add(new ProviderType("03","Hospital - Rehabilitation Acute"));
			providerTypes.add(new ProviderType("04","Hospital - Rehabilitation Chronic"));
			providerTypes.add(new ProviderType("06","Hospital - Special Other Acute"));
			providerTypes.add(new ProviderType("07","Hospital - Special Other Chronic"));
			
			providerTypes.add(new ProviderType("10","Laboratory"));
			providerTypes.add(new ProviderType("62","Medical Equipment and Supplies"));
			providerTypes.add(new ProviderType("MC","Mental Health Clinic"));
			providerTypes.add(new ProviderType("27","Mental Health Group"));
			providerTypes.add(new ProviderType("21","Nurse Anesthetist"));
			providerTypes.add(new ProviderType("22","Nurse Midwife"));
			providerTypes.add(new ProviderType("23","Nurse Practitioner"));
			
			providerTypes.add(new ProviderType("24","Nurse Psychotherapist"));
			providerTypes.add(new ProviderType("25","Nursing Agency"));
			providerTypes.add(new ProviderType("57","Nursing Facility"));
			providerTypes.add(new ProviderType("85","Nutritionist"));
			providerTypes.add(new ProviderType("18","Occupational Therapy"));

			providerTypes.add(new ProviderType("60","Other Diagnostic Services"));
			providerTypes.add(new ProviderType("63","Oxygen"));
			providerTypes.add(new ProviderType("RX","Pharmacy"));
			providerTypes.add(new ProviderType("16","Physical Therapy"));
			providerTypes.add(new ProviderType("20","Physician - All"));
			providerTypes.add(new ProviderType("20-26","Physician - Allergy and Immunology"));
			providerTypes.add(new ProviderType("20-31","Physician - Cardiology"));
			providerTypes.add(new ProviderType("20-51","Physician - Child Neurology"));
			providerTypes.add(new ProviderType("20-33","Physician - Endocrinology"));
			providerTypes.add(new ProviderType("20-29","Physician - Family Practice"));
			providerTypes.add(new ProviderType("20-28","Physician - General Practice"));
		
			providerTypes.add(new ProviderType("20-35","Physician - Hematology and Oncology"));
			providerTypes.add(new ProviderType("20-36","Physician - Infectious Disease"));
			providerTypes.add(new ProviderType("20-30","Physician - Internal Medicine"));
			providerTypes.add(new ProviderType("20-38","Physician - Nephrology"));
			providerTypes.add(new ProviderType("20-50","Physician - Neurology"));
			providerTypes.add(new ProviderType("20-7","Physician - Obstetrics and Gynecology"));
			providerTypes.add(new ProviderType("20-15","Physician - Opthalmology"));
			providerTypes.add(new ProviderType("20-16","Physician - Pediatrics"));
			providerTypes.add(new ProviderType("20-1","Physician - Surgery"));
			providerTypes.add(new ProviderType("20-6","Physician - Urology"));
			
			providerTypes.add(new ProviderType("11","Podiatry"));
			providerTypes.add(new ProviderType("15","Psychologist"));

			
			providerTypes.add(new ProviderType("53","Residential Service Agency"));
			providerTypes.add(new ProviderType("88","Residential Treatment Center"));
			providerTypes.add(new ProviderType("94","Social Worker"));
			providerTypes.add(new ProviderType("17","Speech Pathology"));
			providerTypes.add(new ProviderType("32","Substance Abuse Provider")); //32, 50,55 and HH
			providerTypes.add(new ProviderType("T2","Transportation"));
			providerTypes.add(new ProviderType("12","Vision Care"));
			
	
		}
		return providerTypes;
	}
	/**
	 * 
	 * @return the ArrayList of provider speciality of provider type 20 (Physician)
	 */
	public static synchronized ArrayList getProviderSpcecialty()
	{
		if(providerSpecialty.size()==0)
		{
			providerSpecialty.add("001");
			providerSpecialty.add("SURGERY");
			providerSpecialty.add("002");providerSpecialty.add("PEDIATRIC SURGERY");
			providerSpecialty.add("003");providerSpecialty.add("GENERAL VASCULAR SURGERY");
			providerSpecialty.add("004");providerSpecialty.add("COLON & RECTAL SURGERY");
			providerSpecialty.add("005");providerSpecialty.add("THORACIC SURGERY");
			providerSpecialty.add("006") ;providerSpecialty.add("UROLOGY");
			providerSpecialty.add("007");providerSpecialty.add("OBSTETRICS & GYNECOLOGY");
			providerSpecialty.add("008");providerSpecialty.add("GYNECOLOGIC ONCOLOGY");
			providerSpecialty.add("009");providerSpecialty.add("MATERNAL & FETAL MEDICINE");
			providerSpecialty.add("010");providerSpecialty.add("REPRODUCTIVE ENDOCRINOLOGY");
			providerSpecialty.add("011");providerSpecialty.add("PLASTIC SURGERY");
			providerSpecialty.add("012");providerSpecialty.add("OTOLARYNGOLOGY");
			providerSpecialty.add("013");providerSpecialty.add("ORTHOPAEDIC SURGERY");
			providerSpecialty.add("014");providerSpecialty.add("NEUROLOGICAL SURGERY");
			providerSpecialty.add("015");providerSpecialty.add("OPTHALMOLOGY");
			providerSpecialty.add("016");providerSpecialty.add("PEDIATRICS");
			providerSpecialty.add("017");providerSpecialty.add("DIAGNOSTIC LAB IMMUN-PEDIATRIC");
			providerSpecialty.add("018");providerSpecialty.add("PEDIATRIC CARDIOLOGY");
			providerSpecialty.add("019");providerSpecialty.add("PEDIATRIC CRITICAL CARE MED");
			providerSpecialty.add("020");providerSpecialty.add("PEDIATRIC ENDOCRINOLOGY");
			providerSpecialty.add("021");providerSpecialty.add("PEDIATRIC GASTROENTEROLOGY");
			providerSpecialty.add("022");providerSpecialty.add("PEDIATRIC HEMATOLOGY-ONCOLOGY");
			providerSpecialty.add("023");providerSpecialty.add("PEDIATRIC NEPHROLOGY");
			providerSpecialty.add("024");providerSpecialty.add("PEDIATRIC PULMONOLOGY");
			providerSpecialty.add("025");providerSpecialty.add("NEONATAL-PERINATAL MEDICINE");
			providerSpecialty.add("026");providerSpecialty.add("ALLERGY & IMMUNOLOGY");
			providerSpecialty.add("027");providerSpecialty.add("DIAGNOSTIC LAB IMMUN-ALLERGY");
			providerSpecialty.add("028");providerSpecialty.add("GENERAL PRACTICE");
			providerSpecialty.add("029");providerSpecialty.add("FAMILY PRACTICE");
			providerSpecialty.add("030");providerSpecialty.add("INTERNAL MEDICINE");
			providerSpecialty.add("031");providerSpecialty.add("CARDIOVASCULAR DISEASE");
			providerSpecialty.add("032");providerSpecialty.add("CRITICAL CARE MEDICINE");
			providerSpecialty.add("033");providerSpecialty.add("ENDOCRINOLOGY & METABOLISM");
			providerSpecialty.add("034");providerSpecialty.add("GASTROENTEROLOGY");
			providerSpecialty.add("035");providerSpecialty.add("HEMATOLOGY");
			providerSpecialty.add("036");providerSpecialty.add("INFECTIOUS DISEASE");
			providerSpecialty.add("037");providerSpecialty.add("MEDICAL ONCOLOGY");
			providerSpecialty.add("038");providerSpecialty.add("NEPHROLOGY");
			providerSpecialty.add("039");providerSpecialty.add("PULMONARY DISEASE");
			providerSpecialty.add("040");providerSpecialty.add("RHEUMATOLOGY");
			providerSpecialty.add("041");providerSpecialty.add("ANESTHESIOLOGY");
			providerSpecialty.add("042");providerSpecialty.add("CRITICAL CARE MEDICINE-ANESTH");
			providerSpecialty.add("043");providerSpecialty.add("EMERGENCY MEDICINE");
			providerSpecialty.add("044");providerSpecialty.add("NUCLEAR MEDICINE");
			providerSpecialty.add("045");providerSpecialty.add("ANATOMIC & CLINICAL PATHOLOGY");
			providerSpecialty.add("046");providerSpecialty.add("ANATOMIC PATHOLOGY");
			providerSpecialty.add("047");providerSpecialty.add("CLINICAL PATHOLOGY");
			providerSpecialty.add("048");providerSpecialty.add("PHYSICAL MEDICINE & REHAB");
			providerSpecialty.add("049");providerSpecialty.add("PUBLIC HEALTH & GEN PREV MED");
			providerSpecialty.add("050");providerSpecialty.add("NEUROLOGY");
			providerSpecialty.add("051");providerSpecialty.add("NEUROLOGY-SP QUAL IN CHLD NEUR");
			providerSpecialty.add("052");providerSpecialty.add("PSYCHIATRY");
			providerSpecialty.add("053");providerSpecialty.add("CHILD & ADOLESCENT PSYCHIATRY");
			providerSpecialty.add("054");providerSpecialty.add("RADIOLOGY");
			providerSpecialty.add("055");providerSpecialty.add("DIAGNOSTIC RADIOLOGY");
			providerSpecialty.add("056");providerSpecialty.add("RADIATION ONCOLOGY");
			providerSpecialty.add("057");providerSpecialty.add("NUCLEAR RADIOLOGY");
			providerSpecialty.add("058");providerSpecialty.add("DERMATOLOGY");
			providerSpecialty.add("059");providerSpecialty.add("DERMATOPATHOLOGY");
			providerSpecialty.add("060");providerSpecialty.add("DERM IMMUN/DIAG & LAB IMMUN");
			providerSpecialty.add("070");providerSpecialty.add("GYNECOLOGIST");
			providerSpecialty.add("100");providerSpecialty.add("ADVANCED LIFE SUPPORT");
			providerSpecialty.add("101");providerSpecialty.add("ALCOHOL COUNSELING");
			providerSpecialty.add("102");providerSpecialty.add("AMBULATORY SERVICE");
			providerSpecialty.add("103");providerSpecialty.add("AUDIOLOGIST");
			providerSpecialty.add("104");providerSpecialty.add("AUDIOLOGY CENTERS");
			providerSpecialty.add("105");providerSpecialty.add("BASIC LIFE SUPPORT");
			providerSpecialty.add("106");providerSpecialty.add("CHIROPRACTOR");
			providerSpecialty.add("107");providerSpecialty.add("DD CASE MANAGEMENT");
			providerSpecialty.add("108");providerSpecialty.add("DD CSLA");
			providerSpecialty.add("109");providerSpecialty.add("DD DAY HABIL/SUPPORT EMPLYMT");
			providerSpecialty.add("110");providerSpecialty.add("DD INTENSIVE BEHAVIOR MGMT PRG");
			providerSpecialty.add("111");providerSpecialty.add("DD RESIDENTIAL HABILITATION");
			providerSpecialty.add("112");providerSpecialty.add("DD SERVICES COORDINATION");
			providerSpecialty.add("113");providerSpecialty.add("DENTAL");
			providerSpecialty.add("114");providerSpecialty.add("DIAB WVR-BLD GLU MONITOR & SUP");
			providerSpecialty.add("115");providerSpecialty.add("DIAB WVR-CASE MANAGEMENT");
			providerSpecialty.add("116");providerSpecialty.add("DIAB WVR-NUTRITION COUNSELING");
			providerSpecialty.add("117");providerSpecialty.add("DIAB WVR-OUTPATIENT EDUCATION");
			providerSpecialty.add("118");providerSpecialty.add("DIAB WVR-PODIATRY VISIT");
			providerSpecialty.add("119");providerSpecialty.add("DIAB WVR-THERAPEUTIC FOOTWEAR");
			providerSpecialty.add("120");providerSpecialty.add("DIRECT PAYMENT");
			providerSpecialty.add("121");providerSpecialty.add("DRUG ABUSE");
			providerSpecialty.add("122");providerSpecialty.add("DRUG COUNSELING");
			providerSpecialty.add("123");providerSpecialty.add("ENDODONTICS");
			providerSpecialty.add("124");providerSpecialty.add("EPSDT NUTRITION COUNSELING");
			providerSpecialty.add("125");providerSpecialty.add("EPSDT ADDICTIONS COUNSELING");
			providerSpecialty.add("126");providerSpecialty.add("EPSDT PDN-EARLY DISCHARGE");
			providerSpecialty.add("127");providerSpecialty.add("EPSDT PDN-MED FRAGILE");
			providerSpecialty.add("128");providerSpecialty.add("EQUIPMENT PURCHASE");
			providerSpecialty.add("129");providerSpecialty.add("EQUIPMENT RENTAL");
			providerSpecialty.add("130");providerSpecialty.add("FREESTANDING");
			providerSpecialty.add("131");providerSpecialty.add("GENERAL DENTISTRY");
			providerSpecialty.add("133");providerSpecialty.add("GENERAL TRANSPORTATION");
			providerSpecialty.add("134");providerSpecialty.add("GERIATRIC");
			providerSpecialty.add("135");providerSpecialty.add("HEAD INJURYED WAIVER");
			providerSpecialty.add("136");providerSpecialty.add("HEALTHY START-ADDICTIONS COUNS");
			providerSpecialty.add("137");providerSpecialty.add("HEALTHY START-CASE MGMT (ONGO)");
			providerSpecialty.add("138");providerSpecialty.add("HLTHY STRT-CASE MGMT(NOT ONGO)");
			providerSpecialty.add("139");providerSpecialty.add("HEALTHY START-ENRICHED SVCS");
			providerSpecialty.add("140");providerSpecialty.add("HEALTHY START-NURSING VISITS");
			providerSpecialty.add("141");providerSpecialty.add("HEALTHY START-NUTRITION");
			providerSpecialty.add("142");providerSpecialty.add("HEALTHY START-RISK ASSESSMENT");
			providerSpecialty.add("143");providerSpecialty.add("HEARING AID DEALERS");
			providerSpecialty.add("144");providerSpecialty.add("HIGH COST USER WAIVER");
			providerSpecialty.add("145");providerSpecialty.add("HIV DES SERVICES");
			providerSpecialty.add("146");providerSpecialty.add("HIV ONGOING CASE MANAGEMENT");
			providerSpecialty.add("147");providerSpecialty.add("HOME IV THERAPY");         
			providerSpecialty.add("148");providerSpecialty.add("HOSPICE-FREEST-RESID COMMUNITY");
			providerSpecialty.add("149");providerSpecialty.add("HOSPICE-NURSING HOME");    
			providerSpecialty.add("150");providerSpecialty.add("HOSPITAL BASED");          
			providerSpecialty.add("151");providerSpecialty.add("HOSPITAL OUTPATIENT PHARMACY");
			providerSpecialty.add("152");providerSpecialty.add("HS ADDICTIONS COUNSELING");
			providerSpecialty.add("153");providerSpecialty.add("ICF");                     
			providerSpecialty.add("154");providerSpecialty.add("ICF-ADDICTIONS");          
			providerSpecialty.add("155");providerSpecialty.add("INCOME TAX");              
			providerSpecialty.add("156");providerSpecialty.add("INSTITUTIONAL PHARMACY");  
			providerSpecialty.add("157");providerSpecialty.add("LAB-MEDICAL, FREESTANDING");
			providerSpecialty.add("158");providerSpecialty.add("LAB-MEDICAL, HOSPITAL BASED");
			providerSpecialty.add("159");providerSpecialty.add("LAB-MEDICAL, LOCAL HEALTH DEPT");
			providerSpecialty.add("160");providerSpecialty.add("LAB-MEDICAL, MARYLAND STATE");
			providerSpecialty.add("161");providerSpecialty.add("MEDICAL");                 
			providerSpecialty.add("162");providerSpecialty.add("MENTAL HEALTH");           
			providerSpecialty.add("163");providerSpecialty.add("MODEL WAIVER HOME CARE COORD");
			providerSpecialty.add("164");providerSpecialty.add("MODEL WAIVER HOME HEALTH AIDE");
			providerSpecialty.add("165");providerSpecialty.add("MODEL WAIVER NURSING");    
			providerSpecialty.add("166");providerSpecialty.add("MODEL WAIVER PLAN OF CARE");
			providerSpecialty.add("167");providerSpecialty.add("MODEL WAIVER DMS/DME");    
			providerSpecialty.add("168");providerSpecialty.add("MULTI-SPECIALTY PHARMACY");
			providerSpecialty.add("169");providerSpecialty.add("NURSE ANESTHETIST");       
			providerSpecialty.add("170");providerSpecialty.add("NURSE MIDWIFE");           
			providerSpecialty.add("171");providerSpecialty.add("NURSE PRACTITIONER");      
			providerSpecialty.add("172");providerSpecialty.add("NURSE PSYCHOTHERAPIST");   
			providerSpecialty.add("173");providerSpecialty.add("OCCUPATIONAL THERAPIST");  
			providerSpecialty.add("174");providerSpecialty.add("OFF ON AGING WVR-ASST LIV SVCS");
			providerSpecialty.add("175");providerSpecialty.add("OFF ON AGING WVR-ENVIR ASSESSM");
			providerSpecialty.add("176");providerSpecialty.add("OFF ON AGING WVR-SR CTR PLUS");
			providerSpecialty.add("177");providerSpecialty.add("OPTICIAN");                
			providerSpecialty.add("178");providerSpecialty.add("OPTOMETRIC CENTER");       
			providerSpecialty.add("179");providerSpecialty.add("OPTOMETRIST");             
			providerSpecialty.add("180");providerSpecialty.add("OPTOMETRIST/OPTICIAN");    
			providerSpecialty.add("181");providerSpecialty.add("ORAL SURGERY");            
			providerSpecialty.add("182");providerSpecialty.add("ORTHODONTICS");            
			providerSpecialty.add("183");providerSpecialty.add("OSTEOPATH");               
			providerSpecialty.add("184");providerSpecialty.add("OTHER PHARMACY");          
			providerSpecialty.add("185");providerSpecialty.add("OXYGEN");                  
			providerSpecialty.add("186");providerSpecialty.add("PATHOLOGY");               
			providerSpecialty.add("187");providerSpecialty.add("PEDODONTICS");             
			providerSpecialty.add("188");providerSpecialty.add("PERIODONTICS");            
			providerSpecialty.add("189");providerSpecialty.add("PHYSICAL THERAPIST");      
			providerSpecialty.add("191");providerSpecialty.add("PODIATRIST");              
			providerSpecialty.add("194");providerSpecialty.add("PRIVATE DUTY NURSING");    
			providerSpecialty.add("195");providerSpecialty.add("PRIVATE OWNERSHIP");       
			providerSpecialty.add("196");providerSpecialty.add("PSYCHOLOGIST");            
			providerSpecialty.add("198");providerSpecialty.add("PUBLIC OWNERSHIP");        
			providerSpecialty.add("199");providerSpecialty.add("PUBLIC TRANSIT");          
			providerSpecialty.add("200");providerSpecialty.add("RECYCLING");               
			providerSpecialty.add("201");providerSpecialty.add("RELATED RESPIRATORY EQUIPMENT");
			providerSpecialty.add("202");providerSpecialty.add("RETAIL CHAIN PHARMACY");   
			providerSpecialty.add("203");providerSpecialty.add("RETAIL SALES");            
			providerSpecialty.add("204");providerSpecialty.add("RETAIL SINGLE PHARMACY");  
			providerSpecialty.add("205");providerSpecialty.add("RTC");                     
			providerSpecialty.add("206");providerSpecialty.add("RURAL");                   
			providerSpecialty.add("207");providerSpecialty.add("SNF");                     
			providerSpecialty.add("208");providerSpecialty.add("SOCIAL WORKER");           
			providerSpecialty.add("209");providerSpecialty.add("SPEECH/LANGUAGE PATHOLOGY");
			providerSpecialty.add("210");providerSpecialty.add("STRETCHER SERVICE");       
			providerSpecialty.add("211");providerSpecialty.add("URBAN");                   
			providerSpecialty.add("212");providerSpecialty.add("WHEELCHAIR VAN SERVICE");  
			providerSpecialty.add("213");providerSpecialty.add("PEDIATRIC INPATIENT");     
			providerSpecialty.add("214");providerSpecialty.add("PSYCHIATRIC INPATIENT");   
			providerSpecialty.add("215");providerSpecialty.add("COMMUNICABLE DISEASE INPATIENT");
			providerSpecialty.add("220");providerSpecialty.add("AUTISM REG RES HABILITATION");
			providerSpecialty.add("221");providerSpecialty.add("AUTISM INTENS RES HABILITATION");
			providerSpecialty.add("222");providerSpecialty.add("AUTISM REG DAY HABILITATION");
			providerSpecialty.add("223");providerSpecialty.add("AUTISM INTENS DAY HABILITATION");
			providerSpecialty.add("224");providerSpecialty.add("AUTISM INTENS INDIV SUPP SERV");
			providerSpecialty.add("225");providerSpecialty.add("AUTISM THERAPEUTIC INTEGRATION");
			providerSpecialty.add("227");providerSpecialty.add("AUTISM SUPPORTED EMPLOYMENT");
			providerSpecialty.add("228");providerSpecialty.add("AUTISM RESPITE CARE");     
			providerSpecialty.add("229");providerSpecialty.add("AUTISM FAMILY TRAINING");  
			providerSpecialty.add("230");providerSpecialty.add("AUTISM ENVIR ACCESS ADAPTATION");
			providerSpecialty.add("231");providerSpecialty.add("AUTISM INITIAL ASSESSMENT");
			providerSpecialty.add("232");providerSpecialty.add("AUTISM ONGOING ASSESSMENT");
			providerSpecialty.add("233");providerSpecialty.add("AUTISM REASSESSMENT");     
			providerSpecialty.add("240");providerSpecialty.add("ATTEND CARE-AGENCY-ATTENDANT");
			providerSpecialty.add("241");providerSpecialty.add("ATTEND CARE-INDV-ATTENDANT");
			providerSpecialty.add("242");providerSpecialty.add("ATTEN CARE-AGENCY-FAMILY-TRAIN");
			providerSpecialty.add("243");providerSpecialty.add("ATTEN CARE-INDIV-FAMILY-TRAIN");
			providerSpecialty.add("244");providerSpecialty.add("ATTEN CARE-AGENCY-CONSM-TRAIN");
			providerSpecialty.add("245");providerSpecialty.add("ATTEN CARE-INDIV-COSUMER-TRAIN");
			providerSpecialty.add("246");providerSpecialty.add("ATTEND CARE-ENVIRO-ADAPTATION");
			providerSpecialty.add("247");providerSpecialty.add("ATTEND CARE-PERS-EMERG-RESPONS");
			providerSpecialty.add("248");providerSpecialty.add("ATTEND CARE-ASSIST-TECHNOLOGY");
			providerSpecialty.add("250");providerSpecialty.add("ATTEND CARE-AGENCY-NURSING");
			providerSpecialty.add("251");providerSpecialty.add("ATTEND CARE-INDIVIDUAL NURSING");
			providerSpecialty.add("252");providerSpecialty.add("ATTEND CARE-AGEN-OCCUP-THERAPY");
			providerSpecialty.add("253");providerSpecialty.add("ATTEND CARE-INDV-OCCUP-THERAPY");
			providerSpecialty.add("254");providerSpecialty.add("ATTEND CARE-AGENCY-SPEECH-THER");
			providerSpecialty.add("255");providerSpecialty.add("ATTEND CARE-INDV-SPEECH-THER");
			providerSpecialty.add("256");providerSpecialty.add("ATTEND CARE-DISPO-MED-SUPPLIES");
			providerSpecialty.add("270");providerSpecialty.add("OLD ADULT PC-SEL-EMPL-W/O-MEDS");
			providerSpecialty.add("271");providerSpecialty.add("OLDER ADULT PC-AGENCY-W/O-MEDS");
			providerSpecialty.add("272");providerSpecialty.add("OLD ADULT-RESPIT CARE-SEL-EMPL");
			providerSpecialty.add("273");providerSpecialty.add("OLD ADULT-RESPITE CARE-AGENCY");
			providerSpecialty.add("274");providerSpecialty.add("OLD ADULT ENVIRON ACCESS ADAPT");
			providerSpecialty.add("275");providerSpecialty.add("OLD ADULT-FAMILY/CONSUM TRAIN");
			providerSpecialty.add("276");providerSpecialty.add("OLD ADULT PERS EMERG RESPONSE");
			providerSpecialty.add("277");providerSpecialty.add("OLD ADULT HOME-DELIVER MEAL");
			providerSpecialty.add("278");providerSpecialty.add("OLD ADULT DIETITION/NUTRITION");
			providerSpecialty.add("279");providerSpecialty.add("OLDER ADULTS-HOME HEALTH");
			providerSpecialty.add("280");providerSpecialty.add("OLD ADULT ASSISTIVE DEVICES");
			providerSpecialty.add("282");providerSpecialty.add("OLD ADULT ASIST-LIV-LEVEL II");
			providerSpecialty.add("283");providerSpecialty.add("OLD ADULT ASIST-LIV-LEVEL III");
			providerSpecialty.add("284");providerSpecialty.add("OLD ADULT PC-SEL-EMPL-WITH MED");
			providerSpecialty.add("285");providerSpecialty.add("OLD ADULTS PC-AGENCY-WITH MEDS");
			providerSpecialty.add("286");providerSpecialty.add("OLD ADULT-RESPIT CARE-NURS HME");
			providerSpecialty.add("287");providerSpecialty.add("OLD ADULT-RESPIT CARE-ASIS-LIV");
			providerSpecialty.add("288");providerSpecialty.add("OLD ADULT BEHAVIOR CONS SERVIC");
			providerSpecialty.add("290");providerSpecialty.add("TBI RESIDENTIAL HABILITATION");
			providerSpecialty.add("291");providerSpecialty.add("TBI DAY HAB/SUP EMPLOYMENT");

		}
		return providerSpecialty;
	}
	/**
	 * 
	 * @return the ArrayList of all provider types.
	 */
	public static synchronized ArrayList getAllProviderTypes() {
		if (allProviderTypes.size() == 0) {
			allProviderTypes.add("AC");
			allProviderTypes.add("ACUPUNCTURE");
			allProviderTypes.add("50");
			allProviderTypes.add("ADAA CERT ADDICT OUTPAT PRG");
			allProviderTypes.add("T1");
			allProviderTypes.add("AMBULANCE SERVICES");
			allProviderTypes.add("39");
			allProviderTypes.add("AMBULATORY SURGICAL CENTER");
			allProviderTypes.add("75");
			allProviderTypes.add("ASSISTED LIVING SERVICE PROV");
			allProviderTypes.add("AT");
			allProviderTypes.add("ATTENDANT WAIVER");
			allProviderTypes.add("19");
			allProviderTypes.add("AUDIOLOGY SERVICES PROVIDER");
			allProviderTypes.add("80");
			allProviderTypes.add("BEHAVIOR CONSULTATION PROVIDER");
			allProviderTypes.add("81");
			allProviderTypes.add("CASE MGMT-NOT ELSEWHERE CLASS");
			allProviderTypes.add("CC");
			allProviderTypes.add("CERT PROFESSIONAL COUNSELOR");
			allProviderTypes.add("82");
			allProviderTypes.add("CHILDRENS  MED SVC PROVIDER");
			allProviderTypes.add("13");
			allProviderTypes.add("CHIROPRACTOR");
			allProviderTypes.add("30");
			allProviderTypes.add("CLINIC, ABORTION");
			allProviderTypes.add("31");
			allProviderTypes.add("CLINIC, CHILDREN AND YOUTH");
			allProviderTypes.add("32");
			allProviderTypes.add("CLINIC, DRUG ABUSE(METHADONE)");
			allProviderTypes.add("33");
			allProviderTypes.add("CLINIC, FAMILY PLANNING");
			allProviderTypes.add("34");
			allProviderTypes.add("CLINIC, FED QUALIFIED HLTH CTR");
			allProviderTypes.add("38");
			allProviderTypes.add("CLINIC, GENERAL");
			allProviderTypes.add("35");
			allProviderTypes.add("CLINIC, LOCAL HLTH DEPT");
			allProviderTypes.add("36");
			allProviderTypes.add("CLINIC, MD QUALIFIED HLTH CTR");
			allProviderTypes.add("37");
			allProviderTypes.add("CLINIC, RURAL HEALTH");
			allProviderTypes.add("83");
			allProviderTypes.add("COMPREHESIVE OUTPAT REHAB FAC");
			allProviderTypes.add("90");
			allProviderTypes.add("DDA SERVICES PROVIDER");
			allProviderTypes.add("14");
			allProviderTypes.add("DENTAL");
			allProviderTypes.add("84");
			allProviderTypes.add("DIABETES EDUCATION");
			allProviderTypes.add("60");
			allProviderTypes.add("DIAGNOSTIC SERVICES, OTHER");
			allProviderTypes.add("61");
			allProviderTypes.add("DIALYSIS FACILITIES");
			allProviderTypes.add("85");
			allProviderTypes.add("DIETICIAN/NUTRITIONIST");
			allProviderTypes.add("62");
			allProviderTypes.add("DME/DMS");
			allProviderTypes.add("51");
			allProviderTypes.add("EPSDT THERAPEUTIC INTERVENTION");
			allProviderTypes.add("52");
			allProviderTypes.add("EPSDT THERAPEUTIC NURSERY");
			allProviderTypes.add("HH");
			allProviderTypes.add("HALFWAY HOUSE");
			allProviderTypes.add("86");
			allProviderTypes.add("HEAD INJURED WAIVER PROVIDER");
			allProviderTypes.add("70");
			allProviderTypes.add("HMO");
			allProviderTypes.add("40");
			allProviderTypes.add("HOME AND COMM BASED SVC,OTHER");
			allProviderTypes.add("41");
			allProviderTypes.add("HOME HEALTH AGENCY");
			allProviderTypes.add("02");
			allProviderTypes.add("HOSP PROV - NON-HOSP SVCS");
			allProviderTypes.add("03");
			allProviderTypes.add("HOSP, REHABILITATION ACUTE");
			allProviderTypes.add("04");
			allProviderTypes.add("HOSP, REHABILITATION CHRONIC");
			allProviderTypes.add("06");
			allProviderTypes.add("HOSP, SPECIAL OTHER ACUTE");
			allProviderTypes.add("07");
			allProviderTypes.add("HOSP, SPECIAL OTHER CHRONIC");
			allProviderTypes.add("71");
			allProviderTypes.add("HOSPICE PROVIDER");
			allProviderTypes.add("01");
			allProviderTypes.add("HOSPITAL, ACUTE");
			allProviderTypes.add("05");
			allProviderTypes.add("HOSPITAL, CHRONIC");
			allProviderTypes.add("55");
			allProviderTypes.add("INTERMED CARE FAC-ADDICTION");
			allProviderTypes.add("56");
			allProviderTypes.add("INTERMED CARE FAC-MENT RETARD");
			allProviderTypes.add("64");
			allProviderTypes.add("KIDNEY DISEASE PROGRAM");
			allProviderTypes.add("10");
			allProviderTypes.add("LABORATORIES, MEDICAL");
			allProviderTypes.add("97");
			allProviderTypes.add("LEVY HOLDER - FEDERAL");
			allProviderTypes.add("98");
			allProviderTypes.add("LEVY HOLDER - STATE");
			allProviderTypes.add("08");
			allProviderTypes.add("LITHOTRIPSY FACILITY");
			allProviderTypes.add("91");
			allProviderTypes.add("LOCAL EDUC AGNCY/LOCAL LEAD AG");
			allProviderTypes.add("72");
			allProviderTypes.add("MANAGED CARE ORGANIZATION");
			allProviderTypes.add("42");
			allProviderTypes.add("MEDICAL DAY CARE, ADULT");
			allProviderTypes.add("43");
			allProviderTypes.add("MEDICAL DAY CARE, CHILD");
			allProviderTypes.add("CM");
			allProviderTypes.add("MENTAL HEALTH CASE MGMT PROV");
			allProviderTypes.add("MC");
			allProviderTypes.add("MENTAL HEALTH CLINIC");
			allProviderTypes.add("27");
			allProviderTypes.add("MENTAL HEALTH GROUP PROVIDER");
			allProviderTypes.add("29");
			allProviderTypes.add("MENTAL HYGIENE ADMIN SERVICES");
			allProviderTypes.add("MH");
			allProviderTypes.add("MENTAL HYGIENE ADMINISTRATION");
			allProviderTypes.add("MT");
			allProviderTypes.add("MOBILE TREATMENT PROGRAM");
			allProviderTypes.add("99");
			allProviderTypes.add("NOT AVAIL-USED FOR TOT IN MARS");
			allProviderTypes.add("21");
			allProviderTypes.add("NURSE ANESTHETISTS-INDIV/GRP");
			allProviderTypes.add("22");
			allProviderTypes.add("NURSE MIDWIFE-INDIV/GRP");
			allProviderTypes.add("23");
			allProviderTypes.add("NURSE PRACTITIONER-INDIV/GRP");
			allProviderTypes.add("24");
			allProviderTypes.add("NURSE PSYCHOTHERAPIST-INDV/GRP");
			allProviderTypes.add("25");
			allProviderTypes.add("NURSING AGENCY");
			allProviderTypes.add("57");
			allProviderTypes.add("NURSING FACILITY");
			allProviderTypes.add("76");
			allProviderTypes.add("NURSING HOME WAIVER PROVIDER");
			allProviderTypes.add("18");
			allProviderTypes.add("OCCUPAT THERAPIST-INDIV/GRP");
			allProviderTypes.add("63");
			allProviderTypes.add("OXYGEN SERVICE");
			allProviderTypes.add("46");
			allProviderTypes.add("PERS CARE AIDE LEVEL 4 AGENCY");
			allProviderTypes.add("44");
			allProviderTypes.add("PERSONAL CARE AIDE");
			allProviderTypes.add("45");
			allProviderTypes.add("PERSONAL CARE AIDE-AGENCY");
			allProviderTypes.add("47");
			allProviderTypes.add("PERSONAL CARE MONITOR");
			allProviderTypes.add("RX");
			allProviderTypes.add("PHARMACY");
			allProviderTypes.add("16");
			allProviderTypes.add("PHYSICAL THERAPIST -INDIV/GRP");
			allProviderTypes.add("20");
			allProviderTypes.add("PHYSICIAN");
			allProviderTypes.add("11");
			allProviderTypes.add("PODIATRY");
			allProviderTypes.add("59");
			allProviderTypes.add("PORTABLE X-RAY");
			allProviderTypes.add("92");
			allProviderTypes.add("PRESCRIBING ONLY");
			allProviderTypes.add("PR");
			allProviderTypes.add("PSYCHIATRIC REHAB SERVICES FAC");
			allProviderTypes.add("15");
			allProviderTypes.add("PSYCHOLOGIST");
			allProviderTypes.add("87");
			allProviderTypes.add("REM/SLM PROVIDERS");
			allProviderTypes.add("53");
			allProviderTypes.add("RESIDENTIAL SERVICE AGENCY");
			allProviderTypes.add("88");
			allProviderTypes.add("RESIDENTIAL TREATMENT CENTER");
			allProviderTypes.add("89");
			allProviderTypes.add("RTC WAIVER PROVIDER");
			allProviderTypes.add("SB");
			allProviderTypes.add("SCHOOL-BASED HEALTH CLINIC");
			allProviderTypes.add("93");
			allProviderTypes.add("SENIOR CENTER PLUS");
			allProviderTypes.add("94");
			allProviderTypes.add("SOCIAL WORKER");
			allProviderTypes.add("17");
			allProviderTypes.add("SPEECH/LANGUAGE PATHOLOGIST");
			allProviderTypes.add("95");
			allProviderTypes.add("STATE AGENCY");
			allProviderTypes.add("SA");
			allProviderTypes.add("SVCS MEDICALLY COMPLEX NF");
			allProviderTypes.add("96");
			allProviderTypes.add("TAPE INTERMEDIARY");
			allProviderTypes.add("TC");
			allProviderTypes.add("THERAPEUTIC COMMUNITY");
			allProviderTypes.add("28");
			allProviderTypes.add("THERAPY GROUP PROVIDER");
			allProviderTypes.add("T2");
			allProviderTypes.add("TRANSPORTATION SERVICES");
			allProviderTypes.add("12");
			allProviderTypes.add("VISION CARE");
			allProviderTypes.add("T3");
			allProviderTypes.add("WHEELCHAIR VAN");
		}
		return allProviderTypes;
	}
}
