package br.com.alura.spring.data.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateUtil {

	public static Date readDate(final String firstMessage, final Scanner scan) {
		Date hiringDate = null;
		
		boolean isValidDate = false;
		while (!isValidDate) {
			System.out.println(firstMessage);
			final String hiringDateString = scan.next();
			
			try {
				hiringDate = new SimpleDateFormat("dd/MM/yyyy").parse(hiringDateString);
				isValidDate = true;
			} catch (Exception ex) {
				System.out.println("This isn't a valid date, example 21/12/2020.");
				isValidDate = false;
			}
		}
		
		return hiringDate; 
	}
	
}
