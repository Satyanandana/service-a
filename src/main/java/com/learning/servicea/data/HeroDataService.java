package com.learning.servicea.data;

import com.learning.servicea.graphql.types.Address;
import com.learning.servicea.graphql.types.Friend;
import com.learning.servicea.graphql.types.Hero;
import com.learning.servicea.security.AuthContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class HeroDataService {

    private   Map<String, Hero> heroMap = new HashMap<>();

    public HeroDataService() {

        Friend friend1 = new Friend("1");
        Friend friend2 = new Friend("2");
        Friend friend3 = new Friend("3");
        Friend friend4 = new Friend("4");
        Friend friend5 = new Friend("5");

        Address address1 = new Address("1");
        Address address2 = new Address("2");
        Address address3 = new Address("3");
        Address address4 = new Address("4");
        Address address5 = new Address("5");

        Hero hero1 = new Hero("1","Satya", List.of(friend2,friend3,friend4,friend5),friend2,address1);
        Hero hero2 = new Hero("2","Srikanth",List.of(friend1,friend3,friend4,friend5),friend3,address2);
        Hero hero3 = new Hero("3","Nandhu",List.of(friend1,friend2,friend4,friend5),friend4,address3);
        Hero hero4 = new Hero("4","Chinni",List.of(friend1,friend2,friend3,friend5),friend5,address4);
        Hero hero5 = new Hero("5","Sindhu",List.of(friend3,friend2,friend1,friend4),friend1,address5);

        heroMap.put("1",hero1);
        heroMap.put("2",hero2);
        heroMap.put("3",hero3);
        heroMap.put("4",hero4);
        heroMap.put("5",hero5);
    }

    public Map<String, Hero> getHeroMap() {
        log.info("Called getHeroMap - requestId {}", AuthContext.getRequestId());
        return heroMap;
    }
}
