package net.ulatina.rocio.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the module_has_app database table.
 * 
 */
@Embeddable
public class ModuleHasAppPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="module_id")
	private int moduleId;

	@Column(name="app_id")
	private int appId;

	public ModuleHasAppPK() {
	}
	public int getModuleId() {
		return this.moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
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
		if (!(other instanceof ModuleHasAppPK)) {
			return false;
		}
		ModuleHasAppPK castOther = (ModuleHasAppPK)other;
		return 
			(this.moduleId == castOther.moduleId)
			&& (this.appId == castOther.appId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.moduleId;
		hash = hash * prime + this.appId;
		
		return hash;
	}
}