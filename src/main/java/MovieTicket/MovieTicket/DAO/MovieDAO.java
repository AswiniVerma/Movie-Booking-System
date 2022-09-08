package MovieTicket.MovieTicket.DAO;

import java.util.List;

import MovieTicket.MovieTicket.entity.Movie;



public interface MovieDAO {
	public int addMovie(Movie movie);// we need to add the movie
	public int deleteMovie(Movie movie);
	public int deleteMovie(int id);
	public int updateMovie(Movie movie);
	
	public List<Movie> getAllMovies();// list krne k liye
	public Movie getMovieById(int id);

}
