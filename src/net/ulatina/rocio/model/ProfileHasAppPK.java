package net.ulatina.rocio.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the profile_has_app database table.
 * 
 */
@Embeddable
public class ProfileHasAppPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="profile_id")
	private int profileId;

	@Column(name="app_id")
	private int appId;

	public ProfileHasAppPK() {
	}
	public int getProfileId() {
		return this.profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public int getAppId() {
		return this.appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProfileHasAppPK)) {
			return false;
		}
		ProfileHasAppPK castOther = (ProfileHasAppPK)other;
		return 
			(this.profileId == castOther.profileId)
			&& (this.appId == castOther.appId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.profileId;
		hash = hash * prime + this.appId;
		
		return hash;
	}
}