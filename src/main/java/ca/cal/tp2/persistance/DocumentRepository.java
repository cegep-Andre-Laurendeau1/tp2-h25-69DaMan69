package ca.cal.tp1.persistance;

import ca.cal.tp1.modele.Document;
import ca.cal.tp1.modele.Livre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentRepository extends RepositoryParent{
    public void save(Document document){
        String sql = """
                insert into document values(?,?,?);
                """;
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql);) {
            preparedStatement.setInt(1,document.getDocumentID() );
            preparedStatement.setString(2, document.getTitre());
            preparedStatement.setInt(3, document.getNombreExemplaires());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Document getDocument(int document){
        String sql = """
                select * from document where id = ?;
                """;
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql);) {
            preparedStatement.setInt(1, document);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Document(resultSet.getInt("id"), resultSet.getString("titre"), resultSet.getInt("nombreExemplaires"));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
