/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import org.springframework.web.servlet.ModelAndView;
import DAO.CategoriaDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Models.Categoria;
import java.math.BigDecimal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nelso
 */

@Controller
public class CategoriaCRUDController {

    CategoriaDAO categoriaDAO = new CategoriaDAO();

    @RequestMapping(value = "/categoriaList.html")
    public ModelAndView CategoriaList() {
        ModelAndView mav = new ModelAndView("admin/categoria/categoriaList");
        String titulo = "Lista de categorias";
        List<Categoria> categorias = categoriaDAO.getAll();
        mav.addObject("categorias", categorias);
        mav.addObject("titulo", titulo);
        return mav;
    }
    
    @RequestMapping(value = "categoriaEdit.html",method = RequestMethod.GET)
    public ModelAndView CategoriaEdit(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/categoria/categoriaEdit");
        String titulo = "Editar Categoria";
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        Categoria categoria = categoriaDAO.getbyID(id);
        mav.addObject("command",categoria);
        mav.addObject("titulo", titulo);
        return mav;
    }
    
    @RequestMapping(value = "categoriaEdit.html",method = RequestMethod.POST)
    public void CategoriaEdit(HttpServletRequest request, HttpServletResponse response) {
        Categoria categoria = new Categoria();
        int id = Integer.parseInt(request.getParameter("id"));
        categoria.setIdcategoria(BigDecimal.valueOf(id));
        categoria.setNombrecategoria(request.getParameter("nombrecategoria"));
        categoriaDAO.update(categoria);
        try {
            response.sendRedirect("categoriaList.html");
        } catch (IOException ex) {
            Logger.getLogger(CategoriaCRUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value = "categoriaDelete.html",method = RequestMethod.GET)
    public ModelAndView CategoriaDelete(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/categoria/categoriaDelete");
        String titulo = "Seguro desea eliminar";
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        Categoria categoria = categoriaDAO.getbyID(id);
        mav.addObject("titulo",titulo);
        mav.addObject("command",categoria);
        return mav;
    }
    
    @RequestMapping(value = "categoriaDelete.html",method = RequestMethod.POST)
    public void CategoriaDelete(HttpServletRequest request, HttpServletResponse response) {
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        categoriaDAO.delete(id);
        try {
            response.sendRedirect("categoriaList.html");
        } catch (IOException ex) {
            Logger.getLogger(CategoriaCRUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value = "categoriaAdd.html", method = RequestMethod.GET)
    public ModelAndView CategoriaAdd(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/categoria/categoriaAdd");
        String titulo = "Agregar nueva categoria";
        Categoria categoria = new Categoria();
        mav.addObject("command",categoria);
        mav.addObject("titulo", titulo);
        return mav;
    }
    
    @RequestMapping(value = "categoriaAdd.html", method = RequestMethod.POST)
    public void CategoriaAdd(HttpServletRequest request, HttpServletResponse response) {
        Categoria categoria = new Categoria();
        categoria.setNombrecategoria(request.getParameter("nombrecategoria"));
        categoriaDAO.add(categoria);
        try {
            response.sendRedirect("categoriaList.html");
        } catch (IOException ex) {
            Logger.getLogger(CategoriaCRUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
