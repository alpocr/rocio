package net.ulatina.rocio.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the function_has_module database table.
 * 
 */
@Embeddable
public class FunctionHasModulePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="function_id")
	private int functionId;

	@Column(name="module_id")
	private int moduleId;

	public FunctionHasModulePK() {
	}
	public int getFunctionId() {
		return this.functionId;
	}
	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}
	public int getModuleId() {
		return this.moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FunctionHasModulePK)) {
			return false;
		}
		FunctionHasModulePK castOther = (FunctionHasModulePK)other;
		return 
			(this.functionId == castOther.functionId)
			&& (this.moduleId == castOther.moduleId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.functionId;
		hash = hash * prime + this.moduleId;
		
		return hash;
	}
}