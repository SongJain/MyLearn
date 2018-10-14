package com.songjian.learn.mapreduce;



import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class MyMapReduce {
	
	//1、自己的map类
	//继承Mapper类，<KEYIN, VALUEIN, KEYOUT, VALUEOUT>   输入的key，输入的value，输出的key，输出的value
	public static class MyMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
		//创建一个IntWritable类型的对象，给定值为1
		IntWritable i = new IntWritable(1);
		Text keystr  = new Text();
		@Override
		protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			String line = value.toString();
			//传入每一个map方法的key和value做打印
			System.out.println("key : "+key.get()+"--------- value : "+line);
			String [] strs = line.split(" ");
			for (String str : strs) {
				//每一次循环遍历到一个单词就要输出到下一个步骤
				keystr.set(str);
				System.out.println("map的输出：key : ("+str+",1)");
				context.write(keystr, i);
			}

	/*		StringTokenizer itr = new StringTokenizer(value.toString());
			    while (itr.hasMoreTokens()) {
			    	keystr.set(itr.nextToken());
			       context.write(keystr, i);
			      }*/
		}
	}
	


	
	//2自己的reduce类
	//	reduce类的输入，其实就是map类中map方法的输出							输入key  输入value  输出key  输出value
	public static class MyReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
			IntWritable countwritable = new IntWritable();
		@Override
		//Map类的map方法的数据输入到Reduce类的group方法中，得到<text,it(1,1)>，再将这个数据输入reduce类到reduce方法中
		protected void reduce(Text inputkey, Iterable<IntWritable> inputvalue,
				Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
			//得到了key
			String key = inputkey.toString();
			//迭代Iterable，把每一个值相加
			int count = 0;
			//循环遍历迭代器中的所有值，做相加
			for (IntWritable intWritable : inputvalue) {
				count = count + intWritable.get();
			}
			//把值设置到IntWritable，等待输出
			countwritable.set(count);
			System.out.println("reduce输出结果：key : "+key+" , "+ count);
			context.write(inputkey, countwritable);
		}
		
		
	}
	//3运行类，run方法，在测试的时候使用main函数，调用这个类的run方法来运行
	
	/**
	 * 
	 * @param args 参数是要接受main方法得到的参数，在run中使用
	 * @return
	 * @throws Exception
	 */
    public int run(String[] args) throws Exception {  
    	//hadoop的配置的上下文！
        Configuration configuration = new Configuration();  
        //通过上下文，构建一个job实例，并且传入任务名称，单例！
        Job job = Job.getInstance(configuration, this.getClass().getSimpleName());
        
        //这参数必须添加，否则本地运行没有问题，服务器上运行会报错
        job.setJarByClass(MyMapReduce.class);
        
        //设置任务从哪里读取数据？
        //调用这个方法的时候，要往args中传入参数，第一个位置上要传入从哪里读数据
        Path inputpath = new Path(args[0]);
        FileInputFormat.addInputPath(job, inputpath);
        //设置任务结果数据保存到哪里？
      //调用这个方法的时候，要往args中传入参数，第二个位置上要传入结果数据保存到哪里
        Path outputpath = new Path(args[1]);
        FileOutputFormat.setOutputPath(job, outputpath);
        
        //设置mapper类的参数
        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setNumReduceTasks(2);
        
        //设置reduce类的参数
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
       
        // submit job -> YARN  
        boolean isSuccess = job.waitForCompletion(true);  
        return isSuccess ? 0 : 1;  
    }  

    
    public static void main(String[] args) {
    	args= new String[]{
    			"hdfs://192.168.6.129:8020/1.txt",
    			"hdfs://192.168.6.129:8020/output"
    	};

    	MyMapReduce mr = new MyMapReduce();
    	try {
			int success = -1; 
    		success = mr.run(args);
    		System.out.println("success:"+success);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
