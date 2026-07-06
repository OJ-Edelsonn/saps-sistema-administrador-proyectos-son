package com.son.saps.controller;

import com.son.saps.controller.base.BaseCrudController;
import com.son.saps.model.Entregable;
import com.son.saps.model.enums.EstadoEntregable;
import com.son.saps.model.enums.TipoEntregable;
import com.son.saps.service.CrudService;
import com.son.saps.service.EntregableService;
import com.son.saps.service.ProyectoService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/entregables")
public class EntregableController extends BaseCrudController<Entregable> {

  private final EntregableService service;
  private final ProyectoService proyectoService;

  public EntregableController(EntregableService service, ProyectoService proyectoService) {
    this.service = service;
    this.proyectoService = proyectoService;
  }

  @Override
  protected CrudService<Entregable> service() {
    return service;
  }

  @Override
  protected String viewPath() {
    return "entregables";
  }

  @Override
  protected String basePath() {
    return "/entregables";
  }

  @Override
  protected String moduleTitle() {
    return "Entregables";
  }

  @Override
  protected Entregable newEntity() {
    return new Entregable();
  }

  @Override
  protected List<Entregable> findItems(String texto) {
    return service.buscar(texto);
  }

  @Override
  protected void addFormData(Model model) {
    model.addAttribute("estadosEntregable", EstadoEntregable.values());
    model.addAttribute("tiposEntregable", TipoEntregable.values());
    model.addAttribute("proyectos", proyectoService.listarTodos());
  }
}
