package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class Kata3Test {

	@Test
	public void testExecuteSize() {
		Assert.assertThat(Kata3.execute().size(), equalTo(4));
	}

	@Test
	public void testExecuteImmutable() {
		Assert.assertTrue(Kata3.execute() instanceof ImmutableList<?>);
	}
}
