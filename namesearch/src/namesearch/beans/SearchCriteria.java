package namesearch.beans;

import java.util.Date;

public class SearchCriteria  {

public String providerType;
public String providerTypeDesc;
public String lastName;
public String firstName;
public String provNpi;
public String provbasenum;
public String  dateofservice;
public String  provLocation;
public Date serviceDateFrom;
public Date serviceDateTo;
public String zipcode;

public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getProviderType() {
	return providerType;
}
public void setProviderType(String providerType) {
	this.providerType = providerType;
}

public String getzipcode()
{
	return zipcode;
}
public void setzipcode(String zipcode)
{
	this.zipcode= zipcode ;
}
public Date getserviceDateFrom()
{
	return serviceDateFrom;
}
public void setserviceDateFrom(Date serviceDateFrom)
{
	this.serviceDateFrom =serviceDateFrom ;
}
public Date getserviceDateTo()
{
	return serviceDateTo;
}
public void setserviceDateTo(Date serviceDateTo)
{
	this.serviceDateTo =serviceDateTo;
}


/**
 * @return the mcoName
 */

/**
 * @return the providerTypeDesc
 */
public String getProviderTypeDesc() {
	return providerTypeDesc;
}
/**
 * @param providerTypeDesc the providerTypeDesc to set
 */
public void setProviderTypeDesc(String providerTypeDesc) {
	this.providerTypeDesc = providerTypeDesc;
}
/**
 * @return the countyCode
 */

/**
 * @return the countyName
 */

public String getprovBaseNum()
{
	return provbasenum;
	
}
public void setProvBaseNum(String provBaseNum)
{
	this.provbasenum = provBaseNum ;
}

/**
 * @return the state
 */

/**
 * @return the provNpi
 */
public String getProvNpi() {
	return provNpi;
}
/**
 * @param provNpi the provNpi to set
 */
public void setProvNpi(String provNpi) {
	this.provNpi = provNpi;
}
}
