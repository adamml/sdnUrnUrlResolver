package seaDataNetUrnUrl;

public interface sdnUrnResolver {
	public enum sdn{
		SDN,
		CSR,
		EDMED,
		EDMO,
		EDMERP
	}
	
	public String getUrlFromUrn(String urn);
}
