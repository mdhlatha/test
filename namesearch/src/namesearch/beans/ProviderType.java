/*
 * Created on May 31, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package namesearch.beans;


/**
 * @author DSHRESTHA
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ProviderType extends BaseObject{
	private String providerTypeCode;
	private String providerTypeDesc;
	public ProviderType(String code,String desc)
	{
		this.providerTypeCode=code;
		this.providerTypeDesc=desc;
	}
	/**
	 * @return the providerTypeCode
	 */
	public String getProviderTypeCode() {
		return providerTypeCode;
	}
	/**
	 * @param providerTypeCode the providerTypeCode to set
	 */
	public void setProviderTypeCode(String providerTypeCode) {
		this.providerTypeCode = providerTypeCode;
	}
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
}
