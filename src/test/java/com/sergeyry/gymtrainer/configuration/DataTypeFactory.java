package com.sergeyry.gymtrainer.configuration;

import org.dbunit.dataset.datatype.DataType;
import org.dbunit.dataset.datatype.DataTypeException;
import org.dbunit.dataset.datatype.DefaultDataTypeFactory;

import java.sql.*;

public class DataTypeFactory
        extends DefaultDataTypeFactory
{

    public DataType createDataType(int sqlType, String sqlTypeName)
            throws DataTypeException
    {
        if (sqlType == Types.BOOLEAN)
        {
            return DataType.BOOLEAN;
        }

        return super.createDataType(sqlType, sqlTypeName);
    }
}
