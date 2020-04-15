package ie.marine.data.seadatanet.urn.resolver;

import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

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
/**
 * Add a logger
 */
	private final static Logger LOGGER = Logger.getLogger(SeaDataNetUrnUrl.class.getName());
/**
 * @return the entryID
 */
	private String getEntryID() {
		return entryID;
	}
/**
 * @param entryID the entryID to set
 */
	private void setEntryID(String entryID) {
		this.entryID = entryID;
	}
/**
 * @return the entryVersionID
 */
	private String getEntryVersionID() {
		return entryVersionID;
	}
/**
 * @param entryVersionID the entryVersionID to set
 */
	private void setEntryVersionID(String entryVersionID) {
		this.entryVersionID = entryVersionID;
	}
/**
 * Method to encode a string value using UTF-8 encoding scheme
 * 
 * @param value String to be encoded
 * @return UTF-8 encoded String
 */
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
 * @param 	urn			String of the SeaDataNet URN to be resolved
 * @param 	catalogue	String of the catalogue name to build the URL for
 * @return	String of the URL the URN resolves to
 * @throws NotASeaDataNetURNException If the URN does not match the SeaDataNet pattern
 */
	private String chooseCatalogue(String urn, String catalogue) throws NotASeaDataNetURNException {
		String query;
		try {
			switch(sdn.valueOf(catalogue)) {
				case EDMED:
					query = baseUrls.EDMED.getUrl() 
							+ queries.BASEQUERY.getQuery()
							+ encodeValue(queries.PREFIX.getQuery() + " ");
					if(getEntryID() == null) {
						query = query + encodeValue(queries.EDMED.getQuery());
					} else {
						String EDMEDurl = String.format(baseUrls.EDMEDRECORD.getUrl(), getEntryID());
						query = query + 
								encodeValue(String.format(queries.EDMEDRECORD.getQuery(),EDMEDurl,EDMEDurl,EDMEDurl,EDMEDurl,EDMEDurl,EDMEDurl,EDMEDurl,EDMEDurl,EDMEDurl,EDMEDurl,EDMEDurl,EDMEDurl));
					}
					return query + "&" + queries.OUTPUT.getQuery();
				case CSR:
					return baseUrls.CSR.getUrl() 
							+ queries.BASEQUERY.getQuery()
							+ encodeValue(queries.PREFIX.getQuery() + " ")
							+ "&" + queries.OUTPUT.getQuery();
				case EDMO:
					query = baseUrls.EDMO.getUrl()
						+ queries.BASEQUERY.getQuery()
						+ encodeValue(queries.PREFIX.getQuery() + " ");
					if(getEntryID() == null) {
						query = query
							+ encodeValue(queries.EDMO.getQuery());
					} else {
						query = query
							+ encodeValue(String.format(queries.EDMORECORD.getQuery(),getEntryID(),getEntryID(),getEntryID(),getEntryID()));
					}
					return query + "&" + queries.OUTPUT.getQuery();
				case EDMERP:
					query = baseUrls.EDMERP.getUrl() 
							+ queries.BASEQUERY.getQuery()
							+ encodeValue(queries.PREFIX.getQuery() + " ");
					if(getEntryID() == null) {
						query = query
							+ encodeValue(queries.EDMERP.getQuery());
					} else {
						query = query
							+ encodeValue(String.format(queries.EDMERPRECORD.getQuery(),getEntryID()));
					}
					return query + "&" + queries.OUTPUT.getQuery();
				default:
					throw new NotASeaDataNetURNException(urn);
			}} catch (Exception e) {
				if(getNvsVocabs().indexOf(catalogue) < 0) {
					throw new NotASeaDataNetURNException(urn);
				} else {
					if(getEntryVersionID() == null) {
						setEntryVersionID("current");
					}
					query = baseUrls.VOCAB.getUrl() 
							+ queries.BASEQUERY.getQuery()
							+ encodeValue(queries.PREFIX.getQuery() + " ");
					if(getEntryID() == null) {
						query = query
								+ encodeValue(String.format(queries.VOCABCOLLN.getQuery(),catalogue,catalogue));
					} else {
						query = query
							+ encodeValue(String.format(queries.VOCABCONCEPT.getQuery(),catalogue,getEntryID()));
					}
					return query + "&" + queries.OUTPUT.getQuery();
				}
			}
	}
	private String getListOfNvsCollectionsFromJSONString(String JSON) {
		String returnVal = "";
		while(JSON.indexOf(baseUrls.VOCABCOLLECTION.getUrl()) > 0) {
			
			JSON = JSON.substring(JSON.indexOf(baseUrls.VOCABCOLLECTION.getUrl()) + baseUrls.VOCABCOLLECTION.getUrl().length());
			returnVal = returnVal + JSON.substring(0,JSON.indexOf("/")) + " ";
		}
		return returnVal;
	}
/**
 * Gets the current list of collections from the NERC Vocabulary Server
 * 	
 * @return String containg the list of NERC Vocabulary Server Concept Collections
 * @throws IOException If cannot read from  NERC Vocabulary Server
 */
	private String getNVSCollections() throws IOException{
		StringBuilder content = new StringBuilder();
			URL url = new URL(baseUrls.VOCAB.getUrl() + 
					queries.BASEQUERY.getQuery() + 
					encodeValue(queries.PREFIX.getQuery() + " ") +
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
			setNvsVocabs(getListOfNvsCollectionsFromJSONString(getNVSCollections()));
		} catch (Exception e) {
			throw new CannotReadFromNercVocabularyServerException();
		}
	}
/**
 * Gets the URL for the URN supplied
 * 
 * @param 	urn	String giving the URN to be resolved
 * @return 	String of the URL the URN resolves to
 * @throws NotASeaDataNetURNException If the URN does not meet the SeaDataNet patterns, an exception is thrown
 */
	public String getUrlFromUrn(String urn) throws NotASeaDataNetURNException {
		String[] splitUrn = urn.split(":");
		if(splitUrn.length < 2 || splitUrn.length > 4) {
			throw new NotASeaDataNetURNException(urn);
		} else if (splitUrn.length == 2) {
			setEntryVersionID(null);
			setEntryID(null);
		} else if (splitUrn.length == 3) {
			setEntryVersionID(splitUrn[2]);
			setEntryID(null);
		} else {
			setEntryVersionID(splitUrn[2]);
			setEntryID(splitUrn[3]);
		}
		if(checkUrnPrefix(splitUrn[0])) {
			return chooseCatalogue(urn,splitUrn[1]);
		} else {
			throw new NotASeaDataNetURNException(urn);
		}
	}
}
