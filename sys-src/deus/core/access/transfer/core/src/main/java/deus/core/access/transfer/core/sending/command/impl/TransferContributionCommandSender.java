package deus.core.access.transfer.core.sending.command.impl;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.core.access.transfer.common.messages.repatriation.ContributeMessage;
import deus.core.access.transfer.core.sending.command.ContributionCommandSender;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.frids.ContributorId;
import deus.model.common.user.frids.RepatriationAuthorityId;

@Named("contributionCommandSender")
public class TransferContributionCommandSender implements ContributionCommandSender {

	@Inject
	private TransferMessageSenderHelper transferMessageSenderHelper;
	
	@Override
	public void forwardToCp(ContributorId contributorId, RepatriationAuthorityId repatriationAuthorityId,
			DigitalCard digitalCard) {
		TransferMessage transferMessage = new ContributeMessage(digitalCard);
		transferMessageSenderHelper.send(repatriationAuthorityId.getUserId(), contributorId.getUserId(), transferMessage);
	}

}
