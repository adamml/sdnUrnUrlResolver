# `Interface: sdnUrnResolver`

## `public enum sdn`

Defines the SeaDataNet URN prefix and the catalogue names

 * **Author:** Adam Leadbetter
 * **Since:** 0.1

## `SDN`

SeaDataNet URN prefix

## `CSR`

Cruise Summary Report catalogue name

## `EDMED`

European Directory of Marine Environmental Datasets catalogue name

## `EDMO`

European Directory of Marine Organisations catalogue name

## `EDMERP`

European Directory of Marine Research Projects catalogue name

## `public enum baseUrls`

Defines the base URLs to the SPARQL endpoints for the SeaDataNet catalogues

 * **Author:** Adam Leadbetter
 * **Since:** 0.1

## `EDMED("https:`

Base URL for the European Directory of Marine Environmental Datasets SPARQL endpoint

## `EDMO("https:`

Base URL for the European Directory of Marine Organisations SPARQL endpoint

## `CSR(""),`

Base URL for the Cruise Summary Reports SPARQL endpoint

## `EDMERP("https:`

Base URL for the European Directory of Marine Research Projects SPARQL endpoint

## `public String getUrl()`

 * **Returns:** String with the URL for the requested catalogue

## `BASEQUERY("query="),`

SPARQL Query webservice term for query parameter

## `OUTPUT("output=json")`

SPARQL Query output format declaration