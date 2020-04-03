package ie.marine.data.seaDataNetUrnUrl;

public class run {
	public static void main(String[] args) {
		seaDataNetUrnUrl sdnu = new seaDataNetUrnUrl();
		System.out.println(sdnu.getUrlFromUrn("SDN:EDMED"));
	}
}
