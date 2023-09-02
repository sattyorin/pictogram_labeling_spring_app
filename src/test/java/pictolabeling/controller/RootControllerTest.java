package pictolabeling.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * This is RootControllerTest class.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class RootControllerTest {
  @Autowired
  private WebTestClient webTestClient;


  @Test
  public void testHandler() {
    webTestClient.get().uri("/").exchange().expectStatus().isOk().expectBody(String.class)
        .consumeWith(response -> {
          String body = response.getResponseBody();
          // ここで、bodyが期待する内容（page.htmlの内容）であることを確認します。
          // 例えば、Thymeleafを使用している場合は、生成されたHTMLが期待するものであるか確認できます。
        });
  }
}
