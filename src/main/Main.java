package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import util.Util;

public class Main{
	/**
	 * @param args
	 * @throws ParseException
	 */
	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		
		Main.fetchImage();
		
	}
	
	public static void fetchImage() throws ParseException{
		// Ĭ��ʱ���ʽ
				SimpleDateFormat defultFormatter = new SimpleDateFormat(SysteContent.getProperties(SysteContent.DEFULT_FORMATTER));
				// �����ʽ
				SimpleDateFormat formatter = new SimpleDateFormat(
						"yyyy/MM/dd/HHmmss_0_0");
				int index = 1;
				// ��ʱ����
				Calendar tempCalendar = Calendar.getInstance();
				tempCalendar.setTime(defultFormatter.parse(SysteContent.getProperties(SysteContent.START_TIME)));
				
				// ����ʱ������
				Calendar endCalendar = Calendar.getInstance();
				endCalendar.setTime(defultFormatter.parse(SysteContent.getProperties(SysteContent.END_TIME)));
				
				int allImgNumber = 0;
				
				while (true) {
					if(tempCalendar.compareTo(endCalendar)>0)
						break;
					tempCalendar.add(Calendar.MINUTE, Integer.parseInt(SysteContent.getProperties(SysteContent.MINUTES_GRIT)));
					allImgNumber++;
				}
				
				tempCalendar.setTime(defultFormatter.parse(SysteContent.getProperties(SysteContent.START_TIME)));
				while (true) {
					if(tempCalendar.compareTo(endCalendar)>0)
						break;
					String tempDateStr = formatter.format(tempCalendar.getTime());
//					System.out.println(((index<10)?" ":"")+index+":"+tempDateStr);
					
//					String tempUrl = url.append(tempDateStr).append(".png").toString();
//					String tempPath = path.append(index).append(".png").toString();
					String tempUrl = SysteContent.getProperties(SysteContent.IMG_URL)+tempDateStr+".png";
					String tempPath = SysteContent.getProperties(SysteContent.SAVE_PATH)+index+".png";
					System.out.println("����ץȡ��"+(index)+"/"+allImgNumber+"��ͼƬ");
					System.out.println("url="+tempUrl);
					new Util().saveToFile(tempUrl, tempPath);
					System.out.println("�ɹ�ץȡͼƬ����"+tempPath);
					tempCalendar.add(Calendar.MINUTE, Integer.parseInt(SysteContent.getProperties(SysteContent.MINUTES_GRIT)));
					index++;
				}
	}
}
