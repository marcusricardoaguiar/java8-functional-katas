package util;

import model.BoxArt;

/*
 * Compare two BoxArts and return one of them
 */
public class BoxArtUtil {

	// Get the largest BoxArt
	public static BoxArt largest(BoxArt a, BoxArt b) {
		return (a.getWidth() * a.getHeight()) < (b.getWidth() * b.getHeight()) ? b : a;
	}

	// Get the smallest BoxArt
	public static BoxArt smallest(BoxArt a, BoxArt b) {
		return (a.getHeight() * a.getWidth()) > (b.getHeight() * b.getWidth()) ? b : a;
	}
}
