package de.manigdni.tests.ms2;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello-world")
public class EndpointController {

	private Random r = new Random();
	private String[] words = "Lorem ipsum dolor sit amet consetetur sadipscing elitr sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat sed diam voluptua At vero eos et accusam et justo duo dolores et ea rebum Stet clita kasd gubergren no sea takimata sanctus est Lorem ipsum dolor sit amet"
			.split(" ");

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Data> doSomething() {
		return generateData();
	}

	private List<Data> generateData() {
		List<Data> data = new LinkedList<>();
		for (long key = 0; key < 1000; key++) {
			data.add(create(key));
		}
		return data;
	}

	private Data create(long key) {
		String word = words[r.nextInt(words.length)];
		Data d = new Data();
		d.setKey(key);
		d.setValue(word);
		return d;
	}

}
