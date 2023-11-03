package com.infybuzz.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class FirstItemWriter implements ItemWriter<Long> {

	@Override
	public void write(List<? extends Long> items) throws Exception {
		System.out.println("Inside Item Writer");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String timestamp = dateFormat.format(new Date());
		String outputFilePath = "/Users/sourabh.verma/IdeaProjects/test" + "/output_" + timestamp + ".csv";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
			for (Long item : items) {
				String line = convertItemToCsvLine(item);
				writer.write(line);
				writer.newLine();
			}
		}
	}
	private String convertItemToCsvLine(Long item) {
		// Implement your logic to convert the item to a CSV line
		return "id,firstName,lastName"; // Replace with actual formatting logic
	}
}
