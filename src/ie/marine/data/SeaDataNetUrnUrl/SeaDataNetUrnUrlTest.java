package ie.marine.data.SeaDataNetUrnUrl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SeaDataNetUrnUrlTest {
	
	@Test
	void testGetEdmedUrl() throws NotASeaDataNetURNException {
		try {
			SeaDataNetUrnUrl sdnu = new SeaDataNetUrnUrl();
			assertEquals("https://edmed.seadatanet.org/sparql/sparql?query=&output=json", 
				sdnu.getUrlFromUrn("SDN:EDMED"));
		} catch (Exception e) {}
	}

	@Test
	void testGetEdmerpUrl() throws NotASeaDataNetURNException {
		try {
			SeaDataNetUrnUrl sdnu = new SeaDataNetUrnUrl();
			assertEquals("https://edmerp.seadatanet.org/sparql/sparql?query=&output=json", 
				sdnu.getUrlFromUrn("SDN:EDMERP"));
		} catch (Exception e) {}
	}
	
	@Test
	void testGetEdmoUrl() throws NotASeaDataNetURNException {
		try {
			SeaDataNetUrnUrl sdnu = new SeaDataNetUrnUrl();
			assertEquals("https://edmo.seadatanet.org/sparql/sparql?query=&output=json", 
				sdnu.getUrlFromUrn("SDN:EDMO"));
		} catch (Exception e) {}
	}
	
	@Test
	void testThrowsIfNotSDN() {
		try {
			SeaDataNetUrnUrl sdnu = new SeaDataNetUrnUrl();
			Exception exception = assertThrows(NotASeaDataNetURNException.class,
				() -> {sdnu.getUrlFromUrn("ABC:EDMED");});
			String expected = "not a SeaDataNet URN";
			assertTrue(exception.getMessage().contains(expected));
		} catch (Exception e) {}
	}
}
