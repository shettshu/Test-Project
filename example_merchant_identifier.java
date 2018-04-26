/**
 *
 * Script-Name: example_merchant_identifier
 */

import java.io.FileInputStream;
import java.io.InputStream;

import com.mastercard.api.core.ApiConfig;
import com.mastercard.api.core.exception.ApiException;
import com.mastercard.api.core.model.RequestMap;
import com.mastercard.api.core.security.oauth.OAuthAuthentication;
import com.mastercard.api.merchantidentifier.MerchantIdentifier;

public class example_merchant_identifier {

	public static void main(String[] args) throws Exception {

		String consumerKey = "RK08RYGAhgL9GHPV54UPXXopSb2A_dscv1SQkeaL80cd3f13!0789ff10a48f41dca1953cb89ea4afe70000000000000000";   // You should copy this from "My Keys" on your project page e.g. UTfbhDCSeNYvJpLL5l028sWL9it739PYh6LU5lZja15xcRpY!fd209e6c579dc9d7be52da93d35ae6b6c167c174690b72fa
		String keyAlias = "cibc";   // For production: change this to the key alias you chose when you created your production key
		String keyPassword = "cibcT2020";   // For production: change this to the key alias you chose when you created your production key
		InputStream is = new FileInputStream("C:/T2020/masterIdentifier/cibc-production.p12"); // e.g. /Users/yourname/project/sandbox.p12 | C:\Users\yourname\project\sandbox.p12
		ApiConfig.setAuthentication(new OAuthAuthentication(consumerKey, is, keyAlias, keyPassword));   // You only need to set this once
		ApiConfig.setDebug(true);   // Enable http wire logging
		ApiConfig.setSandbox(false); // For production: use ApiConfig.setSandbox(false);
		//ApiConfig.setEnvironment(Environment.SANDBOX);

		try {
			RequestMap map = new RequestMap();
			map.set("MerchantId", "BLIZZARDENT*ONLSTORE800-592-5499CA");
			map.set("Type", "ExactMatch");
			//int i;
			MerchantIdentifier response = MerchantIdentifier.query(map);
			//System.out.println("size :" +response.get("MerchantIds.ReturnedMerchants.Merchant.size()"));
			//for(int i=0; i< response.size();i++){
			System.out.println("MerchantIds.Message-->"+response.get("MerchantIds.Message")); // MerchantIds.Message-->1 merchants found.
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[0].Address.Line1-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[0].Address.Line1")); // MerchantIds.ReturnedMerchants.Merchant[0].Address.Line1-->1i1 AVIATION WAY
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[0].Address.Line2-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[0].Address.Line2")); // MerchantIds.[0]eturnedMerchants.Merchant[0].Address.Line2-->
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[0].Address.City-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[0].Address.City")); // MerchantIds.ReturnedMerchants.Merchant[0].Address.City-->WATERTOWN
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[0].Address.PostalCode-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[0].Address.PostalCode")); // MerchantIds.ReturnedMerchants.Merchant[0].Address.PostalCode-->53i94
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[0].Address.CountrySubdivision.Name-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[0].Address.CountrySubdivision.Name")); // MerchantIds.ReturnedMerchants.Merchant[0].Address.CountrySubdivision.Name-->
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[0].Address.CountrySubdivision.Code-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[0].Address.CountrySubdivision.Code")); // MerchantIds.ReturnedMerchants.Merchant[0].Address.CountrySubdivision.Code-->WI
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[0].Address.Country.Name-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[0].Address.Country.Name")); // MerchantIds.ReturnedMerchants.Merchant[0].Address.Country.Name-->UNITED STATES
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[0].Address.Country.Code-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[0].Address.Country.Code")); // MerchantIds.ReturnedMerchants.Merchant[0].Address.Country.Code-->USA
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[0].PhoneNumber-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[0].PhoneNumber")); // MerchantIds.ReturnedMerchants.Merchant[0].PhoneNumber-->92i262191i
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[0].BrandName-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[0].BrandName")); // MerchantIds.ReturnedMerchants.Merchant[0].BrandName-->
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[0].MerchantCategory-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[0].MerchantCategory")); // MerchantIds.ReturnedMerchants.Merchant[0].MerchantCategory-->35i1 - HOLIDAY INNS
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[0].MerchantDbaName-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[0].MerchantDbaName")); // MerchantIds.ReturnedMerchants.Merchant[0].MerchantDbaName-->HOLIDAY INN EXPRESS
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[0].DescriptorText-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[0].DescriptorText")); // MerchantIds.ReturnedMerchants.Merchant[0].DescriptorText-->HOLIDAYINNEXPRESSWATERTOWNWI
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[0].LegalCorporateName-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[0].LegalCorporateName")); // MerchantIds.ReturnedMerchants.Merchant[0].LegalCorporateName-->
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[0].Comment-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[0].Comment")); // MerchantIds.ReturnedMerchants.Merchant[0].Comment-->
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[0].LocationId-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[0].LocationId")); // MerchantIds.ReturnedMerchants.Merchant[0].LocationId-->49751863
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[0].SoleProprietorName-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[0].SoleProprietorName")); // MerchantIds.ReturnedMerchants.Merchant[0].SoleProprietorName-->
			
			System.out.println("MerchantIds.Message-->"+response.get("MerchantIds.Message")); // MerchantIds.Message-->1 merchants found.
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[1].Address.Line1-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[1].Address.Line1")); // MerchantIds.ReturnedMerchants.Merchant[1].Address.Line1-->1i1 AVIATION WAY
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[1].Address.Line2-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[1].Address.Line2")); // MerchantIds.[1]eturnedMerchants.Merchant[1].Address.Line2-->
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[1].Address.City-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[1].Address.City")); // MerchantIds.ReturnedMerchants.Merchant[1].Address.City-->WATERTOWN
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[1].Address.PostalCode-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[1].Address.PostalCode")); // MerchantIds.ReturnedMerchants.Merchant[1].Address.PostalCode-->53i94
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[1].Address.CountrySubdivision.Name-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[1].Address.CountrySubdivision.Name")); // MerchantIds.ReturnedMerchants.Merchant[1].Address.CountrySubdivision.Name-->
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[1].Address.CountrySubdivision.Code-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[1].Address.CountrySubdivision.Code")); // MerchantIds.ReturnedMerchants.Merchant[1].Address.CountrySubdivision.Code-->WI
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[1].Address.Country.Name-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[1].Address.Country.Name")); // MerchantIds.ReturnedMerchants.Merchant[1].Address.Country.Name-->UNITED STATES
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[1].Address.Country.Code-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[1].Address.Country.Code")); // MerchantIds.ReturnedMerchants.Merchant[1].Address.Country.Code-->USA
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[1].PhoneNumber-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[1].PhoneNumber")); // MerchantIds.ReturnedMerchants.Merchant[1].PhoneNumber-->92i262191i
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[1].BrandName-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[1].BrandName")); // MerchantIds.ReturnedMerchants.Merchant[1].BrandName-->
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[1].MerchantCategory-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[1].MerchantCategory")); // MerchantIds.ReturnedMerchants.Merchant[1].MerchantCategory-->35i1 - HOLIDAY INNS
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[1].MerchantDbaName-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[1].MerchantDbaName")); // MerchantIds.ReturnedMerchants.Merchant[1].MerchantDbaName-->HOLIDAY INN EXPRESS
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[1].DescriptorText-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[1].DescriptorText")); // MerchantIds.ReturnedMerchants.Merchant[1].DescriptorText-->HOLIDAYINNEXPRESSWATERTOWNWI
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[1].LegalCorporateName-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[1].LegalCorporateName")); // MerchantIds.ReturnedMerchants.Merchant[1].LegalCorporateName-->
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[1].Comment-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[1].Comment")); // MerchantIds.ReturnedMerchants.Merchant[1].Comment-->
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[1].LocationId-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[1].LocationId")); // MerchantIds.ReturnedMerchants.Merchant[1].LocationId-->49751863
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[1].SoleProprietorName-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[1].SoleProprietorName")); // MerchantIds.ReturnedMerchants.Merchant[1].SoleProprietorName-->
			
			
			System.out.println("MerchantIds.Message-->"+response.get("MerchantIds.Message")); // MerchantIds.Message-->1 merchants found.
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[2].Address.Line1-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[2].Address.Line1")); // MerchantIds.ReturnedMerchants.Merchant[2].Address.Line1-->1i1 AVIATION WAY
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[2].Address.Line2-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[2].Address.Line2")); // MerchantIds.[2]eturnedMerchants.Merchant[2].Address.Line2-->
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[2].Address.City-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[2].Address.City")); // MerchantIds.ReturnedMerchants.Merchant[2].Address.City-->WATERTOWN
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[2].Address.PostalCode-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[2].Address.PostalCode")); // MerchantIds.ReturnedMerchants.Merchant[2].Address.PostalCode-->53i94
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[2].Address.CountrySubdivision.Name-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[2].Address.CountrySubdivision.Name")); // MerchantIds.ReturnedMerchants.Merchant[2].Address.CountrySubdivision.Name-->
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[2].Address.CountrySubdivision.Code-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[2].Address.CountrySubdivision.Code")); // MerchantIds.ReturnedMerchants.Merchant[2].Address.CountrySubdivision.Code-->WI
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[2].Address.Country.Name-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[2].Address.Country.Name")); // MerchantIds.ReturnedMerchants.Merchant[2].Address.Country.Name-->UNITED STATES
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[2].Address.Country.Code-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[2].Address.Country.Code")); // MerchantIds.ReturnedMerchants.Merchant[2].Address.Country.Code-->USA
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[2].PhoneNumber-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[2].PhoneNumber")); // MerchantIds.ReturnedMerchants.Merchant[2].PhoneNumber-->92i262191i
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[2].BrandName-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[2].BrandName")); // MerchantIds.ReturnedMerchants.Merchant[2].BrandName-->
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[2].MerchantCategory-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[2].MerchantCategory")); // MerchantIds.ReturnedMerchants.Merchant[2].MerchantCategory-->35i1 - HOLIDAY INNS
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[2].MerchantDbaName-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[2].MerchantDbaName")); // MerchantIds.ReturnedMerchants.Merchant[2].MerchantDbaName-->HOLIDAY INN EXPRESS
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[2].DescriptorText-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[2].DescriptorText")); // MerchantIds.ReturnedMerchants.Merchant[2].DescriptorText-->HOLIDAYINNEXPRESSWATERTOWNWI
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[2].LegalCorporateName-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[2].LegalCorporateName")); // MerchantIds.ReturnedMerchants.Merchant[2].LegalCorporateName-->
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[2].Comment-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[2].Comment")); // MerchantIds.ReturnedMerchants.Merchant[2].Comment-->
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[2].LocationId-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[2].LocationId")); // MerchantIds.ReturnedMerchants.Merchant[2].LocationId-->49751863
			System.out.println("MerchantIds.ReturnedMerchants.Merchant[2].SoleProprietorName-->"+response.get("MerchantIds.ReturnedMerchants.Merchant[2].SoleProprietorName")); // MerchantIds.ReturnedMerchants.Merchant[2].SoleProprietorName-->
			
			//}

			
		} catch (ApiException e) {
			System.err.println("HttpStatus: "+e.getHttpStatus());
			System.err.println("Message: "+e.getMessage());
			System.err.println("ReasonCode: "+e.getReasonCode());
			System.err.println("Source: "+e.getSource());
		}
	}
}