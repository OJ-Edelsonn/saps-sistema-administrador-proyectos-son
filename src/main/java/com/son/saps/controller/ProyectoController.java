package com.son.saps.controller;

            import com.son.saps.controller.base.BaseCrudController;
import com.son.saps.model.Proyecto;
import com.son.saps.model.enums.EstadoProyecto;
import com.son.saps.service.CrudService;
import com.son.saps.service.CursoService;
import com.son.saps.service.DocenteService;
import com.son.saps.service.GrupoService;
import com.son.saps.service.ProyectoService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

            @Controller
            @RequestMapping("/proyectos")
            public class ProyectoController extends BaseCrudController<Proyecto> {

                private final ProyectoService service;
    private final CursoService cursoService;
    private final GrupoService grupoService;
    private final DocenteService docenteService;

                public ProyectoController(ProyectoService service, CursoService cursoService, GrupoService grupoService, DocenteService docenteService) {
                    this.service = service;
        this.cursoService = cursoService;
        this.grupoService = grupoService;
        this.docenteService = docenteService;
                }

                @Override
                protected CrudService<Proyecto> service() {
                    return service;
                }

                @Override
                protected String viewPath() {
                    return "proyectos";
                }

                @Override
                protected String basePath() {
                    return "/proyectos";
                }

                @Override
                protected String moduleTitle() {
                    return "Proyectos integradores";
                }

                @Override
                protected Proyecto newEntity() {
                    return new Proyecto();
                }

                @Override
                protected List<Proyecto> findItems(String texto) {
                    return service.buscar(texto);
                }

                @Override
                protected void addFormData(Model model) {
                    model.addAttribute("estadosProyecto", EstadoProyecto.values());
        model.addAttribute("cursos", cursoService.listarTodos());
        model.addAttribute("grupos", grupoService.listarTodos());
        model.addAttribute("docentes", docenteService.listarTodos());
                }

            @GetMapping("/detalle/{id}")
public String detalle(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
    return service.buscarPorId(id)
            .map(item -> {
                model.addAttribute("item", item);
                return "proyectos/detalle";
            })
            .orElseGet(() -> {
                redirectAttributes.addFlashAttribute("error", "Proyecto no encontrado.");
                return "redirect:/proyectos";
            });
}
            }
