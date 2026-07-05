package com.son.saps.controller;

            import com.son.saps.controller.base.BaseCrudController;
import com.son.saps.model.Rubrica;
import com.son.saps.model.enums.EstadoGeneral;
import com.son.saps.service.CriterioEvaluacionService;
import com.son.saps.service.CrudService;
import com.son.saps.service.CursoService;
import com.son.saps.service.RubricaService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

            @Controller
            @RequestMapping("/rubricas")
            public class RubricaController extends BaseCrudController<Rubrica> {

                private final RubricaService service;
    private final CursoService cursoService;
    private final CriterioEvaluacionService criterioService;

                public RubricaController(RubricaService service, CursoService cursoService, CriterioEvaluacionService criterioService) {
                    this.service = service;
        this.cursoService = cursoService;
        this.criterioService = criterioService;
                }

                @Override
                protected CrudService<Rubrica> service() {
                    return service;
                }

                @Override
                protected String viewPath() {
                    return "rubricas";
                }

                @Override
                protected String basePath() {
                    return "/rubricas";
                }

                @Override
                protected String moduleTitle() {
                    return "Rubricas";
                }

                @Override
                protected Rubrica newEntity() {
                    return new Rubrica();
                }

                @Override
                protected List<Rubrica> findItems(String texto) {
                    return service.buscar(texto);
                }

                @Override
                protected void addFormData(Model model) {
                    model.addAttribute("estados", EstadoGeneral.values());
        model.addAttribute("cursos", cursoService.listarTodos());
                }

            @GetMapping("/{id}/criterios")
public String criterios(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
    return service.buscarPorId(id)
            .map(item -> {
                model.addAttribute("rubrica", item);
                model.addAttribute("criterios", criterioService.listarPorRubrica(id));
                return "rubricas/criterios";
            })
            .orElseGet(() -> {
                redirectAttributes.addFlashAttribute("error", "Rubrica no encontrada.");
                return "redirect:/rubricas";
            });
}
            }
