package pictolabeling.congfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * This is WebClientConfig.
 */
@Configuration
public class WebClientConfig {

  /**
   * Definition of WebClient.
   *
   * @return {@code WebClient}
   */
  @Bean
  public WebClient webClient() {
    return WebClient.create("http://localhost:5000");
  }

}
