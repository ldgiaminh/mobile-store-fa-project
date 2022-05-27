package com.minhldg.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.minhldg.dto.ProductDTO;
import com.minhldg.dto.UserDTO;
import com.minhldg.model.Category;
import com.minhldg.model.Product;
import com.minhldg.model.User;
import com.minhldg.service.CategoryService;
import com.minhldg.service.CustomerUserDetailService;
import com.minhldg.service.ProductService;



@Controller
public class AdminController {
	
	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CustomerUserDetailService customerUserDetailService;
	
	
	@GetMapping("/admin")
	public String adminHome() {		
		return "adminHome";
	}

//============================ CATEGORY =============================
	
	@GetMapping("/admin/categories")
	public String getCate(Model model) {
		model.addAttribute("categories", categoryService.getAllCategory());		
		return "categories";
	}
	
	@GetMapping("/admin/categories/add")
	public String getCateAdd(Model model) {
		model.addAttribute("category", new Category());	
		return "categoriesAdd";
	}
	
	@PostMapping("/admin/categories/add")
	public String postCateAdd(@ModelAttribute("category") Category category) {
		categoryService.addCategory(category);	
		return "redirect:/admin/categories";
	}
	
	@GetMapping("/admin/categories/delete/{id}")
	public String deleteCate(@PathVariable int id) {
		categoryService.removeCategoryById(id);
		
		return "redirect:/admin/categories";
	}
	
	@GetMapping("/admin/categories/update/{id}")
	public String updateCate(@PathVariable int id, Model model) {
		Optional<Category> category = categoryService.getCategoryById(id);
		if (category.isPresent()) {
			model.addAttribute("category", category.get());
			return "categoriesAdd";
		} else {
			return "404";
		}
	}
	
//============================ PRODUCT =============================
	
	@GetMapping("/admin/products")
	public String products(Model model) {
		model.addAttribute("products", productService.getAllProduct());
		
		return "products";
	}
	
	@GetMapping("/admin/products/add")
	public String productsAddGet(Model model) {
		model.addAttribute("productDTO", new ProductDTO());
		model.addAttribute("categories", categoryService.getAllCategory());
		
		return "productsAdd";
	}
	
	@PostMapping("/admin/products/add")
	public String productAddPost(@ModelAttribute("productDTO")ProductDTO productDTO,
								@RequestParam("productImage")MultipartFile file,
								@RequestParam("imgName")String imgName) throws IOException {
		Product product = new Product();
		
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setStock(productDTO.getStock());
		product.setDescription(productDTO.getDescription());
		product.setManufacturer(productDTO.getManufacturer());
		product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
		product.setCondition(productDTO.getCondition());
		
		
		String imageUUID;
		
		if (!file.isEmpty()) {
			imageUUID = file.getOriginalFilename();
			Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
			Files.write(fileNameAndPath, file.getBytes());
		} else {
			imageUUID = imgName;
		}
		product.setImageName(imageUUID);
		
		productService.addProduct(product);		
		return "redirect:/admin/products";
	}
	
	@GetMapping("/admin/product/delete/{id}")
	public String deleteProduct(@PathVariable long id) {
		productService.removeProductById(id);
		
		return "redirect:/admin/products";
	}
		
	
	@GetMapping("/admin/product/update/{id}")
	public String updateProductGet(@PathVariable long id, Model model) {
		Product product = productService.getProductById(id).get();
		ProductDTO productDTO = new ProductDTO();
		
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setStock(product.getStock());
		productDTO.setDescription(product.getDescription());
		productDTO.setManufacturer(product.getManufacturer());
		productDTO.setCategoryId((product.getCategory()).getId());
		productDTO.setCondition(product.getCondition());
		productDTO.setImageName(product.getImageName());
		
		model.addAttribute("categories", categoryService.getAllCategory());
		model.addAttribute("productDTO", productDTO);
		
		return "productsAdd";
	}
	
//============================ USER =============================	
	
	@GetMapping("/admin/users")
	public String showUsers(Model model) {
		model.addAttribute("users", customerUserDetailService.getAllUser());	
		return "users";
	}
	
	@GetMapping("/admin/user/delete/{id}")
	public String deleteUser(@PathVariable int id) {	
		customerUserDetailService.removeUserById(id);	
		return "redirect:/admin/users";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		customerUserDetailService.save(user);
		return "redirect:/admin/users";
	}
	
	
	@GetMapping("/admin/user/update/{id}")
	public String updateUser(@PathVariable int id, Model model) {
		User user = customerUserDetailService.getUserById(id).get();
		UserDTO userDTO = new UserDTO();
		
		userDTO.setId(user.getId());
		userDTO.setEmail(user.getEmail());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		
		
		model.addAttribute("user", userDTO);	
				
		return "updateUser";
	}
	
	
}
