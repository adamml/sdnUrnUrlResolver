package ie.marine.data.SeaDataNetUrnUrl;
/**
 * Defines an Exception to throw if the NERC Vocabulary Server Cannot Be Accessed
 * 
 * @author Adam Leadbetter
 * @version 0.1
 *
 */
@SuppressWarnings("serial")
public class CannotReadFromNercVocabularyServerException extends Exception{
	public CannotReadFromNercVocabularyServerException() {
		super("Cannot read from the NERC Vocabulary Server...");
	}
}