import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class VowelCount extends Configured implements Tool{

	@Override
	public int run(String[] arg0) throws Exception {
		if(arg0.length < 2) {
			System.out.println("plz give input and output directory properly");
			return -1;
		}
		JobConf conf = new JobConf(VowelCount.class);		
		FileInputFormat.setInputPaths(conf, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(conf, new Path(arg0[1]));
		conf.setMapperClass(VowelMapper.class);
		conf.setReducerClass(VowelReducer.class);
		conf.setPartitionerClass(VowelPartitioner.class);
		conf.setNumReduceTasks(4);
		conf.setMapOutputKeyClass(Text.class);
		conf.setMapOutputValueClass(Text.class);
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
		conf.setJarByClass(VowelCount.class);		
		JobClient.runJob(conf);
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(new VowelCount(), args);
		System.exit(exitCode);
	}

}
