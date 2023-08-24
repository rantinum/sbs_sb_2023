package com.khj.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.khj.exam.demo.vo.Article;

@Mapper
public interface ArticleRepository {
	public void writeArticle(@Param("memberId") int memberId, @Param("boardId") int boardId,
			@Param("title") String title, @Param("body") String body);

	@Select("""
			<script>
				SELECT A.*,
				M.nickname AS extra__writerName
				FROM article AS A
				LEFT JOIN `member` AS M
				ON A.memberId = M.id
				<if test="boardId != 0">
					WHERE A.boardId = #{boardId}
				</if>
				ORDER BY A.id DESC
				<if test="limitTake != -1">
					LIMIT #{limitStart}, #{limitTake}
				</if>
			</script>
			""")
	public List<Article> getForPrintArticles(@Param("boardId") int boardId, int limitStart, int limitTake);

	@Select("""
			SELECT A.*,
			M.nickname AS extra__writerName
			FROM article AS A
			LEFT JOIN `member` AS M
			ON A.memberId = M.id
			WHERE A.id = #{id}
			""")
	public Article getForPrintArticle(@Param("id") int id);

	public void deleteArticle(@Param("id") int id);

	public void modifyArticle(@Param("id") int id, @Param("title") String title, @Param("body") String body);

	public int getLastInsertId();

	@Select("""
			<script>
				SELECT COUNT(*) AS cnt
				FROM article AS A
				<if test="boardId != 0">
					WHERE A.boardId = #{boardId}
				</if>
				<if test="searchKeyword != ''">
				  <choose>
				    <when test="searchKeywordTypeCode == 'title'">
				      AND A.title LIKE CONCAT('%', #{searchKeyword}, '%')
				    </when>
				    <when test="searchKeywordTypeCode == 'body'">
				      AND A.body LIKE CONCAT('%', #{searchKeyword}, '%')
				    </when>
				    <otherwise>
				    	AND (
				    		A.title LIKE CONCAT('%', #{searchKeyword}, '%')
				    		OR
				    		A.body LIKE CONCAT('%', #{searchKeyword}, '%')
				    	)
				    </otherwise>
				  </choose>
				</if>
			</script>
			""")
	public int getArticlesCount(int boardId, String searchKeywordTypeCode, String searchKeyword);
}