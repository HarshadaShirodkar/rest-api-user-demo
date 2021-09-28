package com.api.repository;

import com.api.model.PhoneEntity;
import com.api.model.UserEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Datastore {
    //Map of names to Person instances.
    private Map<String, UserEntity> userMap = new HashMap<>();

    //private constructor so people know to use the getInstance() function instead
    private Datastore(){

        List<PhoneEntity> phoneEntities = new ArrayList<>();
        phoneEntities.add(new PhoneEntity(2L, new UserEntity(), "0000000000"));
        phoneEntities.add(new PhoneEntity(3L, new UserEntity(), "12345678"));

        userMap.put("1", new UserEntity( 1L,"A","John",
                false,phoneEntities));
        userMap.put("2", new UserEntity( 2L,"B","Kim",
                false,phoneEntities));
        userMap.put("3",new UserEntity( 3L,"C","Min",
                false,phoneEntities));

    }

    public List<PhoneEntity> getPhone(String userId) {
        UserEntity userEntity = userMap.get("1");

        return userEntity.getPhone();
    }

    public UserEntity getAllPhone() {

        return (UserEntity) userMap;
    }

}
