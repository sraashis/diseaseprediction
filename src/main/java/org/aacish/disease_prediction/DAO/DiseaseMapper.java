package org.aacish.disease_prediction.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.aacish.disease_prediction.model.Disease;
import org.springframework.jdbc.core.RowMapper;

public class DiseaseMapper implements RowMapper<Disease> {

	public Disease mapRow(ResultSet rs, int rowNum) throws SQLException {
		Disease disease = new Disease();
		disease.setDiseaseName(rs.getString("DISEASE_NAME"));
		disease.setDocCount(rs.getInt("DOC_COUNT"));
		return disease;
	}

}
