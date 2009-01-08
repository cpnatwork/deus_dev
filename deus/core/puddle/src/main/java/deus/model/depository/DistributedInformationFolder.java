package deus.model.depository;

import deus.model.dossier.ForeignInformationFile;
import deus.model.user.id.UserId;

/**
 * <code>DistributedInformationFolder</code> (DIF) represents a collection of
 * Foreign Information Files (FIFs).
 * 
 * A FIF can be updated by calling the method
 * <code>updateForeignInformationFile</code>, if this FIF is already in the DIF.
 * 
 * A FIF can be added to the DIF by calling the method
 * <code>addForeignInformationFile</code>. In this case, the FIF must not exist
 * in the DIF yet.
 * 
 * 
 * @see deus.model.dossier.ForeignInformationFile.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 * @param <Id>	the ID of the
 * @param <ContentType>		The type of content, the FIFs contain
 */
public interface DistributedInformationFolder<Id extends UserId, ContentType> {

	public ForeignInformationFile<Id, ContentType> getForeignInformationFile(Id publisherId);


	public void updateForeignInformationFile(ForeignInformationFile<Id, ContentType> foreignInformationFile);


	public void addForeignInformationFile(ForeignInformationFile<Id, ContentType> foreignInformationFile);

}
