package company.license.manager.application.controller;

import java.security.Principal;

import javax.validation.Valid;

import company.license.manager.application.data.CompanyData;
import company.license.manager.application.data.Product;
import company.license.manager.application.service.CompanyService;
import company.license.manager.application.data.OtherProductData;
import company.license.manager.application.service.ModuleService;
import company.license.manager.application.service.OtherProductsService;
import company.license.manager.application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasicController
{
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private OtherProductsService otherProductsService;

	@Autowired
	private ProductService productService;

	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping(value = { "/", "/home**"}, method = RequestMethod.GET)
	public String home(Model model)
	{
		return "home";
	}
	
	@RequestMapping(value = { "/company**" }, method = RequestMethod.GET)
	public String companyGet(Model model, Principal principal)
	{
		model.addAttribute("companyData", companyService.getCompanyData(principal.getName()));
		return "company";
	}
	
	@RequestMapping(value = { "/company**" }, method = RequestMethod.POST)
	public String companyPost(@Valid CompanyData companyData, Errors errors, Model model, Principal principal)
	{
		if (errors.hasErrors())
		{
			return "company";
		}
		
		companyService.updateCompanyData(companyData, principal.getName());
		return "redirect:/home?changesapplied";
	}

	@RequestMapping(value = { "/ownedProducts**" }, method = RequestMethod.POST)
	public String ownedProductsPostStations(@Valid int productID, Errors errors, Model model, Principal principal)
	{
		if (errors.hasErrors())
		{
			return "ownedProducts";
		}
		productService.updateStations(principal.getName());
		return "redirect:/home?changesapplied";
	}

	@RequestMapping(value = {"/ownedproducts**"}, method = RequestMethod.GET)
	public String ownedProductsGet(Model model, Principal principal){

		model.addAttribute("ownedProducts", productService.checkProductsOwnership(principal.getName()));
		//model.addAttribute("modules", moduleService.getModules(principal.getName()));
		return "ownedProducts";
	}
	
	@RequestMapping(value = { "/otherproducts**" }, method = RequestMethod.GET)
	public String otherProductsGet(Model model, Principal principal)
	{
		model.addAttribute("otherProducts", otherProductsService.checkProductsOwnership(principal.getName()));
		model.addAttribute("newProduct", new OtherProductData());
		return "otherProducts";
	}
	@RequestMapping(value = { "/avalibleProducts**" }, method = RequestMethod.GET)
	public String otherGet(Model model)
	{
		model.addAttribute("avalibleProducts", productService.generate());
		return "avalibleProducts";
	}
	@RequestMapping(value = { "/avalibleProducts**" }, method = RequestMethod.POST)
	public String otherPost(@Valid Product product, Errors errors, Model model, Principal principal)
	{
		if (errors.hasErrors())
		{
			return "company";
		}

		productService.updateProductData(product, principal.getName());
		return "redirect:/home?changesapplied";
	}


	@RequestMapping(value = { "/login**" }, method = RequestMethod.GET)
	public String login(Model model)
	{
		return "login";
	}
}
