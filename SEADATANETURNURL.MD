
## `public final class seaDataNetUrnUrl implements sdnUrnResolver`

This class resolves a SeaDataNet URN to a URL

The class can be used in the following way: 

```java
seaDataNetUrnUrl sdnu = new seaDataNetUrnUrl();
String url = sdnu.getUrlFromUrn("SDN:EDMO::575");
```

 * **Author:** Adam Leadbetter
 * **Version:** 0.1
 * **Since:** 0.1

## `private String entryID`

The ID of the catalogue entry or vocabulary term the URN refers to

## `private String entryVersionID`

The ID of the version of the catalogue entry or vocabulary term the URN refers to

## `private static boolean isSeaDataNetUrn(String urnPrefix)`

Checks that the URN begins with the characters "SDN"

 * **Parameters:** `urnPrefix` — String of the URN value prior to the first ":"
 * **Returns:** A boolean: true if the URN begins with the characters SDN, otherwise false

## `private static boolean checkUrnPrefix(String urnPrefix)`

Helper method to invoke isSeaDataNetUrn

 * **Parameters:** `urnPrefix` — String of the URN value prior to the first ":"
 * **Returns:** true if the URN begins with the characters SDN, otherwise false

## `private static String chooseCatalogue(String catalogue)`

Select the SeaDataNet catalogue and build the URN from the URL

 * **Parameters:** `catalogue` — String of the catalogue name to build the URL for
 * **Returns:** String of the URL the URN resolves to

## `public String getUrlFromUrn(String urn)`

Gets the URL for the URN supplied

 * **Parameters:** `urn` — String giving the URN to be resolved
 * **Returns:** String of the URL the URN resolves to
