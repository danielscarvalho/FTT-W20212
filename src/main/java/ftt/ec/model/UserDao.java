package ftt.ec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	
	
	// Referência: 
	// https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-usagenotes-connect-drivermanager.html
	// https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.26
	
	private Connection connection;

    public UserDao() {
        connection = DbConnect.getDbConnection();
    } //PeopleDao
	
	public User get(User u) {
		
		/*
		 * SELECT `USER`.`ID`,
			    `USER`.`NAME`,
			    `USER`.`EMAIL`,
			    `USER`.`PHONE`,
			    `USER`.`DOB`,
			    `USER`.`COLOR`,
			    `USER`.`VALUE`,
			    `USER`.`CEP`,
			    `USER`.`COPLEMENT`,
			    `USER`.`PASSWORD`
			FROM `ftt`.`USER`;
		 * 
		 * 
		 * 
		 */
		
		User user = new User();
		
        try {
        	
			PreparedStatement preparedStatement = connection
			        .prepareStatement("SELECT * FROM ftt.USER WHERE ID=?");
			
            preparedStatement.setInt(1, u.getUserId());
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                
                user.setUserId(rs.getString("ID"));
                user.setUserName(rs.getString("NAME"));
                user.setUserEmail(rs.getString("EMAIL"));
                user.setUserTelefone(rs.getString("PHONE"));
                user.setUserDOB(rs.getString("DOB"));
                user.setUserColor(rs.getString("COLOR"));
                user.setUserValue(rs.getString("VALUE"));
                user.setUserCep(rs.getString("CEP"));
                user.setUserComplement(rs.getString("COPLEMENT"));
                user.setUserPassword(rs.getString("PASSWORD"));
                
                System.out.println("User ID: " + user);
                
            } //while

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //try
        
        return user;
		
	} //get
    
    
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
            preparedStatement.setDate(4, new java.sql.Date( u.getUserDOB().getTime() )); //MAGIC - Não tem TIMEZONE no objeto Data do banco de dados...
            preparedStatement.setString(5, u.getUserColor());
            preparedStatement.setFloat(6, u.getUserValue());
            preparedStatement.setString(7, u.getUserCep());
            preparedStatement.setString(8, u.getUserComplement());
            preparedStatement.setString(9, u.getUserPassword());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } //try
		
	} //Add

	public void update(User u) {
		
		//Conexão com o banco
		//SQL - Insert
		//Prepare statement: OBJ -> SQL
		//Execute
		try {
			
			/*
			 * 
			 * UPDATE `ftt`.`USER`
				SET
				`ID` = <{ID: }>,
				`NAME` = <{NAME: }>,
				`EMAIL` = <{EMAIL: }>,
				`PHONE` = <{PHONE: }>,
				`DOB` = <{DOB: }>,
				`COLOR` = <{COLOR: }>,
				`VALUE` = <{VALUE: }>,
				`CEP` = <{CEP: }>,
				`COPLEMENT` = <{COPLEMENT: }>,
				`PASSWORD` = <{PASSWORD: }>
				WHERE `ID` = <{expr}>;

			 * 
			 */

			
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE ftt.USER SET NAME=?, EMAIL=?, PHONE=?, DOB=?, COLOR=?, VALUE=?, CEP=?, COPLEMENT=?, PASSWORD=? WHERE ID=?");
            
            // Parameters start with 1
            preparedStatement.setString(1, u.getUserName());
            preparedStatement.setString(2, u.getUserEmail());
            preparedStatement.setString(3, u.getUserTelefone());
            preparedStatement.setDate(4, new java.sql.Date( u.getUserDOB().getTime() )); //MAGIC - Não tem TIMEZONE no objeto Data do banco de dados... //MAGIC - Não tem TIMEZONE no objeto Data do banco de dados...
            preparedStatement.setString(5, u.getUserColor());
            preparedStatement.setFloat(6, u.getUserValue());
            preparedStatement.setString(7, u.getUserCep());
            preparedStatement.setString(8, u.getUserComplement());
            preparedStatement.setString(9, u.getUserPassword());
            preparedStatement.setInt(10, u.getUserId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } //try
		
	} //Update
	
	
	public void delete(User u) {
	
		/*
		 * DELETE FROM `ftt`.`USER` WHERE <{where_expression}>;
		 * 
		 */
		
		try {
		
			PreparedStatement preparedStatement = connection
			        .prepareStatement("DELETE FROM ftt.USER WHERE ID=?");
		
            preparedStatement.setInt(1, u.getUserId());
            
            preparedStatement.execute();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //try
        
		
	} // delete

}
