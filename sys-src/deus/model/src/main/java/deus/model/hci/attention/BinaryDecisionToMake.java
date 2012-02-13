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
package deus.model.hci.attention;

/**
 * The Class BinaryDecisionToMake.
 */
public abstract class BinaryDecisionToMake extends AttentionElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5599768940314917357L;
	/** The decision. */
	private Boolean decision = null;

	/**
	 * Checks if is decision made.
	 * 
	 * @return true, if is decision made
	 */
	public final boolean isDecisionMade() {
		return this.decision != null;
	}

	/**
	 * Sets the decision positive.
	 */
	public final void setDecisionPositive() {
		this.decision = true;
	}

	/**
	 * Sets the decision negative.
	 */
	public final void setDecisionNegative() {
		this.decision = false;
	}

	/**
	 * Assert is decision made.
	 */
	private final void assertIsDecisionMade() {
		if (!this.isDecisionMade())
			throw new IllegalStateException("decision is not made yet!");
	}

	/**
	 * Checks if is decision positive.
	 * 
	 * @return true, if is decision positive
	 */
	public final boolean isDecisionPositive() {
		this.assertIsDecisionMade();
		return this.decision == true;
	}

	/**
	 * Checks if is decision negative.
	 * 
	 * @return true, if is decision negative
	 */
	public final boolean isDecisionNegative() {
		this.assertIsDecisionMade();
		return this.decision == false;
	}

	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public abstract DecisionType getType();

}
