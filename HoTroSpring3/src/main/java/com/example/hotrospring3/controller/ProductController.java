package com.example.hotrospring3.controller;

import com.example.hotrospring3.model.Product;
import com.example.hotrospring3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public String showHomePage(Model model) {
        List<Product> lists = productService.getAllProduct();

        model.addAttribute("listProduct", lists);
        return "/index";
    }

    @GetMapping("/add-product")
    public String showProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "/create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        productService.createProduct(product);
        redirectAttributes.addFlashAttribute("message", "Create successfully");
        return "redirect:/products";
    }
}