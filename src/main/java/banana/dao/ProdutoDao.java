package banana.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import banana.model.Produto;

public class ProdutoDao {
	
	public void cadastrarProduto(Produto produto) {
		
		String sql = "INSERT INTO PRODUTO VALUES (null, ?, ?, ?, ?)";
		
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		try {
			
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, produto.getDescricao());
			pStatement.setInt(2, produto.getQuantidade());
			pStatement.setDouble(3, produto.getPreco());
			pStatement.setBoolean(4, produto.isOnLine());
			pStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			try {
				
				if (pStatement != null)
					pStatement.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				if (conn != null) 
					conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
