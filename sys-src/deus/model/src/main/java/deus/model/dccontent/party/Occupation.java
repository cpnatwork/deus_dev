/**************************************************************************
 * DACUS: Distributed Address Card Update System
 * ==============================================
 * Copyright (C) 2008-2012 by 
 *   - Christoph P. Neumann (http://www.chr15t0ph.de)
 *   - Florian Rampp
 **************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 **************************************************************************
 * $Id$
 *************************************************************************/
package deus.model.dccontent.party;

import java.awt.Image;

/**
 * The Class Occupation.
 */
public class Occupation {

	/** The institution. */
	private String institution;
	
	/** The department. */
	private String department;

	/** The title. */
	private String title;
	
	/** The role. */
	private String role;

	/** The office. */
	private String office;

	/** The logo. */
	private Image logo;


	/**
	 * Gets the institution.
	 * 
	 * @return the institution
	 */
	public String getInstitution() {
		return institution;
	}


	/**
	 * Sets the institution.
	 * 
	 * @param institution
	 *            the new institution
	 */
	public void setInstitution(String institution) {
		this.institution = institution;
	}


	/**
	 * Gets the department.
	 * 
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}


	/**
	 * Sets the department.
	 * 
	 * @param department
	 *            the new department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}


	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * Sets the title.
	 * 
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * Gets the role.
	 * 
	 * @return the role
	 */
	public String getRole() {
		return role;
	}


	/**
	 * Sets the role.
	 * 
	 * @param role
	 *            the new role
	 */
	public void setRole(String role) {
		this.role = role;
	}


	/**
	 * Gets the office.
	 * 
	 * @return the office
	 */
	public String getOffice() {
		return office;
	}


	/**
	 * Sets the office.
	 * 
	 * @param office
	 *            the new office
	 */
	public void setOffice(String office) {
		this.office = office;
	}


	/**
	 * Gets the logo.
	 * 
	 * @return the logo
	 */
	public Image getLogo() {
		return logo;
	}


	/**
	 * Sets the logo.
	 * 
	 * @param logo
	 *            the new logo
	 */
	public void setLogo(Image logo) {
		this.logo = logo;
	}

}
