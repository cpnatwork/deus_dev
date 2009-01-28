package deus.model.user.transportid;

public class IcqTransportId implements TransportId {

	@Override
	public TransportIdType getType() {
		return TransportIdType.icq;
	}

}
