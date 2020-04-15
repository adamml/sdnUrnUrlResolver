# sdnUrnUrlResolver
A Java implementation of the URN to URL resolver for SeaDataNet

[![Build Status](https://travis-ci.org/adamml/sdnUrnUrlResolver.svg?branch=master)](https://travis-ci.org/adamml/sdnUrnUrlResolver)

## Package ie.marine.data.seadatanet.urn.resolver

A number of SPARQL queries are defined in the `SdnUrnUrlResolver` Interface, within the `queries` enum. The raw queries are maintained in other repositories: for the [NERC Vocabulary Server](https://github.com/adamml/nvs-sparql) and for the [SeaDataNet catalogues](https://github.com/adamml/seadatanet-sparql-queries).

### Example Usage
```java
import ie.marine.data.seadatanet.urn.resolver.*;

public class run {
	public static void main(String[] args) throws NotASeaDataNetURNException, CannotReadFromNercVocabularyServerException {
		SeaDataNetUrnUrl sdnu = new SeaDataNetUrnUrl();
		System.out.println(sdnu.getUrlFromUrn("SDN:EDMED::4565"));
	}
}
```

### Class documentation
JavaDoc documentation can be viewed [here](https://adamml.github.io/sdnUrnUrlResolver/).

### Unit tests
Unit tests are written in JUnit 5 and can be executed via `maven test`.