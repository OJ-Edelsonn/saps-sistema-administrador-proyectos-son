package com.son.saps.controller;

import com.son.saps.controller.base.BaseCrudController;
import com.son.saps.model.Curso;
import com.son.saps.model.enums.EstadoGeneral;
import com.son.saps.service.CrudService;
import com.son.saps.service.CursoService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cursos")
public class CursoController extends BaseCrudController<Curso> {

  private final CursoService service;

  public CursoController(CursoService service) {
    this.service = service;
  }

  @Override
  protected CrudService<Curso> service() {
    return service;
  }

  @Override
  protected String viewPath() {
    return "cursos";
  }

  @Override
  protected String basePath() {
    return "/cursos";
  }

  @Override
  protected String moduleTitle() {
    return "Cursos";
  }

  @Override
  protected Curso newEntity() {
    return new Curso();
  }

  @Override
  protected List<Curso> findItems(String texto) {
    return service.buscar(texto);
  }

  @Override
  protected void addFormData(Model model) {
    model.addAttribute("estados", EstadoGeneral.values());
  }
}
