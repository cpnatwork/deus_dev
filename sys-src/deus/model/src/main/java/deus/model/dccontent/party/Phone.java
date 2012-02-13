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

import deus.model.dccontent.party.common.EntityTag;

/**
 * The Class Phone.
 */
public class Phone {

	/** The entity tag. */
	private EntityTag entityTag;

	// capabilities
	/** The voice. */
	private boolean voice;
	
	/** The text. */
	private boolean text;
	
	/** The video. */
	private boolean video;

	/** The type. */
	private PhoneType type;

	/** The number. */
	private String number;


	/**
	 * Gets the entity tag.
	 * 
	 * @return the entity tag
	 */
	public EntityTag getEntityTag() {
		return entityTag;
	}


	/**
	 * Sets the entity tag.
	 * 
	 * @param entityTag
	 *            the new entity tag
	 */
	public void setEntityTag(EntityTag entityTag) {
		this.entityTag = entityTag;
	}


	/**
	 * Checks if is voice.
	 * 
	 * @return true, if is voice
	 */
	public boolean isVoice() {
		return voice;
	}


	/**
	 * Sets the voice.
	 * 
	 * @param voice
	 *            the new voice
	 */
	public void setVoice(boolean voice) {
		this.voice = voice;
	}


	/**
	 * Checks if is text.
	 * 
	 * @return true, if is text
	 */
	public boolean isText() {
		return text;
	}


	/**
	 * Sets the text.
	 * 
	 * @param text
	 *            the new text
	 */
	public void setText(boolean text) {
		this.text = text;
	}


	/**
	 * Checks if is video.
	 * 
	 * @return true, if is video
	 */
	public boolean isVideo() {
		return video;
	}


	/**
	 * Sets the video.
	 * 
	 * @param video
	 *            the new video
	 */
	public void setVideo(boolean video) {
		this.video = video;
	}


	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public PhoneType getType() {
		return type;
	}


	/**
	 * Sets the type.
	 * 
	 * @param type
	 *            the new type
	 */
	public void setType(PhoneType type) {
		this.type = type;
	}


	/**
	 * Gets the number.
	 * 
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}


	/**
	 * Sets the number.
	 * 
	 * @param number
	 *            the new number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

}
