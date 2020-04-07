# Interface: SdnUrnResolver

## Package ie.marine.data.SeaDataNetUrnUrl

## public enum sdn

Defines the SeaDataNet URN prefix and the catalogue names

 * **Author:** Adam Leadbetter

     since 0.1

     <p>

### SDN

SeaDataNet URN prefix

### CSR

Cruise Summary Report catalogue name

### EDMED

European Directory of Marine Environmental Datasets catalogue name

### EDMO

European Directory of Marine Organisations catalogue name

### EDMERP

European Directory of Marine Research Projects catalogue name

## public enum baseUrls

Defines the base URLs to the SPARQL endpoints for the SeaDataNet catalogues

 * **Author:** Adam Leadbetter
 * **Since:** 0.1

### EDMED

Base URL for the European Directory of Marine Environmental Datasets SPARQL endpoint

### EDMO

Base URL for the European Directory of Marine Organisations SPARQL endpoint

### CSR

Base URL for the Cruise Summary Reports SPARQL endpoint

### EDMERP

Base URL for the European Directory of Marine Research Projects SPARQL endpoint

### VOCAB

Base URL for the NERC Vocabulary Server SPARQL endpoint

### VOCABCOLLECTION

Base URL for a SKOS collection in the NERC Vocabulary Server

### public String getUrl()

 * **Returns:** String with the URL for the requested catalogue

## public enum queries

### PREFIX

RDF Prefixes for use in the SPARQL queries

### EDMO

SPARQL query to give all European Directory of Marine Organisations entries

### EDMORECORD

SPARQL query for all detail for an individual record in the European Directory of Marine Organisations

### EDMERP

SPARQL query to give all European Directory of Marine Research Projects entries

### EDMERPRECORD

SPARQL query to give all details for an individual record in the European Directory of Marine Research Projects

### VOCAB

SPARQL query to give a list of all SKOS Collections on the NERC Vocabulary Server

### VOCABCOLLN

SPARQL query to give all details for a SKOS collection on the NERC Vocabulary Server

### VOCABCONCEPT

SPARQL query to give all details for a SKOS Concept on the NERC Vocabulary Server

### BASEQUERY

SPARQL Query webservice term for query parameter

### OUTPUT

SPARQL Query output format declaration

### public String getQuery()

Get a SPARQL query value

 * **Returns:** A string of the specified query