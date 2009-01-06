package dacus.storage.party.address;

import java.util.Locale;
import java.util.UUID;

import dacus.storage.party.common.EntityTag;

public abstract class Address {

	private UUID id;
	private EntityTag entityTag;

	private Locale country;
	private String region;

	private String locality; // city
	private String zip;

	private String extension;


	public Address() {
		id = UUID.randomUUID();
	}


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public EntityTag getEntityTag() {
		return entityTag;
	}


	public void setEntityTag(EntityTag entityTag) {
		this.entityTag = entityTag;
	}


	public Locale getCountry() {
		return country;
	}


	public void setCountry(Locale country) {
		this.country = country;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getLocality() {
		return locality;
	}


	public void setLocality(String locality) {
		this.locality = locality;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getExtension() {
		return extension;
	}


	public void setExtension(String extension) {
		this.extension = extension;
	}


}
