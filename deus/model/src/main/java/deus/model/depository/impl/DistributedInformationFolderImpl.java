package deus.model.depository.impl;

import java.util.HashMap;
import java.util.Map;

import deus.model.depository.DistributedInformationFolder;
import deus.model.dossier.ForeignInformationFile;
import deus.model.dossier.InformationFile;
import deus.model.user.id.UserId;

public class DistributedInformationFolderImpl implements
		DistributedInformationFolder {

	private final UserId ownerId;
	
	protected Map<UserId, ForeignInformationFile> foreignInformationFiles;

	
	
	public DistributedInformationFolderImpl(UserId ownerId) {
		super();
		this.ownerId = ownerId;
		this.foreignInformationFiles = new HashMap<UserId, ForeignInformationFile>();
	}


	@Override
	public UserId getOwnerId() {
		return ownerId;
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
