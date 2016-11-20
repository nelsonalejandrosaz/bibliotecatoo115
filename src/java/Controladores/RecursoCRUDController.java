/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CategoriaDAO;
import DAO.RecursoDAO;
import DAO.SubcategoriaDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Models.Categoria;
import Models.Recurso;
import Models.Subcategoria;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author nelso
 */
@Controller
public class RecursoCRUDController {

    SubcategoriaDAO subcategoriaDAO = new SubcategoriaDAO();
    CategoriaDAO categoriaDAO = new CategoriaDAO();
    RecursoDAO recursoDAO = new RecursoDAO();

    @RequestMapping(value = "recursoList.html")
    public ModelAndView RecursoList() {
        ModelAndView mav = new ModelAndView("admin/recurso/recursoList");
        String titulo = "Lista de RECURSOS";
        List<Recurso> recursos = recursoDAO.getAll();
        mav.addObject("recursos", recursos);
        mav.addObject("titulo", titulo);
        return mav;
    }
    
    @RequestMapping(value = "recursoEdit.html", method = RequestMethod.GET)
    public ModelAndView RecursoEdit(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/recurso/recursoEdit");
        String titulo = "Editar Recurso";
        int id = Integer.parseInt(request.getParameter("id"));
        Recurso recurso = recursoDAO.getByID(id);
        List<Categoria> categorias = new ArrayList<Categoria>();
        categorias = categoriaDAO.getAll();
        mav.addObject("command",recurso);
        mav.addObject("titulo",titulo);
        mav.addObject("categorias",categorias);
        return mav;
    }

}
