package dev.habibzad.brewscape.dao;

import dev.habibzad.brewscape.model.Profile;

import java.util.List;

public interface ProfileDao {
    Profile findProfileById(int id);
    List<Profile> getAllProfiles();
    Profile createProfile(Profile p);
}
