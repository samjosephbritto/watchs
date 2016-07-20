package com.niit.samazon.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.ModulusOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.samazon.dao.IProductDao;
import com.niit.samazon.dao.ProductDao;
import com.niit.samazon.model.Product;
import com.niit.samazon.model.Register;
import com.niit.samazon.service.IProductService;
import com.niit.samazon.service.IRegisterService;

@Controller
public class MainController {

	@Autowired
	private IRegisterService registerService;

	@Autowired
	private IProductService productService;

	@RequestMapping(value = { "/", "/index" })
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	
	@RequestMapping("allcatagories")
	public ModelAndView allcatagories() {
		return new ModelAndView("allcatagories");
	}

	@RequestMapping("productinfo")
	public ModelAndView productinfo() {
		IProductDao dao = new ProductDao();
		Gson gson = new Gson();
		//String temp = gson.toJson(dao.getAllProduct());
		String temp = gson.toJson( productService.getAllProduct());
		return new ModelAndView("productinfo", "data", temp);
	}






	@RequestMapping("register")
	public ModelAndView register() {

		return new ModelAndView("register", "command", new Register());
	}





	@RequestMapping(value="/saveregistration", method=RequestMethod.POST)
	public String saveregistration(@ModelAttribute("regvalidation") @Valid Register register, BindingResult result){
		if(result.hasErrors()){
			return  "register";
		}
		registerService.addRegistration(register);
		return "index";
		}
	
	@ModelAttribute("regvalidation")
	public Register regvalidation(){
		return new Register();
	}


	@RequestMapping("addregistration")
	public ModelAndView addregistration(@ModelAttribute("furniture") Register registerbean, BindingResult result) {
		Map<String, Object> model = new java.util.HashMap<String, Object>();
		model.put("register", registerService.getRegisteration());
		return new ModelAndView("index");
	}

















	@RequestMapping("product")
	public ModelAndView product() {
		return new ModelAndView("product", "command", new Product());
	}







	
	@RequestMapping("saveproduct")
	public ModelAndView saveproduct(@ModelAttribute("furniture") Product productbean, BindingResult result) {

		productService.addProduct(productbean);
		return new ModelAndView("redirect:/productupdate", "data",
				"Product " + productbean.getPname() + " Updated Successfully");
	} 
	

	@RequestMapping("productupdate")
	public ModelAndView productupdate(@ModelAttribute("furniture") Product productbean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("product_list", productService.getAllProduct());
		
		return new ModelAndView("productupdate", model);

	}





	@RequestMapping(value = "/deleteproduct", method = RequestMethod.GET)
	public ModelAndView deleteproduct(@ModelAttribute("furniture") Product product, BindingResult result) {
		productService.deleteProduct(product.getPid());

		/*
		 * Map<String, Object> model = new HashMap<String, Object>();
		 * model.put("product_list", productService.getAllProduct()); return new
		 * ModelAndView("productupdate", model);
		 */
		return new ModelAndView("productupdate");
	}






	@RequestMapping(value = "/editproduct", method = RequestMethod.GET)
	public ModelAndView editproduct(@ModelAttribute("furniture") Product product, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("products", productService.getProduct(product.getPid()));
		model.put("product_list", productService.getAllProduct());
		return new ModelAndView("productupdate", model);
	}




	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}




	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}



	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String loginerror(ModelMap model, Principal principal) {
		String username = principal.getName();
		model.addAttribute("message", "Sorry " + username + " You don't have privileges to view this page!!!");
		return "accessdenied";
	}









	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "logout";
	}




	@RequestMapping("viewproducts")
	public ModelAndView viewproducts(@ModelAttribute("furniture") Product productbean, BindingResult result) {
		/*
		 * Map<String, Object> model = new HashMap<String, Object>();
		 * model.put("product_list", productService.getAllProduct()); return new
		 * ModelAndView("productupdate",model);
		 */
		Gson gson = new Gson();
		String temp = gson.toJson(productService.getAllProduct());
		return new ModelAndView("viewproducts", "data", temp);
	}

	@RequestMapping(value = "homeadmin", method = RequestMethod.GET)
	public ModelAndView homeadmin(ModelMap model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("author", name);
		model.addAttribute("message", "Dear Admin Welcome To SAMAZON");
		return new ModelAndView("homeadmin");
	}





	@RequestMapping(value = "homeuser", method = RequestMethod.GET)
	public ModelAndView homeuser(ModelMap model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("author", name);
		model.addAttribute("message", "Dear User Welcome To SAMAZON");
		return new ModelAndView("homeuser");
	}







	@RequestMapping("add")
	ModelAndView storeproduct(HttpServletRequest request, @RequestParam("file") MultipartFile file,
			@ModelAttribute("ekart") @Valid Product p) {
		String fileName = null, error = "";
		if (!file.isEmpty()) {
			try {
				fileName = file.getOriginalFilename();
				byte[] bytes = file.getBytes();
				BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(
						new File("G:/SAM_DT_WORKSPACE_19july/watchs/src/main/webapp/resources/images" + fileName)));
				buffStream.write(bytes);
				buffStream.close();
				error = "You have successfully uploaded " + fileName;
			} catch (Exception e) {
				error = "You failed to upload " + fileName + ": " + e.getMessage();
			}
		} else {
			error = "Unable to upload. File is empty.";
		}
		try {
			productService.addProduct(p);
		} catch (Exception e) {
			return new ModelAndView("product", "command", new Product());
		}
		File oldName = new File("G:/SAM_DT_WORKSPACE_19july/watchs/src/main/webapp/resources/images" + fileName);
		File newName = new File("G:/SAM_DT_WORKSPACE_19july/watchs/src/main/webapp/resources/images" + p.getPid()
				+ fileName.substring(fileName.indexOf(".")));
		if (oldName.renameTo(newName)) {
			System.out.println(p.getPid());
			error = p.getPname() + " added Successfully !";
		}
		Gson gson = new Gson();
		String temp = gson.toJson(productService.getAllProduct());
		return new ModelAndView("redirect:/viewproducts", "msg", error);
	}




	@RequestMapping("addcart")
	public ModelAndView addcart(HttpServletRequest request, @RequestParam("pid") Integer pid) {
		Product p = new Product();
		p = productService.getProduct(pid);
		// Gson gson = new Gson();
		// String temp= gson.toJson(productbean);
		// return new ModelAndView( "addcart", "data", temp) ;
		return new ModelAndView("addcart", "product", p);
	}
	// public ModelAndView addcart(HttpServletRequest
	// request,@RequestParam("pid") String pid,@ModelAttribute("furniture")
	// Product productbean, BindingResult result) {







	@RequestMapping("aboutus")
	public ModelAndView aboutus() {
		return new ModelAndView("aboutus");
	}
}
