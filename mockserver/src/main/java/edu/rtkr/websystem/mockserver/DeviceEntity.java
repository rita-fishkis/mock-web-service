package edu.rtkr.websystem.mockserver;

import java.util.Objects;

public class DeviceEntity {

	private Long id; 
	private String name; 
	private double wert; 
	private DeviceState state;
	public DeviceEntity(Long id, String name, double wert, DeviceState state) {
		super();
		this.id = id;
		this.name = name;
		this.wert = wert;
		this.state = state;
	}
	public DeviceEntity(){
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWert() {
		return wert;
	}
	public void setWert(double wert) {
		this.wert = wert;
	}
	public DeviceState getState() {
		return state;
	}
	public void setState(DeviceState state) {
		this.state = state;
	}
	public void updateWert(double addWert) {
		if (DeviceState.isActiv(this.state)) {
			this.wert = this.wert + addWert;

		}		
	}
	@Override
	public
	String toString() {
		return "id = " + id 
				+", name = " + name
				+", wert = " + wert
				+", state = " + state.name();
	}
	
	@Override
	public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof DeviceEntity))
	      return false;
	    DeviceEntity DeviceEntity = (DeviceEntity) o;
	    return Objects.equals(this.id, DeviceEntity.id) 
	    		&& Objects.equals(this.name, DeviceEntity.name)
	    		&& Objects.equals(this.wert, DeviceEntity.wert)
	    		&& Objects.equals(this.state, DeviceEntity.state);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id, this.name, 
	    		this.wert, 
	    		this.state);
	  }


}
