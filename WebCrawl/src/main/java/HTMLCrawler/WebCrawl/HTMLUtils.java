package HTMLCrawler.WebCrawl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* Created By : Avinash R Awate
 * Date : 12/11/2016
 */

public class HTMLUtils {
	
	private HTMLUtils() {
		}
	
	public static List<String> extractLinks(String weburl) throws IOException {
		
		final ArrayList<String> linkresult = new ArrayList<String>();

		Document doc = Jsoup.connect(weburl).get();

		Elements htmllinks = doc.select("a[href]");
		
		Elements medialinks = doc.select("[src]");
		
		// Extract HTML href Links
		for (Element link : htmllinks) {
			linkresult.add(link.attr("abs:href"));
		}

		// Extract Image & Media Links
		for (Element src : medialinks) {
			linkresult.add(src.attr("abs:src"));
		}

		
		return linkresult;
	}

}
