package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class Kata10Test {

	@Test
	public void testExecuteSize() {
		Assert.assertThat(Kata10.execute().size(), equalTo(2));
	}

	@Test
	@SuppressWarnings ("rawtypes")
	public void testExecuteImmutable() {
		List<Map> immutableList = Kata10.execute();
		Assert.assertTrue(immutableList instanceof ImmutableList<?>);
		immutableList.forEach(map -> {
			Assert.assertTrue(map instanceof ImmutableMap<?, ?>);
		});
	}

	@Test
	@SuppressWarnings ({ "rawtypes", "unchecked" })
	public void testExecuteStructure() {
		Kata10.execute().forEach(map -> {
			Assert.assertTrue(map.containsKey("name"));
			Assert.assertTrue(map.containsKey("videos"));
			List<Map> videos = (List<Map>) map.get("videos");
			videos.forEach(video -> {
				Assert.assertTrue(video.containsKey("id"));
				Assert.assertTrue(video.containsKey("title"));
			});
		});
	}
}
