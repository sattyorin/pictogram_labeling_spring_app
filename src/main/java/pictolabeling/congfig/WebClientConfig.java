package pictolabeling.congfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * This is WebClientConfig.
 */
@Configuration
@EnableAspectJAutoProxy // TODO(sara): Is it needed?
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
