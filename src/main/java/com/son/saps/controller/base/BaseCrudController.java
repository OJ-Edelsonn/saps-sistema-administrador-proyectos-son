package com.son.saps.controller.base;

import com.son.saps.service.CrudService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public abstract class BaseCrudController<T> {

  protected abstract CrudService<T> service();

  protected abstract String viewPath();

  protected abstract String basePath();

  protected abstract String moduleTitle();

  protected abstract T newEntity();

  protected List<T> findItems(String texto) {
    return service().listarTodos();
  }

  protected void addFormData(Model model) {}

  @GetMapping
  public String list(@RequestParam(name = "q", required = false) String q, Model model) {
    model.addAttribute("items", findItems(q));
    model.addAttribute("q", q);
    model.addAttribute("moduleTitle", moduleTitle());
    model.addAttribute("basePath", basePath());
    return viewPath() + "/list";
  }

  @GetMapping("/nuevo")
  public String nuevo(Model model) {
    model.addAttribute("item", newEntity());
    model.addAttribute("moduleTitle", moduleTitle());
    model.addAttribute("basePath", basePath());
    addFormData(model);
    return viewPath() + "/form";
  }

  @GetMapping("/editar/{id}")
  public String editar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
    return service()
        .buscarPorId(id)
        .map(
            item -> {
              model.addAttribute("item", item);
              model.addAttribute("moduleTitle", moduleTitle());
              model.addAttribute("basePath", basePath());
              addFormData(model);
              return viewPath() + "/form";
            })
        .orElseGet(
            () -> {
              redirectAttributes.addFlashAttribute("error", "Registro no encontrado.");
              return "redirect:" + basePath();
            });
  }

  @PostMapping("/guardar")
  public String guardar(
      @Valid @ModelAttribute("item") T item,
      BindingResult bindingResult,
      Model model,
      RedirectAttributes redirectAttributes) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("moduleTitle", moduleTitle());
      model.addAttribute("basePath", basePath());
      addFormData(model);
      return viewPath() + "/form";
    }
    service().guardar(item);
    redirectAttributes.addFlashAttribute("success", "Registro guardado correctamente.");
    return "redirect:" + basePath();
  }

  @GetMapping("/eliminar/{id}")
  public String eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
    service().eliminarPorId(id);
    redirectAttributes.addFlashAttribute("success", "Registro eliminado correctamente.");
    return "redirect:" + basePath();
  }
}
