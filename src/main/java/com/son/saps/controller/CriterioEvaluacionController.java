package com.son.saps.controller;

import com.son.saps.controller.base.BaseCrudController;
import com.son.saps.model.CriterioEvaluacion;
import com.son.saps.service.CriterioEvaluacionService;
import com.son.saps.service.CrudService;
import com.son.saps.service.RubricaService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/criterios")
public class CriterioEvaluacionController extends BaseCrudController<CriterioEvaluacion> {

  private final CriterioEvaluacionService service;
  private final RubricaService rubricaService;

  public CriterioEvaluacionController(
      CriterioEvaluacionService service, RubricaService rubricaService) {
    this.service = service;
    this.rubricaService = rubricaService;
  }

  @Override
  protected CrudService<CriterioEvaluacion> service() {
    return service;
  }

  @Override
  protected String viewPath() {
    return "criterios";
  }

  @Override
  protected String basePath() {
    return "/criterios";
  }

  @Override
  protected String moduleTitle() {
    return "Criterios de evaluacion";
  }

  @Override
  protected CriterioEvaluacion newEntity() {
    return new CriterioEvaluacion();
  }

  @Override
  protected List<CriterioEvaluacion> findItems(String texto) {
    return service.buscar(texto);
  }

  @Override
  protected void addFormData(Model model) {
    model.addAttribute("rubricas", rubricaService.listarTodos());
  }
}
