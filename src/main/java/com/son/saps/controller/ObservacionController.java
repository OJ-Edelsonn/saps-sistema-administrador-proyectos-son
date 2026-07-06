package com.son.saps.controller;

import com.son.saps.controller.base.BaseCrudController;
import com.son.saps.model.Observacion;
import com.son.saps.model.enums.EstadoObservacion;
import com.son.saps.model.enums.NivelObservacion;
import com.son.saps.service.CrudService;
import com.son.saps.service.DocenteService;
import com.son.saps.service.EntregableService;
import com.son.saps.service.ObservacionService;
import com.son.saps.service.ProyectoService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/observaciones")
public class ObservacionController extends BaseCrudController<Observacion> {

  private final ObservacionService service;
  private final ProyectoService proyectoService;
  private final EntregableService entregableService;
  private final DocenteService docenteService;

  public ObservacionController(
      ObservacionService service,
      ProyectoService proyectoService,
      EntregableService entregableService,
      DocenteService docenteService) {
    this.service = service;
    this.proyectoService = proyectoService;
    this.entregableService = entregableService;
    this.docenteService = docenteService;
  }

  @Override
  protected CrudService<Observacion> service() {
    return service;
  }

  @Override
  protected String viewPath() {
    return "observaciones";
  }

  @Override
  protected String basePath() {
    return "/observaciones";
  }

  @Override
  protected String moduleTitle() {
    return "Observaciones";
  }

  @Override
  protected Observacion newEntity() {
    return new Observacion();
  }

  @Override
  protected List<Observacion> findItems(String texto) {
    return service.buscar(texto);
  }

  @Override
  protected void addFormData(Model model) {
    model.addAttribute("nivelesObservacion", NivelObservacion.values());
    model.addAttribute("estadosObservacion", EstadoObservacion.values());
    model.addAttribute("proyectos", proyectoService.listarTodos());
    model.addAttribute("entregables", entregableService.listarTodos());
    model.addAttribute("docentes", docenteService.listarTodos());
  }
}
