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
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    @SuppressWarnings("rawtypes")
	public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> map = movieLists.stream()
        	.flatMap(movieList -> movieList.getVideos().stream())
        	.map(video -> ImmutableMap.of(
        				"id", video.getId(),
        				"title", video.getTitle(),
        				// getting middle time of video
        				"time", video.getInterestingMoments().stream()
        						.filter(date -> "Middle".equals(date.getType()))
        						.findAny().get().getTime(),
        				// getting url boxArt of video
        				"url", video.getBoxarts().stream()
									.reduce(BoxArtUtil::smallest)
									.get().getUrl()))
        	.collect(Collectors.toList());
        return ImmutableList.copyOf(map);
    }
}

