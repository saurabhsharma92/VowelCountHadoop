import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class VowelMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text>{

	@Override
	public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter rep)
			throws IOException {
		String s = value.toString().toLowerCase();
		for(String word : s.split(" ")) {
			if(word.length() > 0 && (word.contains("a") || word.contains("e")
					|| word.contains("i") || word.contains("o") || word.contains("u"))) {
				output.collect(new Text(word), new Text(word));
			}
		}
	}

}
