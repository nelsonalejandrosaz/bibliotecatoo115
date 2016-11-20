/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CategoriaDAO;
import DAO.SubcategoriaDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Models.Categoria;
import Models.Subcategoria;
import java.math.BigDecimal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author nelso
 */

@Controller

public class SubcategoriaCRUDController {
    
    SubcategoriaDAO subcategoriaDAO = new SubcategoriaDAO();
    CategoriaDAO categoriaDAO = new CategoriaDAO();
    
    @RequestMapping(value = "subcategoriaList.html")
    public ModelAndView CategoriaList() {
        ModelAndView mav = new ModelAndView("admin/subcategoria/subcategoriaList");
        String titulo = "Lista de subcategorias";
        List<Subcategoria> subcategorias = subcategoriaDAO.getAll();
        mav.addObject("subcategorias", subcategorias);
        mav.addObject("titulo", titulo);
        return mav;
    }
    
    @RequestMapping(value = "subcategoriaEdit.html",method = RequestMethod.GET)
    public ModelAndView SubcategoriaEdit(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/subcategoria/subcategoriaEdit");
        String titulo = "Editar Subcategoria";
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        Subcategoria subcategoria = subcategoriaDAO.getbyID(id);
        List<Categoria> categorias = categoriaDAO.getAll();
        mav.addObject("command",subcategoria);
        mav.addObject("categorias",categorias);
        mav.addObject("titulo",titulo);
        return mav;
    }
    
    @RequestMapping(value = "subcategoriaEdit.html",method = RequestMethod.POST)
    public void SubcategoriaEdit(HttpServletRequest request, HttpServletResponse response){
        String idCategoriaString = request.getParameter("categoria");
        Categoria categoria = categoriaDAO.getbyID(Integer.parseInt(idCategoriaString));
        Subcategoria subcategoria = subcategoriaDAO.getbyID(Integer.parseInt(request.getParameter("id")));
//        SubcategoriaId id = new SubcategoriaId(Integer.parseInt(request.getParameter("id")), Integer.parseInt(idCategoriaString));
        subcategoria.setNombresubcategoria(request.getParameter("nombresubcategoria"));
        subcategoria.setCategoria(categoria);
        subcategoriaDAO.update(subcategoria);
        try {
            response.sendRedirect("subcategoriaList.html");
        } catch (IOException ex) {
            Logger.getLogger(SubcategoriaCRUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value = "subcategoriaAdd.html", method = RequestMethod.GET)
    public ModelAndView SubcategoriaAdd(){
        ModelAndView mav = new ModelAndView("admin/subcategoria/subcategoriaAdd");
        String titulo = "Agregar nueva subcategoria";
        Subcategoria subcategoria = new Subcategoria();
        List<Categoria> categorias = categoriaDAO.getAll();
        mav.addObject("command",subcategoria);
        mav.addObject("categorias",categorias);
        mav.addObject("titulo", titulo);
        return mav;
    }
    
    @RequestMapping(value = "subcategoriaAdd.html", method = RequestMethod.POST)
    public void SubcategoriaAdd(HttpServletRequest request, HttpServletResponse response) {
        Subcategoria subcategoria = new Subcategoria();
        String idCategoriaString = request.getParameter("categoria");
        Categoria categoria = categoriaDAO.getbyID(Integer.parseInt(idCategoriaString));
        subcategoria.setNombresubcategoria(request.getParameter("nombresubcategoria"));
        subcategoria.setCategoria(categoria);
        subcategoriaDAO.add(subcategoria);
        try {
            response.sendRedirect("subcategoriaList.html");
        } catch (IOException ex) {
            Logger.getLogger(CategoriaCRUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value = "subcategoriaDelete.html",method = RequestMethod.GET)
    public ModelAndView SubcategoriaDelete(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/subcategoria/subcategoriaDelete");
        String titulo = "Seguro desea eliminar";
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        Subcategoria subcategoria = subcategoriaDAO.getbyID(id);
        mav.addObject("titulo",titulo);
        mav.addObject("command",subcategoria);
        return mav;
    }
    
    @RequestMapping(value = "subcategoriaDelete.html",method = RequestMethod.POST)
    public void SubcategoriaDelete(HttpServletRequest request, HttpServletResponse response) {
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        subcategoriaDAO.delete(id);
        try {
            response.sendRedirect("subcategoriaList.html");
        } catch (IOException ex) {
            Logger.getLogger(CategoriaCRUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    @RequestMapping(value = "subcategoriaByCategoria.html")
    public ModelAndView SubcategoriaByCategoria(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/subcategoria/subcategoriaByCategoria");
        List<Subcategoria> subcategorias = subcategoriaDAO.getByCategoria(Integer.parseInt(request.getParameter("id")));
        mav.addObject("subcategorias",subcategorias);
        return mav;
    }
}
