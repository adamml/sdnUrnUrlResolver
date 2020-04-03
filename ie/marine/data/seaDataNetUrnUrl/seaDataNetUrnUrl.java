package ie.marine.data.seaDataNetUrnUrl;
/**
 * This class resolves a SeaDataNet URN to a URL
 * 
 * The class can be used in the following way:
 * {@code		seaDataNetUrnUrl sdnu = new seaDataNetUrnUrl();}
 * {@code		String url = sdnu.getUrlFromUrn("SDN:EDMO::575");}
 * 
 * @author 	Adam Leadbetter
 * @version 0.1
 * @since 	0.1
 *
 */
public final class seaDataNetUrnUrl implements sdnUrnResolver{
/**
 * The ID of the catalogue entry or vocabulary term the URN refers to	
 */
	private String entryID;
/**
 * The ID of the version of the catalogue entry or vocabulary term the URN refers to
 */
	private String entryVersionID;

/**
 * Checks that the URN begins with the characters "SDN"
 * 
 * @param 	urnPrefix	String of the URN value prior to the first ":"
 * @return	A boolean: true if the URN begins with the characters SDN, otherwise false
 */
	private static boolean isSeaDataNetUrn(String urnPrefix) {
		if(urnPrefix.compareTo(sdn.SDN.toString()) == 0) {
			return true;
		} else {
			return false;
		}
			
	}

/**
 * Helper method to invoke isSeaDataNetUrn
 * 
 * @param urnPrefix	String of the URN value prior to the first ":"
 * @return true if the URN begins with the characters SDN, otherwise false
 */
	private static boolean checkUrnPrefix(String urnPrefix) {
		try {
			if(!isSeaDataNetUrn(urnPrefix)) {
				throw new NotASeaDataNetURNException();
			} else {
				return true;
			}
		}
		catch (NotASeaDataNetURNException ex) {
			System.out.println(ex.getMessage());
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
				System.out.println(baseUrls.EDMED.getUrl());
				break;
			case CSR:
				System.out.println(baseUrls.CSR.getUrl());
				break;
			case EDMO:
				System.out.println(baseUrls.EDMO.getUrl());
				break;
			case EDMERP:
				System.out.println(baseUrls.EDMERP.getUrl());
				break;
			default:
				break;
		}
		return "";
	}
	
	public seaDataNetUrnUrl() {}
/**
 * Gets the URL for the URN supplied
 * 
 * @param 	urn	String giving the URN to be resolved
 * @return 	String of the URL the URN resolves to
 */
	public String getUrlFromUrn(String urn) {
		String[] splitUrn = urn.split(":");
		if(checkUrnPrefix(splitUrn[0])) {
			chooseCatalogue(splitUrn[1]);
		}
		return "";
	}
}
