package dacus.storage.party.person.occupation;

import java.awt.Image;
import java.util.UUID;

public class Occupation {

	private UUID id;

	private String institution;
	private String department;

	private String title;
	private String role;

	private String office;

	private Image logo;
	
	public Occupation() {
		id = UUID.randomUUID();
	}


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getInstitution() {
		return institution;
	}


	public void setInstitution(String institution) {
		this.institution = institution;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getOffice() {
		return office;
	}


	public void setOffice(String office) {
		this.office = office;
	}


	public Image getLogo() {
		return logo;
	}


	public void setLogo(Image logo) {
		this.logo = logo;
	}

}
