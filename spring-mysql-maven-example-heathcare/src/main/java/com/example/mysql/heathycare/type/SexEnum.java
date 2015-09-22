package com.example.msql.heathycare.type;

public enum SexEnum {

	/** Male **/
	M ("Male"),
	
	/** Female **/
	F ("Female")
	;
	
	private String descriptions;
	
	/**
	 * Constructor.
	 * @param code
	 */
	private SexEnum(String descriptions){
		this.descriptions = descriptions;
	}

	public String getDescriptions() {
		return descriptions;
	}

}