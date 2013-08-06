package net.ulatina.rocio.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the function_has_module database table.
 * 
 */
@Entity
@Table(name="function_has_module")
public class FunctionHasModule implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FunctionHasModulePK id;

	private byte enable;

	//bi-directional many-to-one association to Function
	@ManyToOne
	private Function function;

	//bi-directional many-to-one association to Module
	@ManyToOne
	private Module module;

	public FunctionHasModule() {
	}

	public FunctionHasModulePK getId() {
		return this.id;
	}

	public void setId(FunctionHasModulePK id) {
		this.id = id;
	}

	public byte getEnable() {
		return this.enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}

	public Function getFunction() {
		return this.function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

}