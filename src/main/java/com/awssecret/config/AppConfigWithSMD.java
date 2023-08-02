//package com.awssecret.config;

//import javax.sql.DataSource;

//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.services.secretsmanager.AWSSecretsManager;
//import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
//import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
//import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
//import com.google.gson.Gson;*/

//@Configuration
public class AppConfigWithSMD {

	//ABCD
	
	
//private Gson gson=new Gson();
//	
//	@Bean
//	DataSource dataSource() {
//		AwsSecrets awsSecrets=getSecret();
//		try {
//		System.out.println("jdbc:"+awsSecrets.getEngine()+"://"+awsSecrets.getHost()+":"+awsSecrets.getPort()+"/testDb");
//		System.out.println("userName :"+ awsSecrets.getUsername());
//		System.out.println("password :"+ awsSecrets.getPassword());
//		return DataSourceBuilder.create()
//								.url("jdbc:"+awsSecrets.getEngine()+"://"+awsSecrets.getHost()+":"+awsSecrets.getPort()+"/testDb")
//								.username(awsSecrets.getUsername())
//								.password(awsSecrets.getPassword())
//								.build();
//		}
//		catch (Exception e) {
//			System.out.println("ERROR MESSAGE :"+ e.getMessage());
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	
	
//	 private AwsSecrets getSecret() {
//
//	        String secretName = "db-credential";
//	        String region = "ap-south-1";


//	        AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard()
//	                .withRegion(region)
//	                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("AKIASL76ADM5FKK7FYOK", "d+KSGPXG9IPwXsEA/WnQxhpVOJQSeI+UMobgU6st")))
//	                .build();

//	        String secret;
//	        GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest()
//	                .withSecretId(secretName);
//	        GetSecretValueResult getSecretValueResult = null;

//	        try {
//	            getSecretValueResult = client.getSecretValue(getSecretValueRequest);
//	        } catch (Exception e) {
//	            throw e;
//	        }
//	        if (getSecretValueResult.getSecretString() != null) {
//	            secret = getSecretValueResult.getSecretString();
//	            return gson.fromJson(secret, AwsSecrets.class);
//	        }


//	        return null;
//	    }

}
