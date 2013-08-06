package net.ulatina.rocio.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the profile database table.
 * 
 */
@Entity
@Table(name="profile")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String description;

	private String name;

	//bi-directional many-to-one association to ProfileHasApp
	@OneToMany(mappedBy="profile")
	private Set<ProfileHasApp> profileHasApps;

	//bi-directional many-to-one association to UserHasProfile
	@OneToMany(mappedBy="profile")
	private Set<UserHasProfile> userHasProfiles;

	public Profile() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ProfileHasApp> getProfileHasApps() {
		return this.profileHasApps;
	}

	public void setProfileHasApps(Set<ProfileHasApp> profileHasApps) {
		this.profileHasApps = profileHasApps;
	}

	public ProfileHasApp addProfileHasApp(ProfileHasApp profileHasApp) {
		getProfileHasApps().add(profileHasApp);
		profileHasApp.setProfile(this);

		return profileHasApp;
	}

	public ProfileHasApp removeProfileHasApp(ProfileHasApp profileHasApp) {
		getProfileHasApps().remove(profileHasApp);
		profileHasApp.setProfile(null);

		return profileHasApp;
	}

	public Set<UserHasProfile> getUserHasProfiles() {
		return this.userHasProfiles;
	}

	public void setUserHasProfiles(Set<UserHasProfile> userHasProfiles) {
		this.userHasProfiles = userHasProfiles;
	}

	public UserHasProfile addUserHasProfile(UserHasProfile userHasProfile) {
		getUserHasProfiles().add(userHasProfile);
		userHasProfile.setProfile(this);

		return userHasProfile;
	}

	public UserHasProfile removeUserHasProfile(UserHasProfile userHasProfile) {
		getUserHasProfiles().remove(userHasProfile);
		userHasProfile.setProfile(null);

		return userHasProfile;
	}

}