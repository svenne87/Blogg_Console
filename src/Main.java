import blog.Author;
import blog.Blogg;
import blog.Category;
import blog.Post;
import blog.BlogFactory;
import java.sql.SQLException;
import java.util.Date;

public class Main {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		
		Blogg bloggSystem = new Blogg();
		
		bloggSystem.setAuthors(BlogFactory.getAllAuthors());
		bloggSystem.setCategories(BlogFactory.getAllCategories());
		bloggSystem.setPosts(BlogFactory.getAllPosts(bloggSystem));
		
		Post post1 = BlogFactory.getPost(2, bloggSystem);
		
		//System.out.println(post1.getBlogPost());
		//System.out.println("==== ==== ==== ==== ====");
		

		//hämta alla inlägg
		for (Post post : bloggSystem.getPosts()) {
			System.out.println("==== ==== ==== ==== ====");
			System.out.println(post.getBlogPost());
		}
		
		Author author = new Author();
		author.setValues("Olle", "Karlsson", 35, "male", "Sweden", "olle@ollewebb.se");
		//BlogFactory.insertAuthor(author);
		
		Category category = new Category();
		category.setValues("väder");
		//BlogFactory.insertCategory(category);
		
		Post post = new Post();
		Date date = new Date();
		post.setValues("Nytt väder", "Solen skiner än!", date);
		post.setAuthor(bloggSystem.getAuthors().get(2));
		post.setCategory(bloggSystem.getCategories().get(2));
		
		//BlogFactory.insertPost(post);  //Funkar men tiden visas alltid som 00,00,00
	}

}

