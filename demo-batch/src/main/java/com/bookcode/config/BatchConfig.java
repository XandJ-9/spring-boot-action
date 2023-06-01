package com.bookcode.config;


//import com.bookcode.batch.CsvBeanValidator;
import com.bookcode.batch.CsvItemProcessor;
import com.bookcode.batch.CsvLineMapper;
import com.bookcode.entity.Person;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

// 注解配置类
@Configuration
// 开启批处理支持
//@EnableBatchProcessing
public class BatchConfig {


    /**
     * JobRepository 注册Job的容器
     * 配置 bean
     *
     * @param dataSource
     * @param transactionManager
     * @return
     * @throws Exception
     */
    @Bean
    public JobRepository myJobRepository(DataSource dataSource, PlatformTransactionManager transactionManager) throws Exception {
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDataSource(dataSource);
        jobRepositoryFactoryBean.setTransactionManager(transactionManager);
        jobRepositoryFactoryBean.setDatabaseType("mysql");
        return jobRepositoryFactoryBean.getObject();
    }


    /**
     * JobLauncher Job的启动器
     *
     * @param jobRepository
     * @return
     * @throws Exception
     */
    @Bean
    public SimpleJobLauncher myJobLauncher(JobRepository jobRepository) throws Exception {
        SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher();
        simpleJobLauncher.setJobRepository(jobRepository);
        return simpleJobLauncher;
    }

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    /**
     * Job 定义作业任务
     * @param jobBuilderFactory
     * @param st
     * @return
     */
    @Bean
    public Job importJob(JobBuilderFactory jobBuilderFactory, Step st) {
        return jobBuilderFactory.get("importJob")
                .incrementer(new RunIdIncrementer())
                .flow(st)
                .end()
                .build();
    }


    @Bean
    public Step step(StepBuilderFactory stepBuilderFactory,
                     ItemReader<Person> reader,
                     ItemWriter<Person> writer,
                     ItemProcessor<Person, Person> processor) {
        return stepBuilderFactory.get("step")
                .<Person, Person>chunk(100)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }


    @Bean
    public ItemReader<Person> reader() {
        FlatFileItemReader<Person> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("people.csv"));

        reader.setLineMapper(new CsvLineMapper());

//        reader.setLineMapper(new DefaultLineMapper<Person>() {
//
//            @Override
//            public void setLineTokenizer(LineTokenizer tokenizer) {
//                setLineTokenizer(new DelimitedLineTokenizer() {
//                    public void setNames(String... names) {
//                        setNames("name", "age", "sex", "address", "birthday");
//                    }
//                });
//                setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {
//                    @Override
//                    public void setTargetType(Class<? extends Person> type) {
//                        setTargetType(Person.class);
//                    }
//                });
//            }
//
//        });
        return reader;
    }

    @Bean
    public ItemWriter<Person> writer(DataSource dataSource) {
        // 我们使用JDBC批处理的JdbcBatchItemWriter来写数据到数据库。
        JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        String sql = "insert into t_person (name,age,sex,address,birthday) values (:name, :age, :sex, :address, :birthday)";
        // 在此设置要执行批处理的SQL语句。
        writer.setSql(sql);
        writer.setDataSource(dataSource);
        return writer;
    }


    @Bean
    public ItemProcessor<Person, Person> process(){
        CsvItemProcessor csvItemProcessor = new CsvItemProcessor();
        csvItemProcessor.setValidator(new Validator<Person>() {
            @Override
            public void validate(Person person) throws ValidationException {
                System.out.println("validator person object");
            }
        });
        return csvItemProcessor;
    }



}
