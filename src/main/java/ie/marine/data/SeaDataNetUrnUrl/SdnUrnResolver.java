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
		/**
		 * RDF Prefixes for use in the SPARQL queries
		 */
		PREFIX("PREFIX skos:<http://www.w3.org/2004/02/skos/core#> PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"),
		EDMED(""),
		EDMEDRECORD(""),
		/**
		 * SPARQL query to give all European Directory of Marine Organisations entries
		 */
		EDMO("SELECT DISTINCT ?s ?p WHERE {?s rdf:type <http://www.w3.org/ns/org#Organization>. ?s skos:prefLabel ?p} ORDER By ?p"),
		/**
		 * SPARQL query for all detail for an individual record in the European Directory of Marine Organisations
		 */
		EDMORECORD("SELECT ?s ?o ?p WHERE {{BIND (<http://edmo.seadatanet.org/%s> AS ?s)?s ?o ?p} UNION {BIND (<http://edmo.seadatanet.org/%s> as ?org) ?org <http://www.w3.org/ns/org#hasSite> ?site. ?site <http://www.w3.org/ns/org#siteAddress> ?s. ?s ?o ?p} UNION { BIND (<http://edmo.seadatanet.org/%s> as ?org) ?org <http://www.w3.org/ns/org#hasSite> ?site. ?site <http://www.w3.org/ns/org#siteAddress> ?a. ?a <http://www.w3.org/2006/vcard/ns#hasGeo> ?s. ?s ?o ?p} UNION { BIND (<http://edmo.seadatanet.org/%s> as ?org) ?org <http://www.w3.org/ns/org#hasSite> ?site. ?site <http://www.w3.org/ns/org#siteAddress> ?a. ?a <http://www.w3.org/2006/vcard/ns#hasTelephone> ?s. ?s ?o ?p }}"),
		CSR(""),
		CSRECORD(""),
		/**
		 * SPARQL query to give all European Directory of Marine Research Projects entries
		 */
		EDMERP("SELECT ?s ?o WHERE {?s rdf:type <http://dbpedia.org/ontology/ResearchProject>. ?s <http://www.w3.org/2000/01/rdf-schema#label> ?o}"),
		/**
		 * SPARQL query to give all details for an individual record in the European Directory of Marine Research Projects
		 */
		EDMERPRECORD("SELECT ?s ?p ?o where {BIND(<http://edmerp.seadatanet.org/report/%s> AS ?s) ?s ?p ?o}"),
		/**
		 * SPARQL query to give a list of all SKOS Collections on the NERC Vocabulary Server
		 */
		VOCAB("SELECT ?s WHERE {?s rdf:type skos:Collection}"),
		/**
		 * SPARQL query to give all details for a SKOS collection on the NERC Vocabulary Server
		 */
		VOCABCOLLN("SELECT DISTINCT ?s ?o ?p WHERE {{BIND (<http://vocab.nerc.ac.uk/collection/%s/current/> as ?s) ?s rdf:type skos:Collection. ?s  ?o ?p} UNION {BIND (<http://vocab.nerc.ac.uk/collection/%s/current/> as ?a) BIND (skos:prefLabel as ?o) ?a skos:member ?s.?s ?o ?p}}"),
		/**
		 * SPARQL query to give all details for a SKOS Concept on the NERC Vocabulary Server
		 */
		VOCABCONCEPT("SELECT ?s ?o ?p WHERE {BIND (<http://vocab.nerc.ac.uk/collection/%s/current/%s/> as ?s) ?s rdf:type skos:Concept. ?s ?o ?p}"),
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
		/**
		 * Get a SPARQL query value
		 * 
		 * @return A string of the specified query
		 */
		public String getQuery() {return query;}
	}
	
	public String getUrlFromUrn(String urn) throws NotASeaDataNetURNException;
}
