/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.BibliotecaDAO;
import DAO.CategoriaDAO;
import DAO.RecursoDAO;
import DAO.SubcategoriaDAO;
import Models.Biblioteca;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Models.Categoria;
import Models.Recurso;
import Models.Subcategoria;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
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
    BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();

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
        mav.addObject("command", recurso);
        mav.addObject("titulo", titulo);
        mav.addObject("categorias", categorias);
        return mav;
    }

    @RequestMapping(value = "recursoEdit.html", method = RequestMethod.POST)
    public void RecursoEdit(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        int idSubcategoria = Integer.parseInt(request.getParameter("subcategoria"));
        Subcategoria subcategoria = subcategoriaDAO.getbyID(idSubcategoria);
        Recurso recurso = recursoDAO.getByID(Integer.parseInt(request.getParameter("id")));
        recurso.setNombrerecurso(request.getParameter("nombrerecurso"));
        recurso.setSubcategoria(subcategoria);
        recurso.setDescripcion(request.getParameter("descripcion"));
        recurso.setSinopsis(request.getParameter("sinopsis"));
        recurso.setAutores(request.getParameter("autores"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaString = request.getParameter("fecha");
        Date fecha;
        try {
            fecha = sdf.parse(fechaString);
            recurso.setFecha(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(RecursoCRUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
        recurso.setVolumen(BigDecimal.valueOf(Integer.parseInt(request.getParameter("volumen"))));
        recurso.setUnidades(BigDecimal.valueOf(Integer.parseInt(request.getParameter("unidades"))));
        recurso.setEditorial(request.getParameter("editorial"));
        recurso.setImagen(request.getParameter("imagen"));
        recurso.setFormato(request.getParameter("formato"));
        recurso.setPrestamointerno(BigDecimal.valueOf(Integer.parseInt(request.getParameter("prestamointerno"))));
        recursoDAO.update(recurso);
        try {
            response.sendRedirect("recursoList.html");
        } catch (IOException ex) {
            Logger.getLogger(RecursoCRUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value = "recursoAdd.html", method = RequestMethod.GET)
    public ModelAndView RecursoAdd(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/recurso/recursoAdd");
        String titulo = "Agregar Recurso";
        Recurso recurso = new Recurso();
        List<Categoria> categorias = new ArrayList<Categoria>();
        categorias = categoriaDAO.getAll();
        mav.addObject("command", recurso);
        mav.addObject("titulo", titulo);
        mav.addObject("categorias", categorias);
        return mav;
    }

    @RequestMapping(value = "recursoAdd.html", method = RequestMethod.POST)
    public void RecursoAdd(HttpServletRequest request, HttpServletResponse response) {
        int idSubcategoria = Integer.parseInt(request.getParameter("subcategoria"));
        Subcategoria subcategoria = subcategoriaDAO.getbyID(idSubcategoria);
        Recurso recurso = new Recurso();
        recurso.setNombrerecurso(request.getParameter("nombrerecurso"));
        recurso.setSubcategoria(subcategoria);
        recurso.setDescripcion(request.getParameter("descripcion"));
        recurso.setSinopsis(request.getParameter("sinopsis"));
        recurso.setAutores(request.getParameter("autores"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaString = request.getParameter("fecha");
        Date fecha;
        try {
            fecha = sdf.parse(fechaString);
            recurso.setFecha(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(RecursoCRUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
        recurso.setVolumen(BigDecimal.valueOf(Integer.parseInt(request.getParameter("volumen"))));
        recurso.setUnidades(BigDecimal.valueOf(Integer.parseInt(request.getParameter("unidades"))));
        recurso.setEditorial(request.getParameter("editorial"));
        recurso.setImagen(request.getParameter("imagen"));
        recurso.setFormato(request.getParameter("formato"));
        recurso.setPrestamointerno(BigDecimal.valueOf(Integer.parseInt(request.getParameter("prestamointerno"))));
        Biblioteca biblioteca = bibliotecaDAO.getbyID(1);
        recurso.setBiblioteca(biblioteca);
        recursoDAO.add(recurso);
        try {
            response.sendRedirect("recursoList.html");
        } catch (IOException ex) {
            Logger.getLogger(RecursoCRUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value = "recursoDelete.html",method = RequestMethod.GET)
    public ModelAndView RecursoDelete(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/recurso/recursoDelete");
        String titulo = "Seguro desea eliminar";
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        Recurso recurso = recursoDAO.getByID(id);
        mav.addObject("titulo",titulo);
        mav.addObject("command",recurso);
        return mav;
    }
    
    @RequestMapping(value = "recursoDelete.html",method = RequestMethod.POST)
    public void RecursoDelete(HttpServletRequest request, HttpServletResponse response) {
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        recursoDAO.delete(id);
        try {
            response.sendRedirect("recursoList.html");
        } catch (IOException ex) {
            Logger.getLogger(CategoriaCRUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
