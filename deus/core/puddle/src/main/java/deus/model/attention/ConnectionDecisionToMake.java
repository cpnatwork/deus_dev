package deus.model.attention;

public abstract class ConnectionDecisionToMake extends DecisionToMake {

	private boolean connect;


	public boolean isConnect() {
		return connect;
	}


	public void setConnect(boolean connect) {
		this.connect = connect;
	}

}
