package katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import model.MovieList;
import util.DataUtil;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    @SuppressWarnings("rawtypes")
	public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Map> map = movieLists.stream()
        	.flatMap(movieList -> movieList.getVideos().stream())
        	.map(video -> ImmutableMap.of("id", video.getId(), "title", video.getTitle(), 
        			"boxart",video.getBoxarts()))
        	.collect(Collectors.toList());
        return ImmutableList.copyOf(map);
    }
}
