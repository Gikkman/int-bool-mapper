package com.gikk.int_bool_mapper;

import com.speedment.config.db.mapper.TypeMapper;

public class IntegerToBooleanMapper implements TypeMapper<Integer, Boolean>{

	@Override
	public Class<Boolean> getJavaType() {
		return Boolean.class;
	}

	@Override
	public Class<Integer> getDatabaseType() {
		return Integer.class;
	}

	@Override
	public Boolean toJavaType(Integer value) {
		if( value == 0) 
			return false;
		else if( value == 1)
			return true;
		else
			throw new UnsupportedOperationException(
				"Cannot parse " + value +" to a Boolean."
			);
	}

	@Override
	public Integer toDatabaseType(Boolean value) {
		return value.booleanValue() == true ? 1 : 0;
	}

	@Override
	public boolean isIdentityMapper() {
		return false;
	}

}
