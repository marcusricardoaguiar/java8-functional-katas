package katas;

import java.util.List;
import model.Movie;
import util.BoxArtUtil;
import util.DataUtil;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();
        return movies.stream()
        	.flatMap(movie -> movie.getBoxarts().stream())
        	.reduce(BoxArtUtil::largest)
        	.map(boxArt -> boxArt.getUrl())
        	.orElse("");
    }
}
