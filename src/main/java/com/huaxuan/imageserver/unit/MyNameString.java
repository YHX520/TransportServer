package com.huaxuan.imageserver.unit;

public class MyNameString {

	/**
	 * @param args
	 */
	static int imageCount=10;
	static String imagePath="c://test//";
	static String[] name=new String[]{
			"孤街酒客°",
			"故人还未归",
			"说给风听，笑给云看",
			"流年的〞真情",
			"岁月苍老的讽刺",
			"素笺淡墨",
			"风夏了白雪",
			"メ雨辰ゞヤ",
			"深院空巷锁千秋",
			"一杯清茗，久葬我心",
			"病话",
			"一枕清风梦绿萝",
			"千里故人稀"
	};
	static public String getName(){
		
		return name[(int) (Math.random()*100%name.length)];
	}
	static public String getImage(){
		return ((int) (Math.random()*100%imageCount))+".jpg";
	}
}
