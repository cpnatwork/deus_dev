package deus.model.user.id.transportid;

public class IcqTransportId implements TransportId {

	@Override
	public TransportIdType getType() {
		return TransportIdType.icq;
	}

}
