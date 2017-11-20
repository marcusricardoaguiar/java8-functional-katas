package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

import model.BoxArt;
import util.BoxArtUtil;

public class BoxArtTest {

	@Test
	public void testBoxArtLargest() {
		BoxArt boxArt1 = new BoxArt(10, 10, "boxArt1");
		BoxArt boxArt2 = new BoxArt(21, 5, "boxArt1");
		BoxArt result = BoxArtUtil.largest(boxArt1, boxArt2);
		Assert.assertThat(result, equalTo(boxArt2));
	}

	@Test
	public void testBoxArtSmallest() {
		BoxArt boxArt1 = new BoxArt(10, 10, "boxArt1");
		BoxArt boxArt2 = new BoxArt(15, 5, "boxArt1");
		BoxArt result = BoxArtUtil.smallest(boxArt1, boxArt2);
		Assert.assertThat(result, equalTo(boxArt2));
	}
}
