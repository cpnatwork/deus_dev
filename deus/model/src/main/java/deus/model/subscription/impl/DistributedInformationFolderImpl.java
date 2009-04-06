package deus.model.subscription.impl;

import java.util.HashMap;
import java.util.Map;

import deus.model.difgoverning.DistributedInformationFolder;
import deus.model.difgoverning.ForeignInformationFile;
import deus.model.dossier.InformationFile;
import deus.model.user.id.UserId;

public class DistributedInformationFolderImpl implements
		DistributedInformationFolder {

	protected Map<UserId, ForeignInformationFile> foreignInformationFiles;

	
	
	public DistributedInformationFolderImpl() {
		super();
		this.foreignInformationFiles = new HashMap<UserId, ForeignInformationFile>();
	}

	@Override
	public InformationFile getForeignInformationFile(UserId publisherId) {
		if (!foreignInformationFiles.containsKey(publisherId))
			throw new IllegalArgumentException("no FIF for publisher id " + publisherId);
		else
			return foreignInformationFiles.get(publisherId);
	}


	@Override
	public void updateForeignInformationFile(ForeignInformationFile foreignInformationFile) {
		if (!foreignInformationFiles.containsKey(foreignInformationFile.getPublisherId()))
			throw new IllegalArgumentException("cannot update FIF " + foreignInformationFile
					+ ", it is not contained in the DIF yet!");
		else
			foreignInformationFiles.put(foreignInformationFile.getPublisherId(),
					foreignInformationFile);
	}


	@Override
	public void addForeignInformationFile(ForeignInformationFile foreignInformationFile) {
		if (foreignInformationFiles.containsKey(foreignInformationFile.getPublisherId()))
			throw new IllegalArgumentException("cannot add FIF " + foreignInformationFile
					+ ", there already exists a FIF with the same publisher id!");
		else
			foreignInformationFiles.put(foreignInformationFile.getPublisherId(),
					foreignInformationFile);
	}


}
