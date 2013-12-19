package info.javateam.domain.impl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Sascha
 *
 */
@Entity
@Table(name = "Address")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long version;
	private String addressId;
	private String street;
	private String zip;
	private String city;

	/**
	 * Gets the Primary Key
	 * @return
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "AddressId")
	public String getAddressId() {
		return addressId;
	}

	/**
	 * Sets the Primary Key
	 * @param addressId
	 */
	public void setAddressId(String addressId) {
		this.addressId = addressId;
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
	 * Gets the Street
	 * @return
	 */
	@Column(name = "Street", nullable = false)
	public String getStreet() {
		return street;
	}

	/**
	 * Sets the Street
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Gets the ZIP-Code
	 * @return
	 */
	@Column(name = "ZIP", nullable = false)
	public String getZip() {
		return zip;
	}

	/**
	 * Sets the ZIP-Code
	 * @param zip
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * Gets the City
	 * @return
	 */
	@Column(name = "City", nullable = false)
	public String getCity() {
		return city;
	}

	/**
	 * Sets the City
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
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
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		// result = prime * result + ((version == null) ? 0 :
		// version.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
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
		Address other = (Address) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;

		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;

		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

}