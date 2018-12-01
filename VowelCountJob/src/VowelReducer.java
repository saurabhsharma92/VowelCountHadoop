import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class VowelReducer extends MapReduceBase implements Reducer<Text, Text, Text, IntWritable>{

	@Override
	public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, IntWritable> output, Reporter rep)
			throws IOException {
		while(values.hasNext()) {
			int count = 0;
			String word = values.next().toString().toLowerCase();
			for(int i = 0; i < word.length() ; i++) {
				if(word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i'
						|| word.charAt(i) == 'o' || word.charAt(i) == 'u') {
					count ++;
				}
			}
			output.collect(key, new IntWritable(count));
		}
		
	}

}
