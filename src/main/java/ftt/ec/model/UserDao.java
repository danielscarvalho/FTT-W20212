package ftt.ec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
	
	
	// Referência: 
	// https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-usagenotes-connect-drivermanager.html
	// https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.26
	
	private Connection connection;

    public UserDao() {
        connection = DbConnect.getDbConnection();
    } //PeopleDao
	
	public void add(User u) {
		
		//Conexão com o banco
		//SQL - Insert
		//Prepare statement: OBJ -> SQL
		//Execute
		try {
			
			/* 
			 INSERT INTO `ftt`.`USER`
				   (`ID`,
					`NAME`,
					`EMAIL`,
					`PHONE`,
					`DOB`,
					`COLOR`,
					`VALUE`,
					`CEP`,
					`COPLEMENT`, --ARRUMAR
					`PASSWORD`)
					VALUES
					(<{ID: }>,
					<{NAME: }>,
					<{EMAIL: }>,
					<{PHONE: }>,
					<{DOB: }>,
					<{COLOR: }>,
					<{VALUE: }>,
					<{CEP: }>,
					<{COPLEMENT: }>,
					<{PASSWORD: }>);
			*/

			
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO ftt.USER (NAME, EMAIL, PHONE, DOB, COLOR, VALUE, CEP, COPLEMENT, PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            // Parameters start with 1
            preparedStatement.setString(1, u.getUserName());
            preparedStatement.setString(2, u.getUserEmail());
            preparedStatement.setString(3, u.getUserTelefone());
            preparedStatement.setDate(4, null);//(java.sql.Date) u.getUserDOB()); //MAGIC - Não tem TIMEZONE no objeto Data do banco de dados...
            preparedStatement.setString(5, u.getUserColor());
            preparedStatement.setFloat(6, u.getUserValue());
            preparedStatement.setString(7, u.getUserCep());
            preparedStatement.setString(8, u.getUserComplement());
            preparedStatement.setString(9, u.getUserPassword());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

	    
	}

}
