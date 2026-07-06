package com.son.saps.controller;

import com.son.saps.controller.base.BaseCrudController;
import com.son.saps.model.Docente;
import com.son.saps.model.enums.EstadoGeneral;
import com.son.saps.service.CrudService;
import com.son.saps.service.DocenteService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/docentes")
public class DocenteController extends BaseCrudController<Docente> {

  private final DocenteService service;

  public DocenteController(DocenteService service) {
    this.service = service;
  }

  @Override
  protected CrudService<Docente> service() {
    return service;
  }

  @Override
  protected String viewPath() {
    return "docentes";
  }

  @Override
  protected String basePath() {
    return "/docentes";
  }

  @Override
  protected String moduleTitle() {
    return "Docentes";
  }

  @Override
  protected Docente newEntity() {
    return new Docente();
  }

  @Override
  protected List<Docente> findItems(String texto) {
    return service.buscar(texto);
  }

  @Override
  protected void addFormData(Model model) {
    model.addAttribute("estados", EstadoGeneral.values());
  }
}
