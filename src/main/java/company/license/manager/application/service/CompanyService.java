package company.license.manager.application.service;

import company.license.manager.application.data.CompanyData;
import company.license.manager.application.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService
{
	@Autowired
	private CompanyRepository companyRepository;
	
	public CompanyData getCompanyData(String userName)
	{
		return companyRepository.getCompanyData(userName);
	}
	
	public void updateCompanyData(CompanyData companyData, String userName)
	{
		companyRepository.updateCompanyData(companyData, userName);
	}
}
