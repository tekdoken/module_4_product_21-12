package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import product.model.Category;
import product.model.Product;
import product.service.ICategoryService;
import product.service.IProductService;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    IProductService iProductService;
    @Autowired
    ICategoryService iCategoryService;

    @ModelAttribute("categorys")
    public Iterable<Category> categories() {
        return iCategoryService.findAll();
    }

    @GetMapping("create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("create")
    public String create(Product product) {
        iProductService.save(product);
        return "redirect:/";
    }

    @GetMapping("")
    public String show(@PageableDefault(value = 3) Pageable pageable, Model model, String search) {
        pageable= PageRequest.of(0, 3,  Sort.by("price").descending());
        Page<Product> productPage;
        if (search == null) {
            productPage = iProductService.findAll(pageable);
        } else {
            productPage = iProductService.findByNameContaining(pageable, search);
            model.addAttribute("back", "back");
            model.addAttribute("search",search);
        }
        model.addAttribute("products", productPage);
        return "list";
    }
    @GetMapping("sort/{idc}")
    public String sort(@PageableDefault(value = 3) Pageable pageable, Model model, String search,@PathVariable Integer idc) {
        Page<Product> productPage;
        if (search == null) {
            if (idc==1  ) {
                pageable= PageRequest.of(0, 3,  Sort.by("price").descending());
                productPage = iProductService.findAll(pageable);
                model.addAttribute("idc",idc);
            } else {
                pageable= PageRequest.of(0, 3,  Sort.by("price").ascending());
                productPage = iProductService.findAll(pageable);
                model.addAttribute("idc",idc);
            }
        } else {
            productPage = iProductService.findByNameContaining(pageable, search);
            model.addAttribute("back", "back");
            model.addAttribute("search",search);
            model.addAttribute("idc",idc);
        }
        model.addAttribute("products", productPage);
        return "list";
    }

    @GetMapping("edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Optional<Product> productOptional = iProductService.findById(id);
        modelAndView.addObject("product", productOptional);
        return modelAndView;
    }
    @PostMapping("edit")
    public String edit(Product product){
        iProductService.save(product);
        return "redirect:/";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        iProductService.remote(id);
        return "redirect:/";
    }
}
