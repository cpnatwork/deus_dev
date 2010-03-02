package deus.nsi.rest.pifgoverning;

import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import deus.core.soul.pifgoverning.PifGovernorExportedToClient;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.frids.RepatriationAuthorityId;
import deus.model.common.user.id.UserUrl;
import deus.model.pifgoverning.PersonalInformationFile;


// FIXME: use MarshallingHttpMessageConverter to marshal model elements to XML
@Controller
@RequestMapping("/users/{userId}/cp/pif")
public class PifGoverningController {

	private final static Logger logger = LoggerFactory.getLogger(PifGoverningController.class);
	
	@PostConstruct
	private void output() {
		System.out.println("HALLOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		logger.error("HALLOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
	}
	
	
	@Autowired
	private PifGovernorExportedToClient pifGovernor;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String getPif(@PathVariable("userId") String userId) {
		return "TEST";
		// FIXME: what to do if user does not exist?

		//return pifGovernor.getPersonalInformationFile(new RepatriationAuthorityId(new UserUrl(userId,
		//		"http://localhost"))).toString();
	}

	@RequestMapping(value = "dcs", method = RequestMethod.GET)
	@ResponseBody
	public String getDcs(@PathVariable("userId") String userId) {
		// FIXME: what to do if user does not exist?

		return pifGovernor.getPersonalInformationFile(
				new RepatriationAuthorityId(new UserUrl(userId, "http://localhost"))).getDigitalCards().toString();
	}

	@RequestMapping(value = "dcs/{discriminator}", method = RequestMethod.GET)
	@ResponseBody
	public String getDc(@PathVariable("userId") String userId,
			@PathVariable("discriminator") String discriminator) {
		Set<DigitalCard> dcs = pifGovernor.getPersonalInformationFile(
				new RepatriationAuthorityId(new UserUrl(userId, "http://localhost"))).getDigitalCards();

		// FIXME: this is not correct! when there are multiple DCs with the same
		// discriminator, only the first
		// one is returned. DCs have a primary key composed of three parts. Only
		// CP ID and the discriminator are
		// used here, Contributor ID is omitted. See page 16 of diploma thesis!

		for (DigitalCard dc : dcs) {
			if (dc.getDigitalCardId().getContributorProvidedDiscriminator().equals(discriminator))
				return dc.toString();
		}

		// FIXME: what to do in this case?
		return null;
	}
}
