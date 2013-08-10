package net.ulatina.rocio.dao;

import java.util.List;

public interface Dao {
	
	/*
	 * Este método será usado para guardar un objeto
	 */
	public void save(Object obj);
	
	/*
	 * Este método será usado para guardar una lista de objetos
	 */
	public void save(List<Object> list);
	
	
	/**
	 * Este método será usado para eliminar un objeto. 
	 * 
	 * @param obj
	 * @return True si el objeto fue eliminado o False si no se guardó.
	 */
	public Boolean delete(Object obj);
	
	
	/*
	 * Este metodo será usado para borrar una lista de objetos
	 */
	public Boolean delete(List<Object> list);
	
	
	/**
	 * Método usado para actualizar un objeto.
	 * 
	 * @param objx objeto antiguo
	 * @param objy objeto nuevo
	 * @return True si fué actualizado con éxito o False si hubo
	 * algún problema
	 */
	public Boolean update(Object objx, Object objy);
	
	
	/*
	 * Este método será usado para obtener una lista de objetos, 
	 * recibiendo por parámetro una sentencia hql.
	 */
	public <T> List<T> getList(String hql);
	
	
	/*
	 * Este método será usado para obtener una lista de objetos, 
	 * recibiendo como parametro una clase entidad.
	 */
	public <T> List<T> getList(Class<T> entityClass);

}
