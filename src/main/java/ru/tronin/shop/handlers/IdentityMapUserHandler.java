package ru.tronin.shop.handlers;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.tronin.shop.models.User;
import ru.tronin.shop.models.dtos.RamUser;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class IdentityMapUserHandler {
    Set<RamUser> ramUsers;


    Long ttl;

    @PostConstruct
    public void init(){
        ramUsers = new HashSet<>();
        ttl = 1500000L;
    }

    public User getUserFromRamById(Long id){
        updateRamUsers();
        Optional<RamUser> first = ramUsers.stream()
                .filter(x -> x.getUser().getId().equals(id))
                .findFirst();
        if (first.isEmpty()){
            return null;
        }
        log.info("Getting user from RAM");
        return first.get().getUser();
    }

    public void addUserToRam(User user){
        updateRamUsers();
        if (user.getId() == null){
            throw new IllegalArgumentException("User id mustn't be null");
        }
        if (getUserFromRamById(user.getId()) != null){
            removeUserFromRam(user.getId());
        }
        ramUsers.add(new RamUser(user, new Date(), ttl));
    }

    private void updateRamUsers(){
        ramUsers = ramUsers.stream()
                .filter(this::isTtlIsNotExpire)
                .collect(Collectors.toSet());
    }
    public void removeUserFromRam(Long id){
        ramUsers = ramUsers.stream()
                .filter(x -> !x.getUser().getId().equals(id))
                .collect(Collectors.toSet());
    }

    protected boolean isTtlIsNotExpire(RamUser user){
        long expirationTime = user.getDate().getTime() + user.getTtl();
        long now = new Date().getTime();
        return (now - expirationTime) <= 0;
    }


}
