package dev.habibzad.brewscape.controller;

import dev.habibzad.brewscape.dao.ProfileDao;
import dev.habibzad.brewscape.model.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileDao profileDao;

    public ProfileController(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    @PostMapping
    public ResponseEntity<Object> createProfile(@RequestBody Profile profile){
        return new ResponseEntity<>(profileDao.createProfile(profile), HttpStatus.CREATED);
    }
}
