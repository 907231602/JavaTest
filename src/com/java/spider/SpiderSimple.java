package com.java.spider;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SpiderSimple {

	public static void get_url(String url) {
		try {
			Document dc = Jsoup.connect(url).get();

			// System.out.println(dc);
			Element content = dc.getElementById("content");

			Elements links = content.getElementsByTag("a");

			Elements pngs = dc.select("img[src$=.png]");

			Element masthead = dc.select("div.masthead").first();

			for (Element link : links) {
				// 得到<a>...</a>里面的网址
				String linkHref = link.attr("href");
				// 得到<a>...</a>里面的汉字
				String linkText = link.text();
				System.out.println(linkText);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://www.cnblogs.com/TTyb/p/5784581.html";
		get_url(url);
	}

}
