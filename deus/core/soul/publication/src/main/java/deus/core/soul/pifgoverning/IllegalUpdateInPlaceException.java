package deus.core.soul.pifgoverning;

import deus.model.common.dossier.DigitalCardId;

public class IllegalUpdateInPlaceException extends RuntimeException {

	private static final long serialVersionUID = 2832320625382280955L;

	private final DigitalCardId digitalCardId;


	public IllegalUpdateInPlaceException(DigitalCardId digitalCardId) {
		super();
		this.digitalCardId = digitalCardId;
	}


	public DigitalCardId getDigitalCardId() {
		return digitalCardId;
	}

}
