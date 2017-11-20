package katas;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import util.BoxArtUtil;
import util.DataUtil;

/*
    Goal: Create a datastructure from the given data:

    This time we have 4 seperate arrays each containing lists, videos, boxarts, and bookmarks respectively.
    Each object has a parent id, indicating its parent.
    We want to build an array of list objects, each with a name and a videos array.
    The videos array will contain the video's id, title, bookmark time, and smallest boxart url.
    In other words we want to build the following structure:

    [
        {
            "name": "New Releases",
            "videos": [
                {
                    "id": 65432445,
                    "title": "The Chamber",
                    "time": 32432,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/TheChamber130.jpg"
                },
                {
                    "id": 675465,
                    "title": "Fracture",
                    "time": 3534543,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/Fracture120.jpg"
                }
            ]
        },
        {
            "name": "Thrillers",
            "videos": [
                {
                    "id": 70111470,
                    "title": "Die Hard",
                    "time": 645243,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"
                },
                {
                    "id": 654356453,
                    "title": "Bad Boys",
                    "time": 984934,
                    "boxart": "http://cdn-0.nflximg.com/images/2891/BadBoys140.jpg"
                }
            ]
        }
    ]

    DataSource: DataUtil.getLists(), DataUtil.getVideos(), DataUtil.getBoxArts(), DataUtil.getBookmarkList()
    Output: the given datastructure
*/
public class Kata11 {
	@SuppressWarnings ("rawtypes")
	public static List<Map> execute() {
        List<Map> lists = DataUtil.getLists();
        List<Map> videos = DataUtil.getVideos();

        List<Map> map = lists.stream()
            	.map(list -> ImmutableMap.of(
            			"name", list.get("name"),
            			"videos", videos.stream()
            						.filter(video -> video.get("listId").equals(list.get("id")))
            						.map(getVideo())
            						.collect(Collectors.toList())
            			)
            	)
            	.collect(Collectors.toList());

        return ImmutableList.copyOf(map);
    }
	
	// Get video info
	@SuppressWarnings ("rawtypes")
	public static Function<Map, Map> getVideo() {
		List<Map> boxArts = DataUtil.getBoxArts();
        List<Map> bookmarkList = DataUtil.getBookmarkList();
        
		return video -> ImmutableMap.of(
				"id", video.get("id"),
				"title", video.get("title"),
				// getting the smallest boxArt of each video
				"boxart", boxArts.stream()
					        .filter(boxArt -> boxArt.get("videoId").equals(video.get("id")))
					        .map(boxArt -> new BoxArt(Integer.valueOf(boxArt.get("width").toString()),
					        		Integer.valueOf(boxArt.get("height").toString()),
					        		boxArt.get("url").toString()))
					        .reduce(BoxArtUtil::smallest)
					        .get().getUrl(),
			    // getting time of each bookmark
				"time", bookmarkList.stream()
							.filter(bookMark -> bookMark.get("videoId").equals(video.get("id")))
							.map(bookMark -> bookMark.get("time"))
							.findAny().get());
	}
}
