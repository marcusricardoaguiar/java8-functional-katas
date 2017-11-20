package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class Kata1Test {

	@Test
	public void testExecuteSize() {
		Assert.assertThat(Kata1.execute().size(), equalTo(4));
	}

	@Test
	public void testExecuteImmutable() {
		@SuppressWarnings ("rawtypes")
		List<Map> immutableList = Kata1.execute();
		Assert.assertTrue(immutableList instanceof ImmutableList<?>);
		immutableList.forEach(map -> {
			Assert.assertTrue(map instanceof ImmutableMap<?, ?>);
		});
	}

	@Test
	public void testExecuteStructure() {
		Kata1.execute().forEach(map -> {
			Assert.assertTrue(map.containsKey("id"));
			Assert.assertTrue(map.containsKey("title"));
		});
	}
}
