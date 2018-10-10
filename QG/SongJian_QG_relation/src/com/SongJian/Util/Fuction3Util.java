package com.SongJian.Util;

public class Fuction3Util {
	public int job(String src)
	{
		int father = src.indexOf("°Ö°Ö");
		int grandpa = src.indexOf("Ò¯Ò¯");
		int grandson = src.indexOf("Ëï×Ó");
		int son = src.indexOf("¶ù×Ó");
		int bigbrother = src.indexOf("¸ç¸ç");
		int littlebrother = src.indexOf("µÜµÜ");
		int brother = src.indexOf("ÐÖµÜ");
		int teacher = src.indexOf("ÀÏÊ¦");
		int student = src.indexOf("Ñ§Éú");
		int classmate = src.indexOf("Í¬Ñ§");
		
		
		//°Ö°Ö
		if(src.indexOf("°Ö°Ö")>0 && src.lastIndexOf("°Ö°Ö")>0 && grandpa<0 && grandson<0 && son<0 && bigbrother<0 && littlebrother<0 && brother<0 && teacher<0 && student<0 && classmate<0)
		{
			//System.out.println("°Ö°ÖºÍ°Ö°Ö1");
			return 1;
		}
		if(src.indexOf("°Ö°Ö")>0 && src.lastIndexOf("Ò¯Ò¯")>0 && grandson<0 && son<0 && bigbrother<0 && littlebrother<0 && brother<0 && teacher<0 && student<0 && classmate<0)
		{
			//System.out.println("°Ö°ÖºÍÒ¯Ò¯");
			return 2;
		}
		if(src.indexOf("°Ö°Ö")>0 && src.lastIndexOf("¶ù×Ó")>0 &&src.indexOf("°Ö°Ö")<src.indexOf("¶ù×Ó") && grandpa<0 && grandson<0 && bigbrother<0 && littlebrother<0 && brother<0 && teacher<0 && student<0 && classmate<0)
		{
			//System.out.println("°Ö°ÖºÍ¶ù×Ó");
			return 3;
		}
		if(src.indexOf("°Ö°Ö")>0 && src.lastIndexOf("Ëï×Ó")>0 )
		{
			//System.out.println("°Ö°ÖºÍËï×Ó");
			return 4;
		}
		if(src.indexOf("°Ö°Ö")>0 && src.lastIndexOf("¸ç¸ç")>0)
		{
			//System.out.println("°Ö°ÖºÍ¸ç¸ç");
			return 5;
		}
		if(src.indexOf("°Ö°Ö")>0 && src.lastIndexOf("µÜµÜ")>0)
		{
			//System.out.println("°Ö°ÖºÍµÜµÜ");
			return 6;
		}
		if(src.indexOf("°Ö°Ö")>0 && src.lastIndexOf("Ñ§Éú")>0)
		{
			//System.out.println("°Ö°ÖºÍÑ§Éú");
			return 7;
		}
		if(src.indexOf("°Ö°Ö")>0 && src.lastIndexOf("ÀÏÊ¦")>0)
		{
			//System.out.println("°Ö°ÖºÍÀÏÊ¦");
			return 8;
		}
		if(src.indexOf("°Ö°Ö")>0 && src.lastIndexOf("Í¬Ñ§")>0)
		{
			//System.out.println("°Ö°ÖºÍÍ¬Ñ§");
			return 9;
		}
		if(src.indexOf("°Ö°Ö")>0 && src.lastIndexOf("ÐÖµÜ")>0)
		{
			//System.out.println("°Ö°ÖºÍÐÖµÜ");
			return 10;
		}
		
		//¶ù×Ó
		if(src.indexOf("¶ù×Ó")>0 && src.lastIndexOf("°Ö°Ö")>0 && src.indexOf("¶ù×Ó")<src.lastIndexOf("°Ö°Ö"))
		{
			return 11;
		}
		if(src.indexOf("¶ù×Ó")>0 && src.lastIndexOf("Ò¯Ò¯")>0&& father <0 && grandson<0 && bigbrother<0 && littlebrother<0 && brother<0 && teacher<0 && student<0 && classmate<0)
		{
			return 12;
		}
		if(src.indexOf("¶ù×Ó")>0 && src.lastIndexOf("¶ù×Ó")>0 && father <0&& grandpa<0 && grandson<0 && bigbrother<0 && littlebrother<0 && brother<0 && teacher<0 && student<0 && classmate<0)
		{
			return 13;
		}
		if(src.indexOf("¶ù×Ó")>0 && src.lastIndexOf("Ëï×Ó")>0 && father <0&& grandpa<0 && bigbrother<0 && littlebrother<0 && brother<0 && teacher<0 && student<0 && classmate<0)
		{
			return 14;
		}
		if(src.indexOf("¶ù×Ó")>0 && src.lastIndexOf("¸ç¸ç")>0)
		{
			return 15;
		}
		if(src.indexOf("¶ù×Ó")>0 && src.lastIndexOf("µÜµÜ")>0)
		{
			return 16;
		}
		if(src.indexOf("¶ù×Ó")>0 && src.lastIndexOf("Ñ§Éú")>0)
		{
			return 17;
		}
		if(src.indexOf("¶ù×Ó")>0 && src.lastIndexOf("ÀÏÊ¦")>0)
		{
			return 18;
		}
		if(src.indexOf("¶ù×Ó")>0 && src.lastIndexOf("Í¬Ñ§")>0)
		{
			return 19;
		}
		if(src.indexOf("¶ù×Ó")>0 && src.lastIndexOf("Ëï×Ó")>0)
		{
			return 20;
		}
		
		
		//Ò¯Ò¯
		if(src.indexOf("Ò¯Ò¯")>0 && src.lastIndexOf("°Ö°Ö")>0)
		{
			return 31;
		}
		if(src.indexOf("Ò¯Ò¯")>0 && src.lastIndexOf("Ò¯Ò¯")>0)
		{
			return 32;
		}
		if(src.indexOf("Ò¯Ò¯")>0 && src.lastIndexOf("¶ù×Ó")>0)
		{
			return 33;
		}
		if(src.indexOf("Ò¯Ò¯")>0 && src.lastIndexOf("Ëï×Ó")>0)
		{
			return 34;
		}
		if(src.indexOf("Ò¯Ò¯")>0 && src.lastIndexOf("¸ç¸ç")>0)
		{
			return 35;
		}
		if(src.indexOf("Ò¯Ò¯")>0 && src.lastIndexOf("µÜµÜ")>0)
		{
			return 36;
		}
		if(src.indexOf("Ò¯Ò¯")>0 && src.lastIndexOf("Ñ§Éú")>0)
		{
			return 37;
		}
		if(src.indexOf("Ò¯Ò¯")>0 && src.lastIndexOf("ÀÏÊ¦")>0)
		{
			return 38;
		}
		if(src.indexOf("Ò¯Ò¯")>0 && src.lastIndexOf("Í¬Ñ§")>0)
		{
			return 39;
		}
		if(src.indexOf("Ò¯Ò¯")>0 && src.lastIndexOf("Ëï×Ó")>0)
		{
			return 40;
		}
		
		//Ëï×Ó
		if(src.indexOf("Ëï×Ó")>0 && src.lastIndexOf("°Ö°Ö")>0)
		{
			return 41;
		}
		if(src.indexOf("Ëï×Ó")>0 && src.lastIndexOf("Ò¯Ò¯")>0)
		{
			return 42;
		}
		if(src.indexOf("Ëï×Ó")>0 && src.lastIndexOf("¶ù×Ó")>0)
		{
			return 43;
		}
		if(src.indexOf("Ëï×Ó")>0 && src.lastIndexOf("Ëï×Ó")>0)
		{
			return 44;
		}
		if(src.indexOf("Ëï×Ó")>0 && src.lastIndexOf("¸ç¸ç")>0)
		{
			return 45;
		}
		if(src.indexOf("Ëï×Ó")>0 && src.lastIndexOf("µÜµÜ")>0)
		{
			return 46;
		}
		if(src.indexOf("Ëï×Ó")>0 && src.lastIndexOf("Ñ§Éú")>0)
		{
			return 47;
		}
		if(src.indexOf("Ëï×Ó")>0 && src.lastIndexOf("ÀÏÊ¦")>0)
		{
			return 48;
		}
		if(src.indexOf("Ëï×Ó")>0 && src.lastIndexOf("Í¬Ñ§")>0)
		{
			return 49;
		}
		if(src.indexOf("Ëï×Ó")>0 && src.lastIndexOf("Ëï×Ó")>0)
		{
			return 50;
		}
		
		//¸ç¸ç
		if(src.indexOf("¸ç¸ç")>0 && src.lastIndexOf("°Ö°Ö")>0)
		{
			return 51;
		}
		if(src.indexOf("¸ç¸ç")>0 && src.lastIndexOf("Ò¯Ò¯")>0)
		{
			return 52;
		}
		if(src.indexOf("¸ç¸ç")>0 && src.lastIndexOf("¶ù×Ó")>0)
		{
			return 53;
		}
		if(src.indexOf("¸ç¸ç")>0 && src.lastIndexOf("Ëï×Ó")>0)
		{
			return 54;
		}
		if(src.indexOf("¸ç¸ç")>0 && src.lastIndexOf("¸ç¸ç")>0)
		{
			return 55;
		}
		if(src.indexOf("¸ç¸ç")>0 && src.lastIndexOf("µÜµÜ")>0)
		{
			return 56;
		}
		if(src.indexOf("¸ç¸ç")>0 && src.lastIndexOf("Ñ§Éú")>0)
		{
			return 57;
		}
		if(src.indexOf("¸ç¸ç")>0 && src.lastIndexOf("ÀÏÊ¦")>0)
		{
			return 58;
		}
		if(src.indexOf("¸ç¸ç")>0 && src.lastIndexOf("Í¬Ñ§")>0)
		{
			return 59;
		}
		if(src.indexOf("¸ç¸ç")>0 && src.lastIndexOf("Ëï×Ó")>0)
		{
			return 60;
		}
		
		//µÜµÜ
		if(src.indexOf("µÜµÜ")>0 && src.lastIndexOf("°Ö°Ö")>0)
		{
			return 51;
		}
		if(src.indexOf("µÜµÜ")>0 && src.lastIndexOf("Ò¯Ò¯")>0)
		{
			return 52;
		}
		if(src.indexOf("µÜµÜ")>0 && src.lastIndexOf("¶ù×Ó")>0)
		{
			return 53;
		}
		if(src.indexOf("µÜµÜ")>0 && src.lastIndexOf("Ëï×Ó")>0)
		{
			return 54;
		}
		if(src.indexOf("µÜµÜ")>0 && src.lastIndexOf("¸ç¸ç")>0)
		{
			return 55;
		}
		if(src.indexOf("µÜµÜ")>0 && src.lastIndexOf("µÜµÜ")>0)
		{
			return 56;
		}
		if(src.indexOf("µÜµÜ")>0 && src.lastIndexOf("Ñ§Éú")>0)
		{
			return 57;
		}
		if(src.indexOf("µÜµÜ")>0 && src.lastIndexOf("ÀÏÊ¦")>0)
		{
			return 58;
		}
		if(src.indexOf("µÜµÜ")>0 && src.lastIndexOf("Í¬Ñ§")>0)
		{
			return 59;
		}
		if(src.indexOf("µÜµÜ")>0 && src.lastIndexOf("Ëï×Ó")>0)
		{
			return 60;
		}
		
		
		//ÐÖµÜ
		if(src.indexOf("ÐÖµÜ")>0 && src.lastIndexOf("°Ö°Ö")>0)
		{
			return 61;
		}
		if(src.indexOf("ÐÖµÜ")>0 && src.lastIndexOf("Ò¯Ò¯")>0)
		{
			return 62;
		}
		if(src.indexOf("ÐÖµÜ")>0 && src.lastIndexOf("¶ù×Ó")>0)
		{
			return 63;
		}
		if(src.indexOf("ÐÖµÜ")>0 && src.lastIndexOf("Ëï×Ó")>0)
		{
			return 64;
		}
		if(src.indexOf("ÐÖµÜ")>0 && src.lastIndexOf("¸ç¸ç")>0)
		{
			return 65;
		}
		if(src.indexOf("ÐÖµÜ")>0 && src.lastIndexOf("µÜµÜ")>0)
		{
			return 66;
		}
		if(src.indexOf("ÐÖµÜ")>0 && src.lastIndexOf("Ñ§Éú")>0)
		{
			return 67;
		}
		if(src.indexOf("ÐÖµÜ")>0 && src.lastIndexOf("ÀÏÊ¦")>0)
		{
			return 68;
		}
		if(src.indexOf("ÐÖµÜ")>0 && src.lastIndexOf("Í¬Ñ§")>0)
		{
			return 69;
		}
		if(src.indexOf("ÐÖµÜ")>0 && src.lastIndexOf("Ëï×Ó")>0)
		{
			return 70;
		}
		
		//Ëï×Ó
		if(src.indexOf("Ëï×Ó")>0 && src.lastIndexOf("°Ö°Ö")>0)
		{
			return 71;
		}
		if(src.indexOf("Ëï×Ó")>0 && src.lastIndexOf("Ò¯Ò¯")>0)
		{
			return 72;
		}
		if(src.indexOf("Ëï×Ó")>0 && src.lastIndexOf("¶ù×Ó")>0)
		{
			return 73;
		}
		if(src.indexOf("Ëï×Ó")>0 && src.lastIndexOf("Ëï×Ó")>0)
		{
			return 74;
		}
		if(src.indexOf("Ëï×Ó")>0 && src.lastIndexOf("¸ç¸ç")>0)
		{
			return 75;
		}
		if(src.indexOf("Ëï×Ó")>0 && src.lastIndexOf("µÜµÜ")>0)
		{
			return 76;
		}
		if(src.indexOf("Ëï×Ó")>0 && src.lastIndexOf("Ñ§Éú")>0)
		{
			return 77;
		}
		if(src.indexOf("Ëï×Ó")>0 && src.lastIndexOf("ÀÏÊ¦")>0)
		{
			return 78;
		}
		if(src.indexOf("Ëï×Ó")>0 && src.lastIndexOf("Í¬Ñ§")>0)
		{
			return 79;
		}
		if(src.indexOf("Ëï×Ó")>0 && src.lastIndexOf("Ëï×Ó")>0)
		{
			return 80;
		}
		
		//ÀÏÊ¦
		if(src.indexOf("ÀÏÊ¦")>0 && src.lastIndexOf("°Ö°Ö")>0)
		{
			return 81;
		}
		if(src.indexOf("ÀÏÊ¦")>0 && src.lastIndexOf("Ò¯Ò¯")>0)
		{
			return 82;
		}
		if(src.indexOf("ÀÏÊ¦")>0 && src.lastIndexOf("¶ù×Ó")>0)
		{
			return 83;
		}
		if(src.indexOf("ÀÏÊ¦")>0 && src.lastIndexOf("Ëï×Ó")>0)
		{
			return 84;
		}
		if(src.indexOf("ÀÏÊ¦")>0 && src.lastIndexOf("¸ç¸ç")>0)
		{
			return 85;
		}
		if(src.indexOf("ÀÏÊ¦")>0 && src.lastIndexOf("µÜµÜ")>0)
		{
			return 86;
		}
		if(src.indexOf("ÀÏÊ¦")>0 && src.lastIndexOf("Ñ§Éú")>0)
		{
			return 87;
		}
		if(src.indexOf("ÀÏÊ¦")>0 && src.lastIndexOf("ÀÏÊ¦")>0)
		{
			return 88;
		}
		if(src.indexOf("ÀÏÊ¦")>0 && src.lastIndexOf("Í¬Ñ§")>0)
		{
			return 89;
		}
		if(src.indexOf("ÀÏÊ¦")>0 && src.lastIndexOf("Ëï×Ó")>0)
		{
			return 90;
		}
		
		//Í¬Ñ§
		if(src.indexOf("Í¬Ñ§")>0 && src.lastIndexOf("°Ö°Ö")>0)
		{
			return 91;
		}
		if(src.indexOf("Í¬Ñ§")>0 && src.lastIndexOf("Ò¯Ò¯")>0)
		{
			return 92;
		}
		if(src.indexOf("Í¬Ñ§")>0 && src.lastIndexOf("¶ù×Ó")>0)
		{
			return 93;
		}
		if(src.indexOf("Í¬Ñ§")>0 && src.lastIndexOf("Ëï×Ó")>0)
		{
			return 94;
		}
		if(src.indexOf("Í¬Ñ§")>0 && src.lastIndexOf("¸ç¸ç")>0)
		{
			return 95;
		}
		if(src.indexOf("Í¬Ñ§")>0 && src.lastIndexOf("µÜµÜ")>0)
		{
			return 96;
		}
		if(src.indexOf("Í¬Ñ§")>0 && src.lastIndexOf("Ñ§Éú")>0)
		{
			return 97;
		}
		if(src.indexOf("Í¬Ñ§")>0 && src.lastIndexOf("ÀÏÊ¦")>0)
		{
			return 98;
		}
		if(src.indexOf("Í¬Ñ§")>0 && src.lastIndexOf("Í¬Ñ§")>0)
		{
			return 99;
		}
		if(src.indexOf("Í¬Ñ§")>0 && src.lastIndexOf("Ëï×Ó")>0)
		{
			return 100;
		}
		return 0;
	}

}

