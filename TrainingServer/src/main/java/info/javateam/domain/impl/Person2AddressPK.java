package info.javateam.domain.impl;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author Sascha
 *
 */
@Embeddable
public class Person2AddressPK implements Serializable {   
	private static final long serialVersionUID = 1L;

	private String personId;   
    private String addressId;   
  
    /**
     * Constructor between Person and Address
     * 
     * @param personId
     * @param addressId
     */
    public Person2AddressPK(String personId, String addressId) {   
        this.personId = personId;   
        this.addressId = addressId;   
    }   
  
    /**
     * Constructor between Person and Address
     */
    public Person2AddressPK() {   
    }   
  
    /**
     * Gets Person Key
     * @return
     */
    public String getPersonId() {   
        return personId;   
    }   
  
    /**
     * Sets Person Key
     * @param personId
     */
    public void setPersonId(String personId) {   
        this.personId = personId;   
    }   
  
    /**
     * Gets Address Key
     * @return
     */
    public String getAddressId() {   
        return addressId;   
    }   
  
    /**
     * Sets Address Key
     * @param addressId
     */
    public void setAddressId(String addressId) {   
        this.addressId = addressId;   
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result
				+ ((personId == null) ? 0 : personId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person2AddressPK other = (Person2AddressPK) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		return true;
	}   


}
