package com.learning.servicea.graphql.datafetchers;

import com.learning.servicea.data.HeroDataService;
import com.learning.servicea.graphql.types.Hero;
import com.learning.servicea.security.AuthContext;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Slf4j
@DgsComponent
public class GetAllHerosDatafetcher {

  @Autowired
  private HeroDataService heroDataService;

  @DgsData(
      parentType = "Query",
      field = "getAllHeros"
  )
  public Collection<Hero> getGetAllHeros(DataFetchingEnvironment dataFetchingEnvironment) {
    log.info("Called Hero datafetcher  - requestId {}", AuthContext.getRequestId());
    return heroDataService
            .getHeroMap()
            .values();
  }
}
