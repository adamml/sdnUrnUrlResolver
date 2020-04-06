package ie.marine.data.SeaDataNetUrnUrl;

import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * This class resolves a SeaDataNet URN to a URL
 * 
 * @author 	Adam Leadbetter
 * @version 0.1
 * @since 	0.1
 *
 */
public final class SeaDataNetUrnUrl implements SdnUrnResolver{
/**
 * The ID of the catalogue entry or vocabulary term the URN refers to	
 */
	private String entryID;
/**
 * The ID of the version of the catalogue entry or vocabulary term the URN refers to
 */
	private String entryVersionID;
/**
 * The list of valid vocabularies on the NERC Vocabulary Server
 */
	private String nvsVocabs;
// Method to encode a string value using `UTF-8` encoding scheme
    private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
/**
 * Checks that the URN begins with the characters "SDN"
 * 
 * @param urnPrefix	String of the URN value prior to the first ":"
 * @return true if the URN begins with the characters SDN, otherwise false
 */
	private static boolean checkUrnPrefix(String urnPrefix) {
		if(urnPrefix.compareTo(sdn.SDN.toString()) == 0) {
			return true;
		} else {
			return false;
		}
	}

/**
 * Select the SeaDataNet catalogue and build the URN from the URL
 * 	
 * @param 	catalogue	String of the catalogue name to build the URL for
 * @return	String of the URL the URN resolves to
 */
	private static String chooseCatalogue(String catalogue) {
		switch(sdn.valueOf(catalogue)) {
			case EDMED:
				return baseUrls.EDMED.getUrl() 
						+ queries.BASEQUERY.getQuery()
						+ queries.EDMED.getQuery()
						+ "&" + queries.OUTPUT.getQuery();
			case CSR:
				return baseUrls.CSR.getUrl() 
						+ queries.BASEQUERY.getQuery()
						+ "&" + queries.OUTPUT.getQuery();
			case EDMO:
				return baseUrls.EDMO.getUrl() 
						+ queries.BASEQUERY.getQuery()
						+ "&" + queries.OUTPUT.getQuery();
			case EDMERP:
				return baseUrls.EDMERP.getUrl() 
						+ queries.BASEQUERY.getQuery()
						+ "&" + queries.OUTPUT.getQuery();
			default:
				break;
		}
		return "";
	}
/**
 * Gets the current list of collections from the NERC Vocabulary Server
 * 	
 * @return
 * @throws IOException
 */
	private String getNVSCollections() throws IOException{
		StringBuilder content = new StringBuilder();
			URL url = new URL(baseUrls.VOCAB.getUrl() + 
					queries.BASEQUERY.getQuery() + 
					encodeValue(queries.VOCAB.getQuery()) + 
					"&" + queries.OUTPUT.getQuery());
			URLConnection urlConn = url.openConnection();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				content.append(line + "\n");
			}
			bufferedReader.close();
		return content.toString();
	}
	
/**
 * Get method for the list of NERC Vocabulary Server collections
 * 
 * @return A string containing the up to date list of NVS collections
 */
	private String getNvsVocabs() {
		return nvsVocabs;
	}
/**
 * Set method for the list of NERC Vocabulary Server collections
 * 
 * @param nvsVocabs A string containing the list of NVS collections to set
 */
	private void setNvsVocabs(String nvsVocabs) {
		this.nvsVocabs = nvsVocabs;
	}
	
	public SeaDataNetUrnUrl() throws CannotReadFromNercVocabularyServerException {
		try {
			setNvsVocabs(getNVSCollections());
		} catch (Exception e) {
			throw new CannotReadFromNercVocabularyServerException();
		}
	}
/**
 * Gets the URL for the URN supplied
 * 
 * @param 	urn	String giving the URN to be resolved
 * @return 	String of the URL the URN resolves to
 * @throws NotASeaDataNetURNException 
 */
	public String getUrlFromUrn(String urn) throws NotASeaDataNetURNException {
		String[] splitUrn = urn.split(":");
		if(checkUrnPrefix(splitUrn[0])) {
			return chooseCatalogue(splitUrn[1]);
		} else {
			throw new NotASeaDataNetURNException();
		}
	}
}
