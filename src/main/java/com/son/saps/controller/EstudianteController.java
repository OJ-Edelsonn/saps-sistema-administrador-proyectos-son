package com.son.saps.controller;

import com.son.saps.controller.base.BaseCrudController;
import com.son.saps.model.Estudiante;
import com.son.saps.model.enums.EstadoGeneral;
import com.son.saps.service.CrudService;
import com.son.saps.service.EstudianteService;
import com.son.saps.service.GrupoService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController extends BaseCrudController<Estudiante> {

  private final EstudianteService service;
  private final GrupoService grupoService;

  public EstudianteController(EstudianteService service, GrupoService grupoService) {
    this.service = service;
    this.grupoService = grupoService;
  }

  @Override
  protected CrudService<Estudiante> service() {
    return service;
  }

  @Override
  protected String viewPath() {
    return "estudiantes";
  }

  @Override
  protected String basePath() {
    return "/estudiantes";
  }

  @Override
  protected String moduleTitle() {
    return "Estudiantes";
  }

  @Override
  protected Estudiante newEntity() {
    return new Estudiante();
  }

  @Override
  protected List<Estudiante> findItems(String texto) {
    return service.buscar(texto);
  }

  @Override
  protected void addFormData(Model model) {
    model.addAttribute("estados", EstadoGeneral.values());
    model.addAttribute("grupos", grupoService.listarTodos());
  }
}
