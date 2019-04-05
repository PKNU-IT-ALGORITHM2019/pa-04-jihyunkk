package assing04;


import java.util.Comparator;

public class log implements Comparable<log>{
	String ip;
	String Date;
	String URL;
	String Status;
	
	private static boolean sortType = true;	
	
	
	public log(String num,String num2,String num3,String num4) {
		ip=num;Date=num2;URL=num3;Status=num4;
		
	}
	
	
	public static Comparator<log> ipCompartor=new Comparator<log>() {
		public int compare(log log1,log log2) {
			int check = 0;
			sortType = true;

			for(int i=0; i<4; i++) {
				check = compareIP(log1.ip, log2.ip, i);
				if(check!=0)
					break;
			}
			return check;
		}

		private int compareIP(String data1, String data2, int i) {
			int num1 = Integer.parseInt(data1.split("\\.")[i]);
			int num2 = Integer.parseInt(data2.split("\\.")[i]);

			return goCompare(num1, num2);
		
		}
	};
	public static Comparator<log> timeCompartor=new Comparator<log>() {
		public int compare(log log1,log log2) {
			int check = 0;			
			sortType = false;

			String time1 = log1.Date;
			String time2 = log2.Date;

		
			int year1 = Integer.parseInt( (time1.split("/")[2]).split(":")[0] );
			int year2 = Integer.parseInt( (time2.split("/")[2]).split(":")[0] );

			check = goCompare(year1, year2);
			if( check != 0)
				return check;

			int month1 = month(time1.split("/")[1]);
			int month2 = month(time2.split("/")[1]);

			check = goCompare(month1, month2);
			if( check != 0)
				return check;

			int day1 = Integer.parseInt(time1.split("/")[0]);
			int day2 = Integer.parseInt(time2.split("/")[0]);

			check = goCompare(day1, day2);
			if( check != 0)
				return check;


			int clock1 = Integer.parseInt( ( (time1.split("/")[2]).substring(5)).replace(":", "") );
			int clock2 = Integer.parseInt( ( (time2.split("/")[2]).substring(5)).replace(":", "") );

			check = goCompare(clock1, clock2);
			return check;
		}
		private int month(String month) {	

			switch (month) {
			case "Jan":
				return 1;
			case "Feb":
				return 2;
			case "Mar":
				return 3;
			case "Apr":
				return 4;
			case "May":
				return 5;
			case "Jun":
				return 6;
			case "Jul":
				return 7;
			case "Aug":
				return 8;
			case "Sep":
				return 9;
			case "Oct":
				return 10;
			case "Nov":
				return 11;
			case "Dec":
				return 12;
			default:
				return 0;
			}
		}
	};
	
	

	private static int goCompare(int num1, int num2) {
		if(num1 > num2)
			return 1;
		else if (num1 < num2)
			return -1;
		else
			return 0;
	}



	@Override
	public int compareTo(log o) {
		// TODO Auto-generated method stub
		return 0;
	}



	
	
}


