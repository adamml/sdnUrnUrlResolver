package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ie.marine.data.SeaDataNetUrnUrl.NotASeaDataNetURNException;
import ie.marine.data.SeaDataNetUrnUrl.SeaDataNetUrnUrl;

class SeaDataNetUrnUrlTest {
	
	@Test
	void testGetEdmedUrl() throws NotASeaDataNetURNException {
		try {
			SeaDataNetUrnUrl sdnu = new SeaDataNetUrnUrl();
			assertEquals("https://edmed.seadatanet.org/sparql/sparql?query=PREFIX+skos%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2004%2F02%2Fskos%2Fcore%23%3E+PREFIX+rdf%3A%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E+&output=json", 
				sdnu.getUrlFromUrn("SDN:EDMED"));
		} catch (Exception e) {}
	}

	@Test
	void testGetEdmerpRecordUrl() throws NotASeaDataNetURNException {
		try {
			SeaDataNetUrnUrl sdnu = new SeaDataNetUrnUrl();
			assertEquals("https://edmerp.seadatanet.org/sparql/sparql?query=PREFIX+skos%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2004%2F02%2Fskos%2Fcore%23%3E+PREFIX+rdf%3A%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E+SELECT+%3Fs+%3Fp+%3Fo+where+%7BBIND%28%3Chttp%3A%2F%2Fedmerp.seadatanet.org%2Freport%2F11730%3E+AS+%3Fs%29+%3Fs+%3Fp+%3Fo%7D&output=json", 
				sdnu.getUrlFromUrn("SDN:EDMERP::11730"));
		} catch (Exception e) {}
	}
	
	@Test
	void testGetAllEdmerps() throws NotASeaDataNetURNException {
		try {
			SeaDataNetUrnUrl sdnu = new SeaDataNetUrnUrl();
			assertEquals("https://edmerp.seadatanet.org/sparql/sparql?query=PREFIX+skos%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2004%2F02%2Fskos%2Fcore%23%3E+PREFIX+rdf%3A%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E+SELECT+%3Fs+%3Fo+WHERE+%7B%3Fs+rdf%3Atype+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2FResearchProject%3E.+%3Fs+%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23label%3E+%3Fo%7D&output=json", 
				sdnu.getUrlFromUrn("SDN:EDMERP"));
		} catch (Exception e) {}
	}
	
	@Test
	void testGetEdmoRecord() throws NotASeaDataNetURNException {
		try {
			SeaDataNetUrnUrl sdnu = new SeaDataNetUrnUrl();
			assertEquals("https://edmo.seadatanet.org/sparql/sparql?query=PREFIX+skos%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2004%2F02%2Fskos%2Fcore%23%3E+PREFIX+rdf%3A%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E+SELECT+%3Fs+%3Fo+%3Fp+WHERE+%7B%7BBIND+%28%3Chttp%3A%2F%2Fedmo.seadatanet.org%2F308%3E+AS+%3Fs%29%3Fs+%3Fo+%3Fp%7D+UNION+%7BBIND+%28%3Chttp%3A%2F%2Fedmo.seadatanet.org%2F308%3E+as+%3Forg%29+%3Forg+%3Chttp%3A%2F%2Fwww.w3.org%2Fns%2Forg%23hasSite%3E+%3Fsite.+%3Fsite+%3Chttp%3A%2F%2Fwww.w3.org%2Fns%2Forg%23siteAddress%3E+%3Fs.+%3Fs+%3Fo+%3Fp%7D+UNION+%7B+BIND+%28%3Chttp%3A%2F%2Fedmo.seadatanet.org%2F308%3E+as+%3Forg%29+%3Forg+%3Chttp%3A%2F%2Fwww.w3.org%2Fns%2Forg%23hasSite%3E+%3Fsite.+%3Fsite+%3Chttp%3A%2F%2Fwww.w3.org%2Fns%2Forg%23siteAddress%3E+%3Fa.+%3Fa+%3Chttp%3A%2F%2Fwww.w3.org%2F2006%2Fvcard%2Fns%23hasGeo%3E+%3Fs.+%3Fs+%3Fo+%3Fp%7D+UNION+%7B+BIND+%28%3Chttp%3A%2F%2Fedmo.seadatanet.org%2F308%3E+as+%3Forg%29+%3Forg+%3Chttp%3A%2F%2Fwww.w3.org%2Fns%2Forg%23hasSite%3E+%3Fsite.+%3Fsite+%3Chttp%3A%2F%2Fwww.w3.org%2Fns%2Forg%23siteAddress%3E+%3Fa.+%3Fa+%3Chttp%3A%2F%2Fwww.w3.org%2F2006%2Fvcard%2Fns%23hasTelephone%3E+%3Fs.+%3Fs+%3Fo+%3Fp+%7D%7D&output=json", 
				sdnu.getUrlFromUrn("SDN:EDMO::308"));
		} catch (Exception e) {}
	}
	
