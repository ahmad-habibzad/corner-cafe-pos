package dev.habibzad.brewscape.dao;

import dev.habibzad.brewscape.model.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfileDaoImpl implements ProfileDao{

    private final JdbcTemplate jdbcTemplate;

    public ProfileDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Profile findProfileById(int id){
        Profile profile = null;
        String sql = "select * from profile where profile_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);
        if (rowSet.next()){
            profile = mapRowToProfile(rowSet);
        }
        return profile;
    }

    public List<Profile> getAllProfiles(){
        List<Profile> profiles = new ArrayList<>();
        String sql = "select * from profile";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()){
            profiles.add(mapRowToProfile(rowSet));
        }
        return profiles;
    }

    public Profile createProfile(Profile p){
        String sql = "insert into profile (first_name, last_name, email, phone, address) values (?, ?, ?, ?, ?) returning profile_id";
        int profileId = jdbcTemplate.queryForObject(sql, int.class, p.getFirstName(), p.getLastName(), p.getEmail(), p.getPhone(), p.getAddress());
        return findProfileById(profileId);
    }

    private Profile mapRowToProfile(SqlRowSet rs){
        int id = rs.getInt("profile_id");
        String firstName = rs.getString("first_name");
        String lasName = rs.getString("last_name");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String address = rs.getString("address");
        return new Profile(id, firstName, lasName, email, phone, address);
    }


}
