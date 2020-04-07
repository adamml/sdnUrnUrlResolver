# Class: SeaDataNetUrnUrl

## Package ie.marine.data.SeaDataNetUrnUrl

## public final class SeaDataNetUrnUrl implements SdnUrnResolver

This class resolves a SeaDataNet URN to a URL

 * **Author:** Adam Leadbetter
 * **Version:** 0.1
 * **Since:** 0.1

## private String entryID

The ID of the catalogue entry or vocabulary term the URN refers to

## private String entryVersionID

The ID of the version of the catalogue entry or vocabulary term the URN refers to

## private String nvsVocabs

The list of valid vocabularies on the NERC Vocabulary Server

## private String getEntryID()

 * **Returns:** the entryID

## private void setEntryID(String entryID)

 * **Parameters:** `entryID` — the entryID to set

## private String getEntryVersionID()

 * **Returns:** the entryVersionID

## private void setEntryVersionID(String entryVersionID)

 * **Parameters:** `entryVersionID` — the entryVersionID to set

## private static String encodeValue(String value)

Method to encode a string value using UTF-8 encoding scheme

 * **Parameters:** `value` — String to be encoded
 * **Returns:** UTF-8 encoded String

## private static boolean checkUrnPrefix(String urnPrefix)

Checks that the URN begins with the characters "SDN"

 * **Parameters:** `urnPrefix` — String of the URN value prior to the first ":"
 * **Returns:** true if the URN begins with the characters SDN, otherwise false

## private String chooseCatalogue(String catalogue) throws NotASeaDataNetURNException

Select the SeaDataNet catalogue and build the URN from the URL

 * **Parameters:** `catalogue` — String of the catalogue name to build the URL for
 * **Returns:** String of the URL the URN resolves to
 * **Exceptions:** `NotASeaDataNetURNException` — 

## private String getNVSCollections() throws IOException

Gets the current list of collections from the NERC Vocabulary Server

 * **Returns:** 
 * **Exceptions:** `IOException` — 

## private String getNvsVocabs()

Get method for the list of NERC Vocabulary Server collections

 * **Returns:** A string containing the up to date list of NVS collections

## private void setNvsVocabs(String nvsVocabs)

Set method for the list of NERC Vocabulary Server collections

 * **Parameters:** `nvsVocabs` — A string containing the list of NVS collections to set

## public String getUrlFromUrn(String urn) throws NotASeaDataNetURNException

Gets the URL for the URN supplied

 * **Parameters:** `urn` — String giving the URN to be resolved
 * **Returns:** String of the URL the URN resolves to
 * **Exceptions:** `NotASeaDataNetURNException` — 