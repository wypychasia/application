package company.license.manager.application.data;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CompanyData
{
	@NotNull
	@Size(min = 1, max = 30, message = "Błędna nazwa firmy - od 1 do 30 znaków.")
	private String companyName;
	@NotNull
	@Size(min = 10, max = 13, message = "Błędny format NIP '1111111111' lub '111-11-11-111'")
	private String NIPNumber;
	@NotNull
	private boolean VATTaxPayer;
	@NotNull
	@Size(min = 5, max = 40, message = "Błędna adres mail - nazwa@nazwa - do 40 znaków")
	private String emailAddress;
	@NotNull
	@Size(min = 1, max = 30, message = "Błędna nazwa miasta - od 1 do 30 znaków.")
	private String addressCity;
	@NotNull
	@Size(min = 5, max = 6, message = "Błędny kod pocztkowy '11-111' lub '11111'")
	private String addressPostalCode;
	@NotNull
	@Size(min = 1, max = 30, message = "Błędna nazwa ulicy - od 1 do 30 znaków.")
	private String addressStreet;
	@NotNull
	@Size(min = 1, max = 10, message = "Błędna numer domu - od 1 do 10 znaków.")
	private String addressHouseNumber;
	@NotNull
	@Size(min = 9, max = 15, message = "Błędna numer telefonu")
	private String phoneNumber;
	@Size(max = 50)
	private String comments;
	@NotNull
	@Size(min = 1, max = 30, message = "Błędna numer licencji - od 1 do 30 znaków.")
	private String licenseNumber;
	
	public CompanyData()
	{
		
	}
	
	public CompanyData(String companyName, String NIPNumber, boolean VATTaxPayer, String emailAddress, String addressCity, String addressPostalCode,
			String addressStreet, String addressHouseNumber, String phoneNumber, String comments, String licenseNumber)
	{
		this.companyName = companyName;
		this.NIPNumber = NIPNumber;
		this.VATTaxPayer = VATTaxPayer;
		this.emailAddress = emailAddress;
		this.addressCity = addressCity;
		this.addressPostalCode = addressPostalCode;
		this.addressStreet = addressStreet;
		this.addressHouseNumber = addressHouseNumber;
		this.phoneNumber = phoneNumber;
		this.comments = comments;
		this.licenseNumber = licenseNumber;
	}
	
	public String toString()
	{
		return "CompanyData["
		+ "companyName = " + companyName + ", "
		+ "NIPNumber = " + NIPNumber + ", "
		+ "VATTaxPayer = " + VATTaxPayer + ", "
		+ "emailAddress = " + emailAddress + ", "
		+ "addressCity = " + addressCity + ", "
		+ "addressPostalCode = " + addressPostalCode + ", "
		+ "addressStreet = " + addressStreet + ", "
		+ "addressHouseNumber = " + addressHouseNumber + ", "
		+ "phoneNumber = " + phoneNumber + ", "
		+ "comments = " + comments + ", "
		+ "licenseNumber = " + licenseNumber
		+ "]";
	}
	
	public String getCompanyName()
	{
		return companyName;
	}
	
	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}
	
	public String getNIPNumber()
	{
		return NIPNumber;
	}
	
	public void setNIPNumber(String NIPNumber)
	{
		this.NIPNumber = NIPNumber;
	}
	
	public boolean getVATTaxPayer()
	{
		return VATTaxPayer;
	}
	
	public void setVATTaxPayer(boolean VATTaxPayer)
	{
		this.VATTaxPayer = VATTaxPayer;
	}
	
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}
	
	public String getAddressCity()
	{
		return addressCity;
	}
	
	public void setAddressCity(String addressCity)
	{
		this.addressCity = addressCity;
	}
	
	public String getAddressPostalCode()
	{
		return addressPostalCode;
	}
	
	public void setAddressPostalCode(String addressPostalCode)
	{
		this.addressPostalCode = addressPostalCode;
	}
	
	public String getAddressStreet()
	{
		return addressStreet;
	}
	
	public void setAddressStreet(String addressStreet)
	{
		this.addressStreet = addressStreet;
	}
	
	public String getAddressHouseNumber()
	{
		return addressHouseNumber;
	}
	
	public void setAddressHouseNumber(String addressHouseNumber)
	{
		this.addressHouseNumber = addressHouseNumber;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public String getComments()
	{
		return comments;
	}
	
	public void setComments(String comments)
	{
		this.comments = comments;
	}
	
	public String getLicenseNumber()
	{
		return licenseNumber;
	}
	
	public void setLicenseNumber(String licenseNumber)
	{
		this.licenseNumber = licenseNumber;
	}
}
