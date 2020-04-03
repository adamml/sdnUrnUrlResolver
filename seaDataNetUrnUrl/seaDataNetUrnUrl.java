package seaDataNetUrnUrl;

public final class seaDataNetUrnUrl implements sdnUrnResolver{
	
	private static boolean isSeaDataNetUrn(String urnPrefix) {
		if(urnPrefix.compareTo(sdn.SDN.toString()) == 0) {
			return true;
		} else {
			return false;
		}
			
	}
	
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
	
	public seaDataNetUrnUrl() {}
	
	public String getUrlFromUrn(String urn) {
		String[] splitUrn = urn.split(":");
		if(checkUrnPrefix(splitUrn[0])) {
			
		}
		return "";
	}
}
