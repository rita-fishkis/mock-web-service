package edu.rtkr.websystem.mockserver;

public enum DeviceState {
	ACTIV, NOT_AKTIV, DELETED;
	public static DeviceState from(String stateName) throws IllegalArgumentException{
		for (DeviceState state : values()) {
			if (state.name().equalsIgnoreCase(stateName)) {
				return state;
			}
		}
		throw new IllegalArgumentException();
	}
	public static boolean isActiv(DeviceState state) {
		return state.ordinal() == DeviceState.ACTIV.ordinal();
	}
}
