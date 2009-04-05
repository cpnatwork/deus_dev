package deus.core.soul.repatriationhub;

import deus.core.access.transfer.core.receiving.soulcallback.repatriationhub.RepatriationHubExportedToPeer;



// FIXME: edit javadoc
/**
 * This system interface is responsible for receiving contributed digital cards (either from the user itself or from
 * another user) to be committed into the PIF.
 * 
 * The passed ID of the informationProvider must match the ID of the informationProvider in the digital card!
 * 
 * The ID of the user, to which this contribution counter belongs must match the ID of the CP in the digital card!
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface RepatriationHub extends RepatriationHubExportedToClient, RepatriationHubExportedToPeer {
	
}
