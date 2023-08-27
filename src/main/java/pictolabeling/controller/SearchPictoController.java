package pictolabeling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.result.view.Rendering;
import pictolabeling.form.QueryForm;
import pictolabeling.service.SearchPictoServiceImpl;
import reactor.core.publisher.Mono;

/**
 * This is SearchPictoController.
 */
@Controller
public class SearchPictoController {

  private final SearchPictoServiceImpl searchPictoService;

  @Autowired
  public SearchPictoController(SearchPictoServiceImpl searchPictoService) {
    this.searchPictoService = searchPictoService;
  }

  /**
   * Handles a request to the "/search".
   *
   * @return a Mono containing the Rendering object for the "page.html" view.
   */
  @RequestMapping(value = "/search", method = RequestMethod.GET)
  public Mono<Rendering> handler(@ModelAttribute("queryForm") @Validated QueryForm queryForm,
      BindingResult result, Model model) {

    if (result.hasErrors()) {
      return Mono.just(Rendering.view("page").build());
    }

    final Mono<Integer> id = searchPictoService.search(queryForm.getQuery());
    return id.flatMap(i -> {
      return Mono.just(Rendering.view("page").modelAttribute("id", i).build());
    });
  }
}
