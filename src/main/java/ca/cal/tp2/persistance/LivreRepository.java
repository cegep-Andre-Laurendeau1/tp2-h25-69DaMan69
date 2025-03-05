package ca.cal.tp1.persistance;

import ca.cal.tp1.modele.Livre;
import ca.cal.tp1.modele.Utilisateur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LivreRepository extends RepositoryParent{
    public void save(Livre livre) {
        String sql = """
                insert into livre values(?,?,?,?);
                """;
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql);) {
            preparedStatement.setString(1,livre.getISBN() );
            preparedStatement.setString(2, livre.getAuteur());
            preparedStatement.setString(3, livre.getEditeur());
            preparedStatement.setInt(4, livre.getNombrePages());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Livre getLivre(String livre){
        String sql = """
                select * from livre where isbn = ?;
                """;
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql);) {
            preparedStatement.setString(1, livre);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Livre(resultSet.getString("isbn"), resultSet.getString("auteur"), resultSet.getString("editeur"), resultSet.getInt("nombrePages"));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
