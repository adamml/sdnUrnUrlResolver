package ie.marine.data.seaDataNetUrnUrl;

public interface sdnUrnResolver {
/**
 * Defines the SeaDataNet URN prefix and the catalogue names
 * 
 * @author Adam Leadbetter
 * since 0.1
 *
 */
	public enum sdn{
		/**
		 * SeaDataNet URN prefix
		 */
		SDN,
		/**
		 * Cruise Summary Report catalogue name
		 */
		CSR,
		/**
		 * European Directory of Marine Environmental Datasets catalogue name
		 */
		EDMED,
		/**
		 * European Directory of Marine Organisations catalogue name
		 */
		EDMO,
		/**
		 * European Directory of Marine Research Projects catalogue name
		 */
		EDMERP
	}

/**
 * Defines the base URLs to the SPARQL endpoints for the SeaDataNet catalogues
 * 
 * @author Adam Leadbetter
 * @since 0.1
 *
 */
	public enum baseUrls {
		/**
		 * Base URL for the European Directory of Marine Environmental Datasets SPARQL endpoint
		 */
		EDMED("https://edmed.seadatanet.org/sparql/"),
		/**
		 * Base URL for the European Directory of Marine Organisations SPARQL endpoint
		 */
		EDMO("https://edmo.seadatanet.org/sparql/"),
		/**
		 * Base URL for the Cruise Summary Reports SPARQL endpoint
		 */
		CSR(""),
		/**
		 * Base URL for the European Directory of Marine Research Projects SPARQL endpoint
		 */
		EDMERP("https://edmo.seadatanet.org/sparql/");
		
		private String url;
		baseUrls(final String url){this.url = url;}
		/**
		 * 
		 * @return String with the URL for the requested catalogue
		 */
		public String getUrl() {return url;}
	}
	
	public enum queries {
		EDMED(""),
		EDMO(""),
		CSR(""),
		EDMERP(""),
		VOCAB(""),
		/**
		 * SPARQL Query webservice term for query parameter
		 */
		BASEQUERY("query="),
		/**
		 * SPARQL Query output format declaration
		 */
		OUTPUT("output=json");
		
		private String query;
		queries(final String query){this.query = query;}
		public String getQuery() {return query;}
	}
	
	public String getUrlFromUrn(String urn);
}
