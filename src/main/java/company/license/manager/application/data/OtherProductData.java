package company.license.manager.application.data;

public class OtherProductData
{
	private String productName;
	private boolean moduleOne;
	private boolean moduleTwo;
	private boolean moduleThree;
	private boolean moduleFour;
	private boolean moduleFive;
	private int codesNumber;
	
	public OtherProductData()
	{
		
	}
	
	public OtherProductData(String productName, boolean moduleOne, boolean moduleTwo, boolean moduleThree, boolean moduleFour, boolean moduleFive, int codesNumber)
	{
		this.productName = productName;
		this.moduleOne = moduleOne;
		this.moduleTwo = moduleTwo;
		this.moduleThree = moduleThree;
		this.moduleFour = moduleFour;
		this.moduleFive = moduleFive;
		this.codesNumber = codesNumber;
	}
	
	public String toString()
	{
		return "OtherProductData ["
		+ "productName = " + productName + ", "
		+ "moduleOne = " + moduleOne + ", "
		+ "moduleTwo = " + moduleTwo + ", "
		+ "moduleThree = " + moduleThree + ", "
		+ "moduleFour = " + moduleFour + ", "
		+ "moduleFive = " + moduleFive + ", "
		+ "codesNumber = " + codesNumber
		+ "]";
	}
	
	public String getProductName()
	{
		return productName;
	}
	
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	
	public boolean getModuleOne()
	{
		return moduleOne;
	}
	
	public void setModuleOne(boolean moduleOne)
	{
		this.moduleOne = moduleOne;
	}
	
	public boolean getModuleTwo()
	{
		return moduleTwo;
	}
	
	public void setModuleTwo(boolean moduleTwo)
	{
		this.moduleTwo = moduleTwo;
	}
	
	public boolean getModuleThree()
	{
		return moduleThree;
	}
	
	public void setModuleThree(boolean moduleThree)
	{
		this.moduleThree = moduleThree;
	}
	
	public boolean getModuleFour()
	{
		return moduleFour;
	}
	
	public void setModuleFour(boolean moduleFour)
	{
		this.moduleFour = moduleFour;
	}
	
	public boolean getModuleFive()
	{
		return moduleFive;
	}
	
	public void setModuleFive(boolean moduleFive)
	{
		this.moduleFive = moduleFive;
	}
	
	public int getCodesNumber()
	{
		return codesNumber;
	}
	
	public void setCodesNumber(int codesNumber)
	{
		this.codesNumber = codesNumber;
	}
}
