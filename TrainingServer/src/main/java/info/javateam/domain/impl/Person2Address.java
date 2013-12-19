package info.javateam.domain.impl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author Sascha
 *
 */
@Table 
@Entity 
public class Person2Address implements Serializable {
	private static final long serialVersionUID = 1L;

    @EmbeddedId  
    private Person2AddressPK person2AddressPK = new Person2AddressPK();   
	
	
	@MapsId("personId")   
    @JoinColumn(name = "PersonId", referencedColumnName = "PersonId")   
    @ManyToOne(optional = true, fetch = FetchType.EAGER)  
	private Person personId;

	@MapsId("adresseId")   
    @JoinColumn(name = "AddressId", referencedColumnName = "AddressId")   
    @ManyToOne(optional = true, fetch = FetchType.EAGER)  
	private Address addressId;
	
	@Version @Column ( name = "Version" )
	private Long version;

	@Column(name = "Typ", nullable = false) 
	private String type;
	
	/**
	 * Constructor
	 */
	public Person2Address() {
	}

	/**
	 * get Key between Address and Person
	 * @return
	 */
	public Person2AddressPK getPerson2AdressePK() {
		return person2AddressPK;
	}
	
	/**
	 * set Key between Address and Person
	 * @param person2AdressePK
	 */
	public void setPerson2AddressPK(Person2AddressPK person2AdressePK) {
		this.person2AddressPK = person2AdressePK;
	}
	
	/**
	 * gets Version Counter
	 * @return
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * sets Version Counter
	 * @param version
	 */
	public void setVersion(Long version) {
		this.version = version;
	}
	
	/**
	 * sets Foreign Key Person
	 * @return
	 */
	public Person getPersonId() {
		return personId;
	}

	/**
	 * gets Foreign Key Person
	 * @param personId
	 */
	public void setPersonId(Person personId) {
		this.personId = personId;
	}

	/**
	 * gets Foreign Key Address
	 * @return
	 */
	public Address getAdresseId() {
		return addressId;
	}

	/**
	 * sets Foreign Key Address
	 * @param adresseId
	 */
	public void setAdresseId(Address adresseId) {
		this.addressId = adresseId;
	}
	
	/**
	 * gets Address Type
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * sets Address Type
	 * @param type
	 */
	public void setTyp(String type) {
		this.type = type;
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
		result = prime
				* result
				+ ((person2AddressPK == null) ? 0 : person2AddressPK.hashCode());
		result = prime * result
				+ ((personId == null) ? 0 : personId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		Person2Address other = (Person2Address) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (person2AddressPK == null) {
			if (other.person2AddressPK != null)
				return false;
		} else if (!person2AddressPK.equals(other.person2AddressPK))
			return false;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
}
