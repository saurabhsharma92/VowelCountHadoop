import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Partitioner;

public class VowelPartitioner implements Partitioner<Text, Text>{

	@Override
	public void configure(JobConf conf) {
		
	}

	@Override
	public int getPartition(Text key, Text value, int setNumRedTask) {
		String sKey = key.toString();
		if(sKey.length() == 1) {
			return 0;
		}else if(sKey.length() == 2) {
			return 1;
		}else if(sKey.length() == 3) {
			return 2;
		}else {
			return 3;
		}
	}
	
}
