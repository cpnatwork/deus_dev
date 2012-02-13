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
package deus.core.soul.hci.barker;

/**
 * The Class BarkerRuntimeException.
 */
public class BarkerRuntimeException extends RuntimeException {

	/**
	 * Instantiates a new barker runtime exception.
	 */
	public BarkerRuntimeException() {
		super();
	}


	/**
	 * Instantiates a new barker runtime exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public BarkerRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}


	/**
	 * Instantiates a new barker runtime exception.
	 * 
	 * @param message
	 *            the message
	 */
	public BarkerRuntimeException(String message) {
		super(message);
	}


	/**
	 * Instantiates a new barker runtime exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public BarkerRuntimeException(Throwable cause) {
		super(cause);
	}

}
