package com.example.app.domain;

import java.util.Calendar;

public class MyCalendarLogic {

	public MyCalendar createMyCalendar(Integer year, Integer month) {
		//マイカレンダーインスタンス生成
	MyCalendar myCalendar = new MyCalendar();
		//現在日時でカレンダーインスタンス作成
		Calendar calendar = Calendar.getInstance();
		if(year != null && month != null) {
			//その月の日数より多いと、多い分を自動で来月に繰越す
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			//最初の引数で年を設定
			calendar.set(Calendar.YEAR, year);
			//次の引数で月を設定（引数からマイナス１…）month=1は0を設定（1月）
			calendar.set(Calendar.MONTH, month-1);
		}
		//マイカレンダーに年を設定
		myCalendar.setYear(calendar.get(Calendar.YEAR));
		//マイカレンダーに月を設定
		//MONTHの戻り値は１月が0、12月が11と-1の値が返ってくるため+1する
		myCalendar.setMonth(calendar.get(Calendar.MONTH)+1);
		//その月の1日が何曜日を調べるため
		calendar.set(Calendar.DATE, 1);
		//カレンダーの最初の空白の数
		//DAY_OF_WEEKでその日の曜日を返す2023/01/01は日曜なので1//（日曜:1,月:2,火:3,,,,土:7）
		//カレンダー的な最初のブランクの数は以下の式で表せる(1日が日曜なら空白0個)
		int before = calendar.get(Calendar.DAY_OF_WEEK)-1;
		////その月が何日まであるかは以下のメソッドで求められる(1月は31日)
		int daysCount = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		//その月の最後の日が何曜日が調べる
		calendar.set(Calendar.DATE, daysCount);
		//最後の週の空白数
		int after = 7-calendar.get(Calendar.DAY_OF_WEEK);
		//全ての要素数（1日より前の空白、その月の日数、最週の空白数）
		int total = before+daysCount+after;
		//全ての要素数を7個の配列（曜日）の列数
		int rows = total/7;
		//
		String [][] data = new String[rows][7];
		//
		//Calendar now = Calendar.getInstance();
		for(int i=0;i<rows;i++) {
			for(int j=0;j<7;j++) {
				if(i==0 && j<before || i==rows-1 && j>=(7-after)) {
					//カレンダーの前後に入る空白の部分は空文字
					data[i][j]="";
				}else {
					//カウンター変数と実際の日付の変換
					int date=i*7+j+1 - before;
					//配列に日付を入れる
					data[i][j]=String.valueOf(date);
					//今作業しているマイカレンダーが今月のカレンダーだったら今日の日付の先頭に*を付与する
					//if(now.get(Calendar.DATE)== date && now.get(Calendar.MONTH) == myCalendar.getMonth()-1  && now.get(Calendar.YEAR)==myCalendar.getYear()) {
						//data[i][j]="*"+data[i][j];
					//}
				}
			}
		}
		
		myCalendar.setData(data);
		return myCalendar;
		
	}
}
	
