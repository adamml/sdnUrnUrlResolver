package seaDataNetUrnUrl;

public class NotASeaDataNetURNException extends Exception{
	public NotASeaDataNetURNException() {
		super("The URN provided is not a SeaDataNet URN...");
	}
}