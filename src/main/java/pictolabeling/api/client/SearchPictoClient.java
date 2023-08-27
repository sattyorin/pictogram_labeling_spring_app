package pictolabeling.api.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pictolabeling.api.dto.SearchPictoRequestDto;
import pictolabeling.api.dto.SearchPictoResponseDto;
import reactor.core.publisher.Mono;

/**
 * This is SearchPictoApiClient.
 */
@Component
public class SearchPictoClient {

  private final WebClient webClient;

  public SearchPictoClient(WebClient webClient) {
    this.webClient = webClient;
  }

  /**
   * This is callApi.
   *
   * @return Mono&lt;SearchPictoResponseDto&gt; A Mono object representing the asynchronous
   *         operation.
   */
  public Mono<SearchPictoResponseDto> callApi(String query) {
    return webClient.post().uri("/search").bodyValue(new SearchPictoRequestDto(query)).retrieve()
        .bodyToMono(SearchPictoResponseDto.class);

    /*
     * if post
     * 
     * return webClient.post().uri(uriBuilder -> uriBuilder.path("/search").queryParam("query",
     * "hello my app").build()).retrieve().bodyToMono(SearchPictoResponseDto.class);
     */

  }
}
