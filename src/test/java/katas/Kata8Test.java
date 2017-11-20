package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class Kata8Test {

	@Test
	public void testExecuteSize() {
		Assert.assertThat(Kata8.execute().size(), equalTo(3));
	}

	@Test
	@SuppressWarnings ("rawtypes")
	public void testExecuteImmutable() {
		List<Map> immutableList = Kata8.execute();
		Assert.assertTrue(immutableList instanceof ImmutableList<?>);
		immutableList.forEach(map -> {
			Assert.assertTrue(map instanceof ImmutableMap<?, ?>);
		});
	}

	@Test
	public void testExecuteStructure() {
		Kata8.execute().forEach(map -> {
			Assert.assertTrue(map.containsKey("videoId"));
			Assert.assertTrue(map.containsKey("bookmarkId"));
		});
	}
}
