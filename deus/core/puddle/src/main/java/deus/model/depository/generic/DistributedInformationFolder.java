package deus.model.depository.generic;

import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.user.id.UserId;

/**
 * <code>DistributedInformationFolder</code> (DIF) represents a collection of Foreign Information Files (FIFs).
 * 
 * A FIF can be updated by calling the method <code>updateForeignInformationFile</code>, if this FIF is already in the
 * DIF.
 * 
 * A FIF can be added to the DIF by calling the method <code>addForeignInformationFile</code>. In this case, the FIF
 * must not exist in the DIF yet.
 * 
 * 
 * @see deus.model.dossier.ForeignInformationFile.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 * @param <ContentType> The type of content, the FIFs contain
 */
public interface DistributedInformationFolder<ContentType> {

	public ForeignInformationFile<ContentType> getForeignInformationFile(UserId publisherId);


	public void updateForeignInformationFile(ForeignInformationFile<ContentType> foreignInformationFile);


	public void addForeignInformationFile(ForeignInformationFile<ContentType> foreignInformationFile);

}
