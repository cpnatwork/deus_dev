package deus.core.publisher;


public interface RemoteCallingPublisher {

	/**
	 * If this object has changed, as indicated by the <code>hasChanged</code> method, then notify all of its observers
	 * and then call the <code>clearChanged</code> method to indicate that this object has no longer changed.
	 * <p>
	 * Each observer has its <code>update</code> method called with two arguments: this observable object and
	 * <code>null</code>. In other words, this method is equivalent to: <blockquote><tt>
	 * notifyObservers(null)</tt>
	 * </blockquote>
	 * 
	 * @see java.util.Observable#clearChanged()
	 * @see java.util.Observable#hasChanged()
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	// TODO: think about whether to delete this method
	public abstract void notifyObservers();


	/**
	 * If this object has changed, as indicated by the <code>hasChanged</code> method, then notify all of its observers
	 * and then call the <code>clearChanged</code> method to indicate that this object has no longer changed.
	 * <p>
	 * Each observer has its <code>update</code> method called with two arguments: this observable object and the
	 * <code>arg</code> argument.
	 * 
	 * @param change any object.
	 * @see java.util.Observable#clearChanged()
	 * @see java.util.Observable#hasChanged()
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public abstract void notifyObservers(Object change);

}