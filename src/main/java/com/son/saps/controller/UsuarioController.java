package com.son.saps.controller;

            import com.son.saps.controller.base.BaseCrudController;
import com.son.saps.model.Usuario;
import com.son.saps.model.enums.EstadoGeneral;
import com.son.saps.service.CrudService;
import com.son.saps.service.RolService;
import com.son.saps.service.UsuarioService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

            @Controller
            @RequestMapping("/usuarios")
            public class UsuarioController extends BaseCrudController<Usuario> {

                private final UsuarioService service;
    private final RolService rolService;

                public UsuarioController(UsuarioService service, RolService rolService) {
                    this.service = service;
        this.rolService = rolService;
                }

                @Override
                protected CrudService<Usuario> service() {
                    return service;
                }

                @Override
                protected String viewPath() {
                    return "usuarios";
                }

                @Override
                protected String basePath() {
                    return "/usuarios";
                }

                @Override
                protected String moduleTitle() {
                    return "Usuarios";
                }

                @Override
                protected Usuario newEntity() {
                    return new Usuario();
                }

                @Override
                protected List<Usuario> findItems(String texto) {
                    return service.buscar(texto);
                }

                @Override
                protected void addFormData(Model model) {
                    model.addAttribute("roles", rolService.listarTodos());
        model.addAttribute("estados", EstadoGeneral.values());
                }


            }
