package pictolabeling.service;

import org.springframework.stereotype.Service;
import pictolabeling.api.client.SearchPictoClient;
import reactor.core.publisher.Mono;

/**
 * This is SearchPictoServiceImpl class.
 */
@Service
public class SearchPictoServiceImpl implements SearchPictoService {

  private final SearchPictoClient searchPictoClientClient;

  public SearchPictoServiceImpl(SearchPictoClient searchPictoClientClient) {
    this.searchPictoClientClient = searchPictoClientClient;
  }

  @Override
  public Mono<Integer> search(String query) {
    return searchPictoClientClient.callApi(query).map(dto -> dto.getPictoId());
  }
}
