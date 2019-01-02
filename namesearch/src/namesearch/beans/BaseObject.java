package namesearch.beans;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
/**
 * BaseObject
 * @author dshrestha
 * 
 */

public class BaseObject implements Serializable{
	
		@Override
		public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }

 
	@Override
	public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

	@Override
	public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