	@Test
	void testGetAllEdmos() throws NotASeaDataNetURNException {
		try {
			SeaDataNetUrnUrl sdnu = new SeaDataNetUrnUrl();
			assertEquals("https://edmo.seadatanet.org/sparql/sparql?query=PREFIX+skos%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2004%2F02%2Fskos%2Fcore%23%3E+PREFIX+rdf%3A%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E+SELECT+DISTINCT+%3Fs+%3Fp+WHERE+%7B%3Fs+rdf%3Atype+%3Chttp%3A%2F%2Fwww.w3.org%2Fns%2Forg%23Organization%3E.+%3Fs+skos%3AprefLabel+%3Fp%7D+ORDER+By+%3Fp&output=json", 
				sdnu.getUrlFromUrn("SDN:EDMO"));
		} catch (Exception e) {}
	}
	
	@Test
	void testGetAllSDNParamterDiscovery() throws NotASeaDataNetURNException {
		try {
			SeaDataNetUrnUrl sdnu = new SeaDataNetUrnUrl();
			assertEquals("http://vocab.nerc.ac.uk/sparql/sparql?query=PREFIX+skos%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2004%2F02%2Fskos%2Fcore%23%3E+PREFIX+rdf%3A%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E+SELECT+DISTINCT+%3Fs+%3Fo+%3Fp+WHERE+%7B%7BBIND+%28%3Chttp%3A%2F%2Fvocab.nerc.ac.uk%2Fcollection%2FP02%2Fcurrent%2F%3E+as+%3Fs%29+%3Fs+rdf%3Atype+skos%3ACollection.+%3Fs++%3Fo+%3Fp%7D+UNION+%7BBIND+%28%3Chttp%3A%2F%2Fvocab.nerc.ac.uk%2Fcollection%2FP02%2Fcurrent%2F%3E+as+%3Fa%29+BIND+%28skos%3AprefLabel+as+%3Fo%29+%3Fa+skos%3Amember+%3Fs.%3Fs+%3Fo+%3Fp%7D%7D&output=json", 
				sdnu.getUrlFromUrn("SDN:P02"));
		} catch (Exception e) {}
	}
	
	@Test
	void testGetAllSDNParamterDiscoveryAllTheColons() throws NotASeaDataNetURNException {
		try {
			SeaDataNetUrnUrl sdnu = new SeaDataNetUrnUrl();
			assertEquals("http://vocab.nerc.ac.uk/sparql/sparql?query=PREFIX+skos%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2004%2F02%2Fskos%2Fcore%23%3E+PREFIX+rdf%3A%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E+SELECT+DISTINCT+%3Fs+%3Fo+%3Fp+WHERE+%7B%7BBIND+%28%3Chttp%3A%2F%2Fvocab.nerc.ac.uk%2Fcollection%2FP02%2Fcurrent%2F%3E+as+%3Fs%29+%3Fs+rdf%3Atype+skos%3ACollection.+%3Fs++%3Fo+%3Fp%7D+UNION+%7BBIND+%28%3Chttp%3A%2F%2Fvocab.nerc.ac.uk%2Fcollection%2FP02%2Fcurrent%2F%3E+as+%3Fa%29+BIND+%28skos%3AprefLabel+as+%3Fo%29+%3Fa+skos%3Amember+%3Fs.%3Fs+%3Fo+%3Fp%7D%7D&output=json", 
				sdnu.getUrlFromUrn("SDN:P02::"));
		} catch (Exception e) {}
	}
	
	@Test
	void testGetP02PSAL() throws NotASeaDataNetURNException {
		try {
			SeaDataNetUrnUrl sdnu = new SeaDataNetUrnUrl();
			assertEquals("http://vocab.nerc.ac.uk/sparql/sparql?query=PREFIX+skos%3A%3Chttp%3A%2F%2Fwww.w3.org%2F2004%2F02%2Fskos%2Fcore%23%3E+PREFIX+rdf%3A%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E+SELECT+%3Fs+%3Fo+%3Fp+WHERE+%7BBIND+%28%3Chttp%3A%2F%2Fvocab.nerc.ac.uk%2Fcollection%2FP02%2Fcurrent%2FPSAL%2F%3E+as+%3Fs%29+%3Fs+rdf%3Atype+skos%3AConcept.+%3Fs+%3Fo+%3Fp%7D&output=json", 
				sdnu.getUrlFromUrn("SDN:P02::PSAL"));
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
	
	@Test
	void testThrowsIfShortUrn() {
		try {
			SeaDataNetUrnUrl sdnu = new SeaDataNetUrnUrl();
			Exception exception = assertThrows(NotASeaDataNetURNException.class,
				() -> {sdnu.getUrlFromUrn("SDN:");});
			String expected = "not a SeaDataNet URN";
			assertTrue(exception.getMessage().contains(expected));
		} catch (Exception e) {}
	}
	
	@Test
	void testThrowsIfLongUrn() {
		try {
			SeaDataNetUrnUrl sdnu = new SeaDataNetUrnUrl();
			Exception exception = assertThrows(NotASeaDataNetURNException.class,
				() -> {sdnu.getUrlFromUrn("SDN:P02:1:PSAL:BLAH");});
			String expected = "not a SeaDataNet URN";
			assertTrue(exception.getMessage().contains(expected));
		} catch (Exception e) {}
	}
}
