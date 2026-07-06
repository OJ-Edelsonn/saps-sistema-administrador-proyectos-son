package com.son.saps.controller;

import com.son.saps.controller.base.BaseCrudController;
import com.son.saps.model.Calificacion;
import com.son.saps.model.enums.EstadoProyecto;
import com.son.saps.service.CalificacionService;
import com.son.saps.service.CrudService;
import com.son.saps.service.DocenteService;
import com.son.saps.service.ProyectoService;
import com.son.saps.service.RubricaService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/calificaciones")
public class CalificacionController extends BaseCrudController<Calificacion> {

  private final CalificacionService service;
  private final ProyectoService proyectoService;
  private final RubricaService rubricaService;
  private final DocenteService docenteService;

  public CalificacionController(
      CalificacionService service,
      ProyectoService proyectoService,
      RubricaService rubricaService,
      DocenteService docenteService) {
    this.service = service;
    this.proyectoService = proyectoService;
    this.rubricaService = rubricaService;
    this.docenteService = docenteService;
  }

  @Override
  protected CrudService<Calificacion> service() {
    return service;
  }

  @Override
  protected String viewPath() {
    return "calificaciones";
  }

  @Override
  protected String basePath() {
    return "/calificaciones";
  }

  @Override
  protected String moduleTitle() {
    return "Calificaciones";
  }

  @Override
  protected Calificacion newEntity() {
    return new Calificacion();
  }

  @Override
  protected List<Calificacion> findItems(String texto) {
    return service.buscar(texto);
  }

  @Override
  protected void addFormData(Model model) {
    model.addAttribute("proyectos", proyectoService.listarTodos());
    model.addAttribute("rubricas", rubricaService.listarTodos());
    model.addAttribute("docentes", docenteService.listarTodos());
    model.addAttribute("estadosProyecto", EstadoProyecto.values());
  }

  @GetMapping("/detalle/{id}")
  public String detalle(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
    return service
        .buscarPorId(id)
        .map(
            item -> {
              model.addAttribute("item", item);
              return "calificaciones/detalle";
            })
        .orElseGet(
            () -> {
              redirectAttributes.addFlashAttribute("error", "Calificacion no encontrada.");
              return "redirect:/calificaciones";
            });
  }
}
