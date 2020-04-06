package ie.marine.data.SeaDataNetUrnUrl;
/**
 * Defines an Exception to throw if the URN encountered is not from the SeaDataNet namespace
 * 
 * @author Adam Leadbetter
 * @version 0.1
 *
 */
@SuppressWarnings("serial")
public class NotASeaDataNetURNException extends Exception{
	public NotASeaDataNetURNException() {
		super("The URN provided is not a SeaDataNet URN...");
	}
}