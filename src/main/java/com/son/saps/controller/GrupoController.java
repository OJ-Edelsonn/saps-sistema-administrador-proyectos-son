package com.son.saps.controller;

            import com.son.saps.controller.base.BaseCrudController;
import com.son.saps.model.Grupo;
import com.son.saps.model.enums.EstadoGeneral;
import com.son.saps.service.CrudService;
import com.son.saps.service.CursoService;
import com.son.saps.service.DocenteService;
import com.son.saps.service.GrupoService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

            @Controller
            @RequestMapping("/grupos")
            public class GrupoController extends BaseCrudController<Grupo> {

                private final GrupoService service;
    private final CursoService cursoService;
    private final DocenteService docenteService;

                public GrupoController(GrupoService service, CursoService cursoService, DocenteService docenteService) {
                    this.service = service;
        this.cursoService = cursoService;
        this.docenteService = docenteService;
                }

                @Override
                protected CrudService<Grupo> service() {
                    return service;
                }

                @Override
                protected String viewPath() {
                    return "grupos";
                }

                @Override
                protected String basePath() {
                    return "/grupos";
                }

                @Override
                protected String moduleTitle() {
                    return "Grupos de trabajo";
                }

                @Override
                protected Grupo newEntity() {
                    return new Grupo();
                }

                @Override
                protected List<Grupo> findItems(String texto) {
                    return service.buscar(texto);
                }

                @Override
                protected void addFormData(Model model) {
                    model.addAttribute("estados", EstadoGeneral.values());
        model.addAttribute("cursos", cursoService.listarTodos());
        model.addAttribute("docentes", docenteService.listarTodos());
                }

            @GetMapping("/detalle/{id}")
public String detalle(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
    return service.buscarPorId(id)
            .map(item -> {
                model.addAttribute("item", item);
                return "grupos/detalle";
            })
            .orElseGet(() -> {
                redirectAttributes.addFlashAttribute("error", "Grupo no encontrado.");
                return "redirect:/grupos";
            });
}
            }
