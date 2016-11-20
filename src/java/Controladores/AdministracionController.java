/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CategoriaDAO;
import DAO.RecursoDAO;
import DAO.SubcategoriaDAO;
import Models.Recurso;
import Models.Subcategoria;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author nelso
 */

@Controller
public class AdministracionController {
    
//    Esto va en otra clase cuando resuelva el problema    

    
    
//    Fin de la otra clase    
    @RequestMapping(value = "administracionIndex")
    public ModelAndView administracionIndex() {
        ModelAndView mav = new ModelAndView("admin/indexAdmin");
        String titulo = "Administracion";
        mav.addObject("titulo",titulo);
        return mav;
    }
    
}
