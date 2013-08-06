package net.ulatina.rocio.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the user_has_profile database table.
 * 
 */
@Embeddable
public class UserHasProfilePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="user_id")
	private int userId;

	@Column(name="profile_id")
	private int profileId;

	public UserHasProfilePK() {
	}
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProfileId() {
		return this.profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserHasProfilePK)) {
			return false;
		}
		UserHasProfilePK castOther = (UserHasProfilePK)other;
		return 
			(this.userId == castOther.userId)
			&& (this.profileId == castOther.profileId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userId;
		hash = hash * prime + this.profileId;
		
		return hash;
	}
}