package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import model.MovieList;
import util.BoxArtUtil;
import util.DataUtil;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    @SuppressWarnings("rawtypes")
	public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> map = movieLists.stream()
	        	.flatMap(movie -> movie.getVideos().stream())
	        	.map(video -> ImmutableMap.of("id", video.getId(), "title", video.getTitle(), 
	        			// getting smallest boxarts
	        			"url", video.getBoxarts().stream()
	        						.reduce(BoxArtUtil::smallest)
	        						.get().getUrl()))
	        	.collect(Collectors.toList());
        return ImmutableList.copyOf(map);
    }
}
