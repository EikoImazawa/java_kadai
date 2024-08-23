package kadai_007;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Posts_Chapter07 {
	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement insertstatement = null;

		String[][] postList = { { "1003", "2023-02-08", "昨日の夜は徹夜でした・・", "13" },
				{ "1002", "2023-02-08", "お疲れ様です！", "12" }, { "1003", "2023-02-09", "今日も頑張ります！", "18" },
				{ "1001", "2023-02-09", "無理は禁物ですよ！", "17" }, { "1002", "2023-02-10", "明日から連休ですね！", "20" } };

		try {
			// データベース接続
			con = DriverManager.getConnection("jdbc:mysql://localhost/challenge_java", "root", "samurai-2023");

			System.out.println("データベース接続成功:" + con);

			// SQLクエリを準備

			System.out.println("レコード追加を実行します");

			// データを取得
			String sql = "INSERT INTO posts (user_id, posted_at, post_content, likes) VALUES (?, ?, ?, ?);";
			PreparedStatement insertStatement = con.prepareStatement(sql);

			int rowCnt = 0;
			for (String[] post : postList) {
				int user_id = Integer.parseInt(post[0]);
				String posted_at = post[1];
				String post_content = post[2];
				int likes = Integer.parseInt(post[3]);

				insertStatement.setInt(1, user_id);
				insertStatement.setString(2, posted_at);
				insertStatement.setString(3, post_content);
				insertStatement.setInt(4, likes);

				rowCnt = rowCnt + insertStatement.executeUpdate();
			}

			System.out.println( rowCnt + "件のレコードを追加されました");
			
			// データを検索・実行
			PreparedStatement selectStatement = con
					.prepareStatement("SELECT posted_at, post_content, likes FROM posts WHERE user_id = ?;");
			selectStatement.setInt(1, 1002);
			ResultSet result = selectStatement.executeQuery();
			System.out.println("ユーザーIDが1002のレコードを検索しました");

			// 実行結果を抽出
			while (result.next()) {
				Date posted_at = result.getDate("posted_at");
				String post_content = result.getString("post_content");
				int likes = result.getInt("likes");

				System.out
						.println(result.getRow() + "件目：投稿日時=" + posted_at + "／投稿内容=" + post_content + "／いいね数=" + likes);
			}
		} catch (SQLException e) {
			System.out.println("エラー発生：" + e.getMessage());
		} finally {
			if (insertstatement != null) {
				try {
					insertstatement.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
	}

//        Connection con = null;
//        Statement statement = null;
//
//        try {
//            // データベースに接続
//            con = DriverManager.getConnection(
//                "jdbc:mysql://localhost/challenge_java",
//                "root",
//                "samurai-2023"
//            );
//
//            System.out.println("データベース接続成功：" + con );
//
//            // SQLクエリを準備
//            statement = con.createStatement();
////            String sqlInsert = 
////                """
////                INSERT INTO posts (user_id, posted_at, post_content, likes) VALUES
////                  (1003, '2023-02-08', '昨日の夜は徹夜でした・・', 13),
////                  (1002, '2023-02-08', 'お疲れ様です！', 12),
////                  (1003, '2023-02-09', '今日も頑張ります！', 18),
////                  (1001, '2023-02-09', '無理は禁物ですよ！', 17),
////                  (1002, '2023-02-10', '明日から連休ですね！', 20);                        
////                """;
//            String sqlInsert = "INSERT INTO posts (user_id, posted_at, post_content, likes) VALUES " +
//                    "(1003, '2023-02-08', '昨日の夜は徹夜でした・・', 13), " +
//                    "(1002, '2023-02-08', 'お疲れ様です！', 12), " +
//                    "(1003, '2023-02-09', '今日も頑張ります！', 18), " +
//                    "(1001, '2023-02-09', '無理は禁物ですよ！', 17), " +
//                    "(1002, '2023-02-10', '明日から連休ですね！', 20);";
//
//            // データ追加のSQLクエリを実行（DBMSに送信）
//            System.out.println("レコード追加を実行します" );
//            int rowCnt = statement.executeUpdate(sqlInsert);                
//            System.out.println( rowCnt + "件のレコードが追加されました");
//
//            //　データ検索のSQLクエリを実行（DBMSに送信）
//            String sqlSelect = "SELECT posted_at, post_content ,likes FROM posts WHERE user_id = 1002;";
//            ResultSet result = statement.executeQuery(sqlSelect);
//
//            // SQLクエリの実行結果を抽出
//            System.out.println( "ユーザーIDが1002のレコードを検索しました");
//            while(result.next()) {
//                Date postedAt = result.getDate("posted_at");
//                String postContent = result.getString("post_content");
//                int likes = result.getInt("likes");
//                System.out.println(result.getRow() + "件目：投稿日時=" + postedAt
//                                   + "／投稿内容=" + postContent + "／いいね数=" + likes );
//            }
//        } catch(SQLException e) {
//            System.out.println("エラー発生：" + e.getMessage());
//        } finally {
//            // 使用したオブジェクトを解放
//            if( statement != null ) {
//                try { statement.close(); } catch(SQLException ignore) {}
//            }
//            if( con != null ) {
//                try { con.close(); } catch(SQLException ignore) {}
//            }
//        }
//    }
}
