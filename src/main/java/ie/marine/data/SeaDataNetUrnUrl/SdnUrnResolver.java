package ie.marine.data.SeaDataNetUrnUrl;

public interface SdnUrnResolver {
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
		EDMERP("https://edmerp.seadatanet.org/sparql/"),
		/**
		 * Base URL for the NERC Vocabulary Server SPARQL endpoint
		 */
		VOCAB("http://vocab.nerc.ac.uk/sparql/"),
		/**
		 * Base URL for a SKOS collection in the NERC Vocabulary Server
		 */
		VOCABCOLLECTION("http://vocab.nerc.ac.uk/collection/");
		
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
		VOCAB("PREFIX skos:<http://www.w3.org/2004/02/skos/core#> PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> SELECT ?s WHERE {?s rdf:type skos:Collection}"),
		/**
		 * SPARQL Query webservice term for query parameter
		 */
		BASEQUERY("sparql?query="),
		/**
		 * SPARQL Query output format declaration
		 */
		OUTPUT("output=json");
		
		private String query;
		queries(final String query){this.query = query;}
		public String getQuery() {return query;}
	}
	
	public String getUrlFromUrn(String urn) throws NotASeaDataNetURNException;
}
