package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class Kata7Test {

	@Test
	public void testExecuteSize() {
		Assert.assertThat(Kata7.execute().size(), equalTo(4));
	}

	@Test
	@SuppressWarnings ("rawtypes")
	public void testExecuteImmutable() {
		List<Map> immutableList = Kata7.execute();
		Assert.assertTrue(immutableList instanceof ImmutableList<?>);
		immutableList.forEach(map -> {
			Assert.assertTrue(map instanceof ImmutableMap<?, ?>);
		});
	}

	@Test
	public void testExecuteStructure() {
		Kata7.execute().forEach(map -> {
			Assert.assertTrue(map.containsKey("id"));
			Assert.assertTrue(map.containsKey("title"));
			Assert.assertTrue(map.containsKey("url"));
		});
	}
}
