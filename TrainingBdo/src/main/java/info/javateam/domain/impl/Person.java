package info.javateam.domain.impl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Sascha
 *
 */
/**
 * @author Sascha
 *
 */
/**
 * @author Sascha
 *
 */
@Entity
@Table(name = "Person")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String personId;
	private Long version;
	private String firstName;
	private String lastName;
	private Set<Address> address = new HashSet<Address>(0);

	/**
	 * Constructor
	 */
	public Person() {
	}

	/**
	 * Gets the Primary Key
	 * @return
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "PersonId")
	public String getPersonId() {
		return personId;
	}

	/**
	 * Sets the Primary Key
	 * @param personId
	 */
	public void setPersonId(String personId) {
		this.personId = personId;
	}

	/**
	 * Gets the Version Counter
	 * @return
	 */
	@Version
	@Column(name = "Version")
	public Long getVersion() {
		return version;
	}

	/**
	 * Sets the Version Counter
	 * @param version
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * Gets the FirstName
	 * @return
	 */
	@Column(name = "FirstName", nullable = true)
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the Version Counter
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the LastName
	 * @return
	 */
	@Column(name = "LastName", nullable = false)
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the LastName
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * Returns all Addresses
	 * @return
	 */
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Person2Address",  
		joinColumns = { @JoinColumn(name = "PersonId", nullable = false, updatable = false) }, 
		inverseJoinColumns = { @JoinColumn(name = "AdresseId", nullable = false, updatable = false) })
	public Set<Address> getAddress() {
		return address;
	}

	/**
	 * Sets all Addresses
	 * @param address
	 */
	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((personId == null) ? 0 : personId.hashCode());
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
		Person other = (Person) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

}
