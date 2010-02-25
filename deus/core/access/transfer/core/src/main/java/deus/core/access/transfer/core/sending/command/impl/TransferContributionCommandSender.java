package deus.core.access.transfer.core.sending.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.core.access.transfer.common.messages.repatriation.ContributeMessage;
import deus.core.access.transfer.core.sending.command.ContributionCommandSender;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.frids.ContributorId;
import deus.model.common.user.frids.RepatriationAuthorityId;

@Component("contributionCommandSender")
public class TransferContributionCommandSender implements ContributionCommandSender {

	@Autowired
	private TransferMessageSenderHelper transferMessageSenderHelper;
	
	@Override
	public void forwardToCp(ContributorId contributorId, RepatriationAuthorityId repatriationAuthorityId,
			DigitalCard digitalCard) {
		TransferMessage transferMessage = new ContributeMessage(digitalCard);
		transferMessageSenderHelper.send(repatriationAuthorityId.getUserId(), contributorId.getUserId(), transferMessage);
	}

}
