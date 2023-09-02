package pictolabeling.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.result.view.Rendering;
import org.springframework.web.server.ServerWebExchange;
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
  @GetMapping("/")
  public Mono<Rendering> rootHandler(@Validated @ModelAttribute("queryForm") QueryForm queryForm,
      BindingResult result, ServerWebExchange exchange) {
    if (result.hasErrors()) {
      return Mono.just(Rendering.view("error").build());
    }
    Mono<QueryForm> attributeMono = exchange.getAttribute("queryForm");
    System.out.println(attributeMono);

    // spring webfluxとModelAttributeは一緒に使わないかな。
    Map<String, Object> attributes = exchange.getAttributes();
    System.out.println(attributes);

    return Mono.just(Rendering.view("page").build());
  }
}
