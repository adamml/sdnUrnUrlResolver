# sdnUrnUrlResolver
A Java implementation of the URN to URL resolver for SeaDataNet

[![Build Status](https://travis-ci.org/adamml/sdnUrnUrlResolver.svg?branch=master)](https://travis-ci.org/adamml/sdnUrnUrlResolver)

## Package ie.marine.data.seaDataNetUrnUrl`

### Example Usage
```java
seaDataNetUrnUrl sdnu = new seaDataNetUrnUrl();
String url = sdnu.getUrlFromUrn("SDN:EDMO::575");
```

### Class documentation
- public interface [sdnUrnUrlResolver](SDNURNRESOLVER.MD)
- public final class [seaDataNetUrnUrl](SEADATANETURNURL.MD) implements sdnUrnUrlresolver
- public class [NotASeaDataNetURNException](NOTASEADATANETURNEXCEPTION.MD) extends Exception
