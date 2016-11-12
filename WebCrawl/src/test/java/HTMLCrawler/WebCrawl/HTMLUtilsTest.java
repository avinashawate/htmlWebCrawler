package HTMLCrawler.WebCrawl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


/* Created By : Avinash R Awate
 * Date : 12/11/2016
 * Simple web crawler which get all the links & media links in the website 
 */

public class HTMLUtilsTest {

	public static void main(String[] args) throws IOException {

		try {

			// String which takes website
			String website = "http://wiprodigital.com";

			// String list which extract links from the website source file
			List<String> weblinks = HTMLUtils.extractLinks(website);

			// Text file to write the output sitemap for the website
			FileWriter writeinfile = new FileWriter("SiteMapOutput.txt");

			for (String htmllink : weblinks) {
				//System.out.println(htmllink);
				// Writing html links in the file
				writeinfile.write(htmllink);
				writeinfile.write("\n");
			}

			// Close file after writing the website links
			writeinfile.close();
		}

		// Catch if any exception which prints in the console
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}