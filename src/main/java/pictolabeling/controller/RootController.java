package pictolabeling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.result.view.Rendering;
import pictolabeling.form.QueryForm;
import reactor.core.publisher.Mono;

/**
 * This is RootController.
 */
// Thymeleafによって生成されるHTMLをレスポンスする場合は、@Controllerを使います。
// JSONやXMLをレスポンスするようなAPI形式の場合は、@RestControllerを使うのが適切です。
@Controller
public class RootController {

  /**
   * Initialize the QueryForm object for every new request.
   *
   * @return a new QueryForm object.
   */
  @ModelAttribute("queryForm")
  public QueryForm setupForm() {
    // no model.addAttribute("queryForm", new QueryForm()); needed.
    return new QueryForm();
  }

  /**
   * This is root handler method.
   *
   * @return page.html
   */
  @RequestMapping("/")
  public Mono<Rendering> handler() {
    return Mono.just(Rendering.view("page").build());
  }
}
