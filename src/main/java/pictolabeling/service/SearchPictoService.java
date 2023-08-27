package pictolabeling.service;

import reactor.core.publisher.Mono;

/**
 * This is SearchPictoService class.
 */
public interface SearchPictoService {
  public Mono<Integer> search(String query);
}
