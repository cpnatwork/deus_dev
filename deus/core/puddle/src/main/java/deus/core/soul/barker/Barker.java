package deus.core.soul.barker;

import deus.model.attention.decision.BinaryDecisionToMake;


public interface Barker extends BarkerExportedToSubsystems, BarkerExportedToClient {

	// TODO: move this to own subsystem
	public abstract void processDecision(BinaryDecisionToMake decision);

}