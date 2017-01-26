package company.license.manager.application.service;

import java.util.ArrayList;
import java.util.List;

import company.license.manager.application.data.OtherProductData;
import company.license.manager.application.data.OtherProductName;
import company.license.manager.application.repository.OtherProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtherProductsService
{
	@Autowired
	public OtherProductsRepository otherProductsRepository;
	
	public List<OtherProductData> checkProductsOwnership(String userName)
	{
		List<OtherProductData> resultOtherProductDataList = new ArrayList<OtherProductData>();
		
		List<OtherProductName> otherProductNames = otherProductsRepository.checkProductsOwnership(userName);
		
		for (int i = 0; i < 5; i++)
		{
			boolean flag = false;
			
			for (OtherProductName otherProductName : otherProductNames)
			{
				if (otherProductName.getProductName().equals("Module " + (i + 1)))
				{
					flag = true;
				}
			}
			
			if (flag == false)
			{
				resultOtherProductDataList.add(new OtherProductData("Module " + (i + 1), false, false, false, false, false, 0));
			}
		}
		
		return resultOtherProductDataList;
	}
}
