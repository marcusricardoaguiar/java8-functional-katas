package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class Kata2Test {

	@Test
	public void testExecuteSize() {
		Assert.assertThat(Kata2.execute().size(), equalTo(2));
	}

	@Test
	public void testExecuteImmutable() {
		Assert.assertTrue(Kata2.execute() instanceof ImmutableList<?>);
	}
}
