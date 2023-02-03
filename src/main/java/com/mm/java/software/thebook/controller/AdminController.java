/*
package com.mm.java.software.thebook.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Link;
import com.example.demo.service.CategoriaService;
import com.example.demo.service.LinkService;

@Controller
@Transactional
public class AdminController {

    @Autowired
    private LinkService linkService;

    @Autowired
    private CategoriaService categoriaService;

    // Visualizza

    @GetMapping(value = { "/admin", "/admin/index" })
    public String index(ModelMap map, HttpSession session) {
        map.addAttribute("NomeSito", "Linkable");
        map.addAttribute("link", linkService.getAllLinks());

        return "admin/index";
    }

    // Insert

    @RequestMapping("/admin/insert")
    public String inserisciLink(Link link, Model model) {
        model.addAttribute("NomeSito", "The blog name!");
        model.addAttribute("link", this.linkService.getAllLinks());
        model.addAttribute("categorie", this.categoriaService.getAllCategorie());
        return "admin/insert";
    }

    @RequestMapping(value = "/admin/insertLink", method = RequestMethod.POST)
    public String insertLink(@Valid @ModelAttribute("link") Link link, BindingResult bindingResult, Model model,
                             @RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("link", link);
            model.addAttribute("categorie", this.categoriaService.getAllCategorie());
            return "/admin/insert";
        }

        link.setImmagine(file.getOriginalFilename());
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("C:\\Users\\Utente\\Desktop\\link\\demo\\src\\main\\resources\\static\\images\\" + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }


        linkService.insertLink(link);

        return "redirect:/admin/index";
    }

    // Update

    @RequestMapping("/admin/edit/{idlink}")
    public String editLink(@PathVariable("idlink") int idlink, Model model) {
        model.addAttribute("NomeSito", "The blog name!");
        model.addAttribute("link", this.linkService.getLinkByidlink(idlink));

        model.addAttribute("categorie", this.categoriaService.getAllCategorie());
        return "admin/edit";
    }

    // vincolo tra modello e visualizzazione (htlm deve avete un th:objeckt)
    @RequestMapping(value = "/admin/updateLink", method = RequestMethod.POST)
    public ModelAndView updateBook(@ModelAttribute(value = "link") Link link,@RequestParam(value = "file", required = false) MultipartFile file) {
        linkService.updateLink(link);
        link.setImmagine(file.getOriginalFilename());
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("C:\\Users\\Utente\\Desktop\\link\\demo\\src\\main\\resources\\static\\images\\" + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ModelAndView("redirect:/admin/index");
    }

    // Delete
//
    @GetMapping("admin/delete/{idlink}")
    public String deleteLink(@PathVariable("idlink") int idlink, Model model) {
        model.addAttribute("link", this.linkService.getLinkByidlink(idlink));

        model.addAttribute("categorie", this.categoriaService.getAllCategorie());

        return "admin/delete";

    }

    @RequestMapping(value = "/admin/deleteLink", method = RequestMethod.POST)
    public ModelAndView deleteLink(@ModelAttribute(value = "link") Link link) {
        link.setIdcategoria(1);
        linkService.deleteLink(link);
        return new ModelAndView("redirect:/admin/index");
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

}
*/
