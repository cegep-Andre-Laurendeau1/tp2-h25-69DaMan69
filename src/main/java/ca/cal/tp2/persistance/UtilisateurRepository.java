package ca.cal.tp1.persistance;

import ca.cal.tp1.modele.Utilisateur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurRepository extends RepositoryParent {

    public void save(Utilisateur user) {
        String sql = """
                insert into utilisateur values(?,?,?,?);
                """;
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql);) {
            preparedStatement.setLong(1, user.getUserID() );
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Utilisateur getUtilisateur(int user){
        String sql = """
                select * from utilisateur where userid = ?;
                """;
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql);) {
            preparedStatement.setInt(1, user);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Utilisateur(resultSet.getInt("userid"), resultSet.getString("name"), resultSet.getString("email"), resultSet.getString("phoneNumber"));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
