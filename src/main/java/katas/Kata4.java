package katas;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import model.MovieList;
import util.DataUtil;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
	
	private static final int WIDTH = 150;
	private static final int HEIGHT = 200;
	
    @SuppressWarnings("rawtypes")
	public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> map = movieLists.stream()
        	.flatMap(movieList -> movieList.getVideos().stream())
        	.map(video -> ImmutableMap.of("id", video.getId(), "title", video.getTitle(), 
        			"boxart", video.getBoxarts().stream()
        						.filter(getBoxArtUrl())
        						.findAny()))
        	.collect(Collectors.toList());
        return ImmutableList.copyOf(map);
    }
    
    private static Predicate<BoxArt> getBoxArtUrl(){
    	return boxArt -> boxArt.getWidth() == WIDTH && boxArt.getHeight() == HEIGHT;
    }
}
